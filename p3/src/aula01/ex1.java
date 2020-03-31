package aula01;

import java.util.*;

public class ex1 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Introduza a frase: ");
		String f = sc.nextLine();
		System.out.println("\nInfo :");
		System.out.printf("Número de caracteres numéricos : %d \n",number(f));
		if (onlyLower(f)) {
			System.out.println("Só tem letras minusculas \n ");
		} else if(onlyUpper(f)){
			System.out.println("Só tem letras maiusculas \n");
		}
		System.out.printf("\nNúmero de palavras : %d \n",nwords(f));
		System.out.println("Letras trocadas : ");
		switchlet(f);
		System.out.println();

	}
	public static int number(String f) {
		int x = 0;
		for (int i = 0; i < f.length(); i++) {
			if (Character.isDigit(f.charAt(i))) {
				x++;
			}
		}
		return x;
	}
	public static boolean onlyLower(String f) {
		for (int i = 0; i < f.length(); i++) {
			if (Character.isUpperCase(f.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public static boolean onlyUpper(String f) {
		for (int i = 0; i < f.length(); i++) {
			if (Character.isLowerCase(f.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public static int nwords(String f) {
		int c = 1;
		System.out.println("Palavras: ");
		for (int i = 0; i < f.length(); i++) {
			if (Character.isWhitespace(f.charAt(i))) {
				c++;
				System.out.print(" - ");
			}else {
				System.out.print(f.charAt(i));
			}
		}
		System.out.println();
		return c++;
	}
	public static void switchlet(String f) {
		int j = 0;
		for (int i = 0; i < f.length()-1; i++) {
			j = i+1;
			System.out.print(f.charAt(j));
			System.out.print(f.charAt(i));
			i++;
		}
		System.out.print(f.charAt(f.length()-1));
	}
	
}
	
