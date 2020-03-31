package aula05.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import aula05.Data;

public class TestAgenda {
	
	public static void main(String args[]) throws IOException {
		// Ficheiros
		
		Scanner sc = new Scanner(System.in);
		Agenda a = new Agenda();
		while (true) {
			menu();
			String op = sc.nextLine();
			System.out.println();
			switch (op) {
			case "1":
				see(a);
				break;
			case "2":
				add(a);
				break;
			case "3":
				
				break;

			default:
				break;
			}
		}
		
	}
	public static void see(Agenda a) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nome do ficheiro :");
		String f = sc.next(); 
		Pessoa tmp[] = a.see(new File("/home/maria/Documents/P_III/p3/src/aula05/ex3/"+f));
		System.out.println();
		System.out.println("-------Contactos-------");
		int cont =0;
		for (Pessoa pessoa : tmp) {
			cont++;
			System.out.println(" "+cont+" - "+pessoa);
			
		}
		
	}
	public static void add(Agenda a) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nome do ficheiro destino:");
		String f = sc.nextLine();
		File fi = new File("/home/maria/Documents/P_III/p3/src/aula05/ex3/"+f);
		System.out.print("Nome :");
		String nome = sc.nextLine();
		System.out.print("CC:");
		int cc = Integer.parseInt(sc.nextLine());
		System.out.println("Data :");
		System.out.print("	Dia:");
		int dia = Integer.parseInt(sc.nextLine());
		System.out.print("	Mes:");
		int mes = Integer.parseInt(sc.nextLine());
		System.out.print("	Ano:");
		int ano = Integer.parseInt(sc.nextLine());
		Pessoa tmp = new Pessoa(nome,cc,new Data(dia,mes,ano));
		a.add(fi, tmp);
		
		
	}
		
	public static void menu() {
		System.out.println();
		System.out.println("Menu");
		System.out.println(" 1 - Import contacts from file");
		System.out.println(" 2 - Add contacts to file");
		System.out.printf("Op :");
	}
	
}
