package aula04.ex3;

import java.util.InputMismatchException;
import java.util.Scanner;
import aula04.Data;

public class ex3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Qual a cota maxima por socio :");
		int cota = Integer.parseInt(sc.nextLine());
		clientList cl = new clientList();
		Catalogo cat = new Catalogo();
		boolean con = false;
		int op = -1;
		
		while (true) {
			menu();
			try {
				System.out.printf(" ->| Opção : | ");
				op = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("ERRO");
				break;
			}
			if (chooseop(op, cl, cat,cota)==false) {
				break;
			}
		}
	}
	public static void addut(clientList cl) {
		System.out.println("----------------------------------");
		System.out.println("----- Adicionando Utilizador -----");
		System.out.printf("Estudante ou Funcionário (e/f) :");
		String tipo = sc.nextLine();
		System.out.printf("Nome : ");
		String nome = sc.nextLine();
		System.out.printf("CC : ");
		int cc = Integer.parseInt(sc.nextLine());
		boolean temp = true;
		Data dn = new Data(1,1,1);
		do {
			try {
				System.out.printf("| Data de Nascimento |\n");
				System.out.print(" | Dia : ");
				int dia = Integer.parseInt(sc.nextLine());
				System.out.print(" | Mes : ");
				int mes = Integer.parseInt(sc.nextLine());
				System.out.print(" | Ano : ");
				int ano = Integer.parseInt(sc.nextLine());
				dn = new Data(dia,mes,ano);
				System.out.printf("----------------------\n");
				break;
			} catch (InputMismatchException e) {
				System.out.println("Valor introduzido invalido");
				temp = false;
			} 
		} while (temp);
		temp = true;
		Data di = new Data(1,1,1);
		do {
			try {
				System.out.printf("| Data de Inscrição |\n");
				System.out.print(" | Dia : ");
				int dia = Integer.parseInt(sc.nextLine());
				System.out.print(" | Mes : ");
				int mes = Integer.parseInt(sc.nextLine());
				System.out.print(" | Ano : ");
				int ano = Integer.parseInt(sc.nextLine());
				di = new Data(dia,mes,ano);
				System.out.printf("----------------------\n");
				break;
			} catch (InputMismatchException e) {
				System.out.println("Valor introduzido invalido");
				temp = false;
			} 
		} while (temp);
		
		
		if (tipo.equals("e")) {
			System.out.printf("N mec : ");
			int nmec = Integer.parseInt(sc.nextLine());
			System.out.printf("Curso : ");
			String curso = sc.nextLine();
			cl.addclient(nome,cc,dn,di,nmec,curso);
		} else {
			System.out.printf("N func : ");
			int nfunc = Integer.parseInt(sc.nextLine());
			System.out.printf("NIF : ");
			int nif = Integer.parseInt(sc.nextLine());
			cl.addclient(nome,cc,dn,di,nfunc,nif);
		}
		
	}
	public static void removeut(clientList cl) {
		System.out.println("-----------------------------");
		System.out.println("---- Removendo Utilizador ----");
		System.out.printf("Qual o NºSocio do utilizador :");
		int id = Integer.parseInt(sc.nextLine());
		cl.removeclient(id);
	}
	public static void addvideo(Catalogo cl) {
		System.out.println("-----------------------------");
		System.out.println("----- Adicionando Video -----");
		System.out.printf("Titulo: ");
		String titulo = sc.nextLine();
		System.out.printf("Categoria : ");
		String categoria = sc.nextLine();
		System.out.printf("Idade (ALL, M6, M12, M16, M18): ");
		String idade = sc.nextLine();
		Catalogo.add(titulo, categoria, idade);
	}
	public static void removevid(Catalogo cat) {
		System.out.println("-----------------------------");
		System.out.println("------ Removendo Video ------");
		System.out.printf("ID: ");
		int id = Integer.parseInt(sc.nextLine());
		cat.rem(id);
		
		
	}
	public static void searchvideos(Catalogo cat) {
		System.out.println("-----------------------------");
		System.out.println("----- Pesquisa de Videos ----");
		System.out.printf("Qual o nome do Video : ");
		String nome = sc.nextLine();
		try {
			Video v = cat.searchbyname(nome);
			if (v.id() == 666) { // Nao existe
				System.out.println("Video nao encontrado");
			}else {
				System.out.println(" --------Video Encontrado--------- ");
				System.out.printf(" | %2s | %15s | %10s | %4s | %6s | \n","id","Título","Categoria","Idade","Rating");
				System.out.println(v.toString());
			}
		} catch (Exception e) {
			System.out.println("Video nao encontrado");
		}
		
	}
	public static void listvideos(clientList cl, Catalogo cat) {
		System.out.println("-----------------------------");
		System.out.println("------ Listando Videos ------");
		System.out.printf(" Qual o NºSocio do utilizador : ");
		int id = Integer.parseInt(sc.nextLine());
		int idade = cl.getidade(id);
		cat.showList(idade);
	}
	public static void videostate(Catalogo cat) {
		System.out.println("---------------------------------");
		System.out.println("-- Listando Videos Disponiveis --");
		if (!cat.showavailable().equals("")) {
			System.out.println(" --------Videos Disponiveis--------- ");
			System.out.printf(" | %2s | %15s | %10s | %4s | %6s | \n","id","Título","Categoria","Idade","Rating");
			System.out.println(cat.showavailable());
		}else {
			System.out.println("Não existem videos disponiveis");
		}
	}
	public static void emprestimo(Catalogo cat, clientList cl, int cota) {
		System.out.println("------------------------------");
		System.out.println("---- Efetuando Emprestimo ----");
		System.out.printf("Qual o NSocio : ");
		int n = Integer.parseInt(sc.nextLine());
		System.out.printf("Qual o ID do Video : ");
		int id = Integer.parseInt(sc.nextLine());
		if (cl.getcl(n).vistos()<cota && cat.getVideo(id).emprestimo(n, cl) == true) {
			cl.getcl(n).addvid(cat.getVideo(id));
			System.out.println("Emprestimo feito");
		}else {
			System.out.println("Emprestimo cancelado");
			if (cl.getcl(n).vistos()>cota) {
				System.out.println("Cota maxima ja adquirida");
			}
		}		
	}
	public static void devolucao(Catalogo cat) {
		System.out.println("-------------------------------");
		System.out.println("----- Efetuando Devoluçao -----");
		System.out.printf("Qual o NºSocio do Utilizador : ");
		int id = Integer.parseInt(sc.nextLine());
		cat.devolucao(id);
	}
	public static void showusers(Catalogo cat) {
		System.out.println("------------------------------------");
		System.out.println("--- Mostrar Utlizadores p/ Video ---");
		System.out.printf(" Qual o ID do Video :");
		int id = Integer.parseInt(sc.nextLine());
		cat.getVideo(id).showvis();
	}
	public static void showbyrating(Catalogo cat) {
		System.out.println("----------------------------------");
		System.out.println("--- Mostrar Videos por  Rating ---");
		System.out.printf("Introduza rating : ");
		double r = Double.parseDouble(sc.nextLine());
		System.out.println(cat.showbyrating(r));
		
	}
	public static void menu() {
		System.out.println();
		System.out.println(" ----------------------------------- ");
		System.out.println(" |             Menu:               | ");
		System.out.println(" ----------------------------------- ");
		System.out.println(" | 1  - Introdução de Utilizadores | ");
		System.out.println(" | 2  - Remoção de Utilizadores    | ");
		System.out.println(" | 3  - Pesquisar Videos           | ");
		System.out.println(" | 4  - Lista de Videos            | ");
		System.out.println(" | 5  - Introdução de Video        | ");
		System.out.println(" | 6  - Remoçao de Video           |");
		System.out.println(" | 7  - Disponiblidade de Videos   |");
		System.out.println(" | 8  - Efetuar Emprestimos        |");
		System.out.println(" | 9  - Efetuar Devolução          | ");
		System.out.println(" | 10 - Utilizadores por Video     | ");
		System.out.println(" | 11 - Listar Videos por Rating   | ");
		System.out.println(" | 0  - Sair                       |");
		System.out.println(" ---------------------------------- ");
	}
	public static boolean chooseop(int op, clientList cl, Catalogo cat, int cota) {
		boolean cont = true;
		switch (op) {
		case 1:
			addut(cl);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 2:
			removeut(cl);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 3:
			searchvideos(cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 4 :
			listvideos(cl, cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 5:
			addvideo(cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 6:
			removevid(cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 7:
			videostate(cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 8:
			emprestimo(cat, cl,cota);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 9:
			devolucao(cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 10:
			showusers(cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 11:
			showbyrating(cat);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 0:
			System.out.println(" -----Saindo----- ");
			cont = false;
			break;
		default:
			break;
		}
		return cont;
	}
}
