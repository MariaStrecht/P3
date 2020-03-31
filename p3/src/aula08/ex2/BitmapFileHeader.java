package aula08.ex2;

import java.io.RandomAccessFile;

public class BitmapFileHeader {
	short type; // must be 'BM' to declare a bmp-file
	int size; // specifies the size of the file in bytes
	short reserved1; // must always be set to zero
	short reserved2; // must always be set to zero
	int offBits; // specifies the offset from the
	// beginning of the file to the bitmap data
	
	public BitmapFileHeader(RandomAccessFile imfile) {
		try {
			this.type = Short.reverseBytes(imfile.readShort());
			this.size = Integer.reverseBytes(imfile.readInt());
			this.reserved1 = Short.reverseBytes(imfile.readShort());
			this.reserved2 = Short.reverseBytes(imfile.readShort());
			this.offBits = Integer.reverseBytes(imfile.readInt());
		} catch (Exception e) {
			System.out.println("|ERRO| -> ao ler ficheiro");
		}
		
	}
	
	@Override
	public String toString() {
		return "|	File Header	|"+
				"\nTipo :"+this.type+
				"\nTamanho :"+this.size+
				"\nReserved1 :"+this.reserved1+
				"\nReserved2 :"+this.reserved2+
				"\nOffBits :"+this.offBits;
	}
	
}
