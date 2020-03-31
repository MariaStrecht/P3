package aula07.ex2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bitmap{
	public static BitmapFileHeader bitmapFileHeader;
	public static BitmapInfoHeader bitmapInfoHeader;
	public static byte[] data; // pixel data
	
	
	
	public static void create2(String path) throws IOException {
		RandomAccessFile file = new RandomAccessFile(path,"r");
		/*READS THE PIXEL DATA*/
		int byteDataLength = (int)file.length()-bitmapFileHeader.offBits;
		data = new byte[byteDataLength];
		file.read(data);
		file.close();
	}
	
}
