package aula08.ex2;

import java.io.RandomAccessFile;

public class BitmapInfoHeader {
	int size; // the size of this header (40 bytes)
	int width; // the bitmap width in pixels
	int height; // the bitmap height in pixels
	short planes; // the number of color planes being used. Must be set to 1
	short bitCount; // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
	int compression; // the compression method being used
	int sizeImage; // the image size. This is the size of the raw bitmap data
	int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter)
	int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
	int clrUsed; // the number of colors in the color palette,
	// or 0 to default to 2n
	int clrImportant; // the number of important colors used,
	// or 0 when every color is important
	
	public BitmapInfoHeader(RandomAccessFile imfile) {
		try {
			this.size = Integer.reverseBytes(imfile.readInt());
			this.width = Math.abs(Integer.reverseBytes(imfile.readInt()));
			this.height = Math.abs(Integer.reverseBytes(imfile.readInt()));
			this.planes = Short.reverseBytes(imfile.readShort());
			this.bitCount = Short.reverseBytes(imfile.readShort());
			this.compression = Integer.reverseBytes(imfile.readInt());
			this.sizeImage = Integer.reverseBytes(imfile.readInt());
			this.xPelsPerMeter = Integer.reverseBytes(imfile.readInt());
			this.yPelsPerMeter = Integer.reverseBytes(imfile.readInt());
			this.clrUsed = Integer.reverseBytes(imfile.readInt());
			this.clrImportant = Integer.reverseBytes(imfile.readInt());
		} catch (Exception e) {
			System.out.println("|ERRO| -> ao ler ficheiro");
		}
	}
	
	@Override
	public String toString() {
		return "|	Info Header	|"+
				"\nTamanho :"+this.size+
				"\nLargura :"+this.width+
				"\nAltura :"+this.height+
				"\nPlanes :"+this.planes+
				"\nBitCount :"+this.bitCount+
				"\nCompressio :"+this.compression+
				"\nSizeImage :"+this.sizeImage+
				"\nxPelsPerMeter :"+this.xPelsPerMeter+
				"\nyPelsPerMeter :"+this.yPelsPerMeter+
				"\nclrUsed :"+this.clrUsed+
				"\nclrImportant :"+this.clrImportant;
	}
	
}
