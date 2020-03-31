package aula07.ex2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BitmapUtils {
	static int imgWidth = Bitmap.data.length/Bitmap.bitmapInfoHeader.height; // 3 bytes por pixel + padding
	static int noPaddingImgWidth = Bitmap.bitmapInfoHeader.width*3;
	
	public static void reduce(RandomAccessFile s) throws IOException {
		write(s ,Bitmap.bitmapInfoHeader.height/2 ,Bitmap.bitmapInfoHeader.width/2 ,Bitmap.data.length/4 +54 );
		
		for (int i = 0; i < Bitmap.bitmapInfoHeader.height; i+=2) {
			int j;
			for (j = 0; j < Bitmap.bitmapInfoHeader.width*3/2; j+=3) {
				s.write(Bitmap.data[(i * imgWidth) + j*2]);
    			s.write(Bitmap.data[(i * imgWidth) + (j*2 + 1)]);
    			s.write(Bitmap.data[(i * imgWidth) + (j*2 + 2)]);
			}
			for (int j2 = 0; j2 < j%4; j2++) {
				s.write((byte) 0);	//padding
			}
		}
	}
	
	public static void totalflip(RandomAccessFile tf) throws IOException {
		write(tf ,Bitmap.bitmapInfoHeader.width ,Bitmap.bitmapInfoHeader.height ,Bitmap.bitmapFileHeader.size);
		
		for (int i = 0; i < imgWidth; i+=3) {
			int l_bit = 0;
			for(int j  = 0; j < Bitmap.bitmapInfoHeader.height; j++) {
    			tf.write(Bitmap.data[(j * imgWidth) + i]);
    			tf.write(Bitmap.data[(j * imgWidth) + i + 1]);
    			tf.write(Bitmap.data[(j * imgWidth) + i + 2]);
	    		l_bit += 3;
	    	}

    		
    		for (int k = 0; k < l_bit%4; k++) {
    			tf.write((byte) 0);			// padding
    		}
		}
		
	}
	
	public static void hflip(RandomAccessFile hf) throws IOException {
		write(hf  ,Bitmap.bitmapInfoHeader.height ,Bitmap.bitmapInfoHeader.width ,Bitmap.bitmapFileHeader.size );
		
		for (int i =  0; i < Bitmap.bitmapInfoHeader.height; i++) { // escreve-los inversamente em relacao ao eixo x
			int l_bit = 0;
			for(int j  = noPaddingImgWidth - 3; j > -1 ; j-= 3) {		
    			hf.write(Bitmap.data[(i * imgWidth) + j]);
    			hf.write(Bitmap.data[(i * imgWidth) + j + 1]);
    			hf.write(Bitmap.data[(i * imgWidth) + j + 2]);
	    		l_bit += 3;
	    	}

    		
    		for (int k = 0; k < l_bit%4; k++) {
    			hf.write((byte) 0);			// padding
    		}
		}
		
	}
	public static void vflip(RandomAccessFile vf) throws IOException {
		write(vf ,Bitmap.bitmapInfoHeader.height ,Bitmap.bitmapInfoHeader.width ,Bitmap.bitmapFileHeader.size );
		
		for (int i = Bitmap.bitmapInfoHeader.height -1; i >= 0; i--) { // escreve-los inversamente em relacao ao eixo y
			int l_bit = 0;
			for(int j  = 0; j < imgWidth ; j+= 3) {		
				vf.write(Bitmap.data[(i * imgWidth) + j]);
    			vf.write(Bitmap.data[(i * imgWidth) + j + 1]);
    			vf.write(Bitmap.data[(i * imgWidth) + j + 2]);
	    		l_bit += 3;
	    	}

    		
    		for (int k = 0; k < l_bit%4; k++) {
    			vf.write((byte) 0);			// padding
    		}
		}
		
	}
	public static void copy(RandomAccessFile c) throws IOException {
		write(c,Bitmap.bitmapInfoHeader.height ,Bitmap.bitmapInfoHeader.width ,Bitmap.bitmapFileHeader.size );
		c.write(Bitmap.data);
	
	}
	
	public static void write(RandomAccessFile newf, int h, int w, int size) {
		try {
			newf.writeShort(Short.reverseBytes(Bitmap.bitmapFileHeader.type));
			newf.writeInt(Integer.reverseBytes(size));
			newf.writeShort(Short.reverseBytes(Bitmap.bitmapFileHeader.reserved1));
			newf.writeShort(Short.reverseBytes(Bitmap.bitmapFileHeader.reserved2));
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapFileHeader.offBits));
			
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.size));
			newf.writeInt(Integer.reverseBytes(w));
			newf.writeInt(Integer.reverseBytes(h*(-1)));
			newf.writeShort(Short.reverseBytes(Bitmap.bitmapInfoHeader.planes));
			newf.writeShort(Short.reverseBytes(Bitmap.bitmapInfoHeader.bitCount));
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.compression));
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.sizeImage));
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.xPelsPerMeter));
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.yPelsPerMeter));
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.clrUsed));
			newf.writeInt(Integer.reverseBytes(Bitmap.bitmapInfoHeader.clrImportant));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("|ERRO| -> Ao criar");
			e.printStackTrace();
		}
	}
}
