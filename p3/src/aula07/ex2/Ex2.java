package aula07.ex2;

import java.io.EOFException;
import java.io.RandomAccessFile;

import javax.sound.midi.Soundbank;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("---- PRINT INFO ----");
		try(RandomAccessFile imfile = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula07/ex2/Figura.bmp", "r")) {
			Bitmap.bitmapFileHeader = new BitmapFileHeader(imfile);
			Bitmap.bitmapInfoHeader = new BitmapInfoHeader(imfile);
			
			// print info
			System.out.println(Bitmap.bitmapFileHeader);
			System.out.println(Bitmap.bitmapInfoHeader);
			
			// ler imagem
		    byte[] pixelData = new byte[((Bitmap.bitmapInfoHeader.width+3)*Bitmap.bitmapInfoHeader.height)*3]; 
		    int size = 0;
		    try {
		    		size = imfile.read(pixelData);
	    		}
			catch (EOFException ex) {
		    		System.out.println("Figura.bmp foi lido com sucesso.");
		    } 
			finally {
				Bitmap.data = new byte[size];
				System.arraycopy(pixelData, 0, Bitmap.data, 0, size);
			}
			
		    // RAW VERSION
		    System.out.println("---- RAW VERSION ----");
		    try (RandomAccessFile rv = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula07/ex2/Figura.raw", "rw")) {
				rv.write(Bitmap.data);
				System.out.println("IMAGEM RAW CRIADA");
			} catch (Exception e) {
				System.out.println("|ERRO| -> ao criar raw");
			}
		    
		    // SMALLER VERSION
		    System.out.println("---- SMALLER VERSION ----");
		    try (RandomAccessFile sv = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula07/ex2/Figura_smaller.bmp", "rw")) {
				BitmapUtils.reduce(sv);
				System.out.println("IMAGEM REDUZIDA CRIADA (Figura_smaller.bmp)");
			} catch (Exception e) {
				System.out.println("|ERRO| -> ao criar figura reduzida");
			}
		    
		    // TOTAL FLIPPED VERSION
		    System.out.println("---- TOTAL FLIPPED VERSION ----");
		    try (RandomAccessFile tfv = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula07/ex2/Figura_tflipped.bmp", "rw")) {
				BitmapUtils.totalflip(tfv);
				System.out.println("IMAGEM FLIPPED CRIADA (Figura_tflipped.bmp)");
			} catch (Exception e) {
				System.out.println("|ERRO| -> ao criar figura invertida");
			}
		    
		    // HORIZONTAL FLIPPED VERSION
		    System.out.println("---- HORIZONTAL FLIPPED VERSION ----");
		    try (RandomAccessFile hfv = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula07/ex2/Figura_hflipped.bmp", "rw")) {
				BitmapUtils.hflip(hfv);;
				System.out.println("IMAGEM HORIZONTAL FLIPPED CRIADA (Figura_hflipped.bmp)");
			} catch (Exception e) {
				System.out.println("|ERRO| -> ao criar figura invertida");
			}
		    
		    // VERTICAL FLIPPED VERSION
		    System.out.println("---- VERTICAL FLIPPED VERSION ----");
		    try (RandomAccessFile vfv = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula07/ex2/Figura_vflipped.bmp", "rw")) {
				BitmapUtils.hflip(vfv);;
				System.out.println("IMAGEM VERTICAÇ FLIPPED CRIADA (Figura_vflipped.bmp)");
			} catch (Exception e) {
				System.out.println("|ERRO| -> ao criar figura invertida");
			}
		    
		    // COPY
		    System.out.println("---- COPY ----");
		    try (RandomAccessFile cv = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula07/ex2/Figura_copy.bmp", "rw")) {
				BitmapUtils.hflip(cv);;
				System.out.println("IMAGEM VERTICAÇ FLIPPED CRIADA (Figura_copy.bmp)");
			} catch (Exception e) {
				System.out.println("|ERRO| -> ao criar cópia");
			}
		    
			

			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		System.out.println("---- DONE ----");
		
	}

}
