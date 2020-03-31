package aula09.ex1;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable{
	Scanner sc;
	
	public ScannerAbeirense(File f) {
		try {
			sc= new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		sc.close();
	}

	@Override
	public boolean hasNext() {
	//	sc = new Scanner(System.in);
		return sc.hasNext();
	}

	public boolean hasNextLine() {
	//	sc = new Scanner(System.in);
		return sc.hasNextLine();
	}

	@Override
	public String next() {
		//sc = new Scanner(System.in);
		String word = sc.next();
		String a ="";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'v') {
				a += 'b';
			}else if (word.charAt(i) == 'V') {
				a += 'B';
			}else{
				a += word.charAt(i);
			}
		}
		return a;
		
	}
	
	public String tripas(String word) {
		word = word.replaceAll("v", "b");
		word = word.replaceAll("V", "B");
		return word;
	}
	
	public String nextLine() {
		return tripas(sc.nextLine());
	}
	
	
	
}
