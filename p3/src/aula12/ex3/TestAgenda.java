package aula12.ex3;

import aula12.reflection.plugins.CSV;
import aula12.reflection.plugins.Nokia;
import aula12.reflection.plugins.vCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class TestAgenda {
	
	public static void main(String args[]) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
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
				save(a);
				break;
			default:
				break;
			}
		}
		
	}
	public static void see(Agenda a) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("----Carregando ficheiro");
		System.out.printf("Nome do ficheiro :");
		String f = sc.next(); 
		a.load("src/aula12/ex3/"+f);
		System.out.println();
		System.out.println("---|	Contactos	|---");
		a.show_agenda();
	}
	public static AgendaPlugin create_file(Agenda a, String n) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Qual a estrutura utilizada:\n" +
				"1 - Nokia\n" +
				"2 - CSV\n" +
				"3 - vCard\n" +
				"opçao : ");
		int op = Integer.parseInt(sc.nextLine());
		File f = new File(n);
		switch (op){
			case 1:
				return new Nokia();
			case 2:
				return new CSV();
			case 3:
				return new vCard();
			default:
				System.exit(1);
		}
		return null;
	}
	public static void add(Agenda a) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("----Adicionando contacto----");
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
		a.add(tmp);
	}
	public static void save(Agenda a) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("----Criando ficheiro----");
		System.out.printf("Nome do ficheiro :");
		String n = sc.nextLine();
		a.save(n,create_file(a,n));
	}
		
	public static void menu() {
		System.out.println();
		System.out.println("--------------Menu-------------");
		System.out.println(" 1 - Import contacts from file");
		System.out.println(" 2 - Add contacts");
		System.out.println(" 3 - Save to file");
		System.out.printf("	|Op :|");
	}
	
}
