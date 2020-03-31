package aula01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex2 {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Pessoa> p = new ArrayList<Pessoa>();
	public static void main(String[] args) {
		
		while(true) {
			menu(p);	//Quando acabar com instrução voltar a mostrar menu 
		}
	}
	static void menu(ArrayList<Pessoa> p) {
		System.out.println("|------------------------------|");
		System.out.println("||            Menu             |");
		System.out.println("|------------------------------|");
		System.out.println("|1 - Introduzir novas pessoas  |");
		System.out.println("|2 - Apagar Pessoas Existentes |");
		System.out.println("|3 - Apresentar Lista Completa |");
		System.out.println("|4 - Ordenar Lista por Nome    |");
		System.out.println("|5 - Ordenar Lista por CC      |");
		System.out.println("|------------------------------|");
		System.out.print("Selecione Opção:");
		boolean con = false;
		int op = 0;
		do {
			try {
				op = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				con = true;
			} 
		} while (con);
		switch (op) {
		case 1:
			insertPessoa(p);
			break;
		case 2:
			delete(p);
			break;
		case 3:
			showlist(p);
			break;
		case 4:
			sortbyName(p);
			break;
		case 5:
			sortbyCC(p);
			break;
		default:
			break;
		}
	}
	public static void insertPessoa(ArrayList<Pessoa> p) {
		System.out.println("Introduzindo nova pessoa: ");
		boolean temp = true;
		System.out.printf("Nome :");
		sc.nextLine();
		String n = sc.nextLine();
		
		int cc=0;
		do {
			try {
				System.out.printf("CC :");
				cc= sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Valor introduzido invalido");
				temp = false;
			} 
		} while (temp);
		temp = true;
		Data dn = new Data(1,1,1);
		do {
			try {
				System.out.printf("| Data de Nascimento |\n");
				System.out.print("Dia : ");
				int dia = sc.nextInt();
				System.out.print("Mes : ");
				int mes = sc.nextInt();
				System.out.print("Ano : ");
				int ano = sc.nextInt();
				dn = new Data(dia,mes,ano);
				
				break;
			} catch (InputMismatchException e) {
				System.out.println("Valor introduzido invalido");
				temp = false;
			} 
		} while (temp);
		Pessoa temp2 = new Pessoa(n,cc,dn);
		p.add(temp2);
		
	}
	public static void showlist(ArrayList<Pessoa> p) {
		System.out.println("Lista de Pessoas :");
		System.out.println(" i |          Nome         |     CC     | Data de Nascimento |");
		for (int i = 0; i < p.size(); i++) {
			System.out.printf(" %d | %s | \n",i,p.get(i).toString());
		}
	}
	public static void delete(ArrayList<Pessoa> p) {
		showlist(p);
		int id = 0;
		boolean temp = true;
		do {
			try {
				System.out.println("Choose person you want to delete by id");
				System.out.printf("id :");
				id = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Valor introduzido invalido");
				temp = false;
			} 
		} while (temp);
		p.remove(id);
	}
	public static void sortbyName(ArrayList<Pessoa> p) {
		String nomes[] = new String[p.size()];
		for (int i = 0; i < nomes.length; i++) {
			nomes[i] = p.get(i).nome();
		}
		Arrays.sort(nomes);	//ordenar array alfabeticamente
		System.out.println(Arrays.deepToString(nomes));
		ArrayList<Pessoa> t = new ArrayList<Pessoa>();
		for (int i = 0; i < nomes.length ; i++) {			//percorrer a lista de pessoas
			for (int j = 0; j < p.size(); j++) {		// percorer nomes ordenados
				if (p.get(j).nome() == nomes[i]) {			// colocar dados guardados na lista de pessoa na posicao do respetivo nome ordenado
					t.add(p.get(j));
				}
			}
		}
		p.clear();
		p.addAll(t); //substituir lista por lista ordenada
	}
	public static void sortbyCC(ArrayList<Pessoa> p) {
		int cc[] = new int[p.size()];
		for (int i = 0; i < cc.length; i++) {
			cc[i] = p.get(i).cc();
		}
		Arrays.sort(cc);	//ordenar array numericamente
		ArrayList<Pessoa> t = new ArrayList<Pessoa>();
		for (int i = 0; i < cc.length; i++) {			//percorrer a lista de pessoas
			for (int j = 0; j < p.size(); j++) {		// percorer nomes ordenados
				if (p.get(j).cc() == cc[i]) {			// colocar dados guardados na lista de pessoa na posicao do respetivo nome ordenado
					t.add(p.get(j));
				}
			}
		}
		p.clear();
		p.addAll(t); //substituir lista por lista ordenada
	}
	

}
