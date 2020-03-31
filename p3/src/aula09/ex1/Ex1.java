package aula09.ex1;

import java.io.File;
import java.util.Scanner;

public class Ex1 {
	
	
	public static void main(String[] args) {
		File f = new File("/home/maria/Downloads/test.txt");
		ScannerAbeirense sa = new ScannerAbeirense(f);
		while (sa.hasNextLine()) {
			System.out.println(sa.nextLine());
			
		}
	}

}
