package aula06.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Ementap {
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Alimento> ingredientes;
	static LinkedList<Prato> pratos ;
	static Ementa e ;
	public static void main(String[] args) throws IOException {
		ingredientes = new LinkedList<Alimento>();
		pratos = new LinkedList<Prato>();
		System.out.println(" | Pretende :");
		System.out.println(" | 1 - Carregar info de ficheiro");
		System.out.println(" | 2 - Criar nova ementa");
		int op2;
		try {
			System.out.printf(" ->| Opção : | ");
			op2 = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("ERRO");
			return;
		}
		e= null ;
		File f = new File("/home/maria/Documents/P_III/p3/src/aula06/ex1/ementa.txt");
		if (op2==2) {
			System.out.println("Info do restaurante ");
			System.out.printf("Nome :");
			String nomer = sc.nextLine();
			System.out.printf("Local :");
			String localr = sc.nextLine();
			e = new Ementa(nomer,localr);
			f = createFile(e);
		}else {
			readfile(f);
		}
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
			if (chooseop(op,ingredientes,pratos,e, f)==false) {
				break;
			}
		}
	}
	public static File createFile(Ementa e) throws IOException {
		File f = new File("/home/maria/Documents/P_III/p3/src/aula06/ex1/ementa.txt");
		System.out.println("-------Criando ficheiro-------");
		f.createNewFile();
		PrintWriter pw = new PrintWriter(f);
		pw.println(e.getinfo());
		pw.println("ing");
		System.out.println(" -----Done----- ");
		pw.close();
		return f;
	}
	public static void readfile(File f) throws FileNotFoundException {
		Scanner fish = new Scanner(f);
		String infol = fish.nextLine();
		String tmp[] = infol.split("/");
		ingredientes = new LinkedList<Alimento>();
		pratos = new LinkedList<Prato>();
		e = new Ementa(tmp[0],tmp[1]);
		while (fish.hasNextLine()) {
			String line = fish.nextLine();
			if (line.equals("ing")) {
				while (fish.hasNextLine()) {
					String ning = fish.nextLine();
					if (ning.equals("ing")) {
						break;
					}
					String inginfo[] = ning.split("#");
					if (inginfo[0].contains("Carne")) {
						String[] tipo = inginfo[0].split(" ");
						String v = tipo[1];
						System.out.println(v);
						ingredientes.add(new Carne(VariedadeCarne.valueOf(v),Double.parseDouble(inginfo[1]),Double.parseDouble(inginfo[2]),Double.parseDouble(inginfo[3])));
					}
					if (inginfo[0].contains("Peixe")) {
						String[] tipo = inginfo[0].split(" ");
						String v = tipo[1];
						ingredientes.add(new Peixe(TipoPeixe.valueOf(v),Double.parseDouble(inginfo[1]),Double.parseDouble(inginfo[2]),Double.parseDouble(inginfo[3])));
					}					
				}
			}else if (line.equals("pratos")) {
				Prato ptmp = null;
				while (fish.hasNextLine()) {
					String ning = fish.nextLine();
					if (ning.equals("pratos")) {
						break;
					}
					if (ning.contains("->")) {
						String t[] = ning.split("->");
						String c[] = t[0].split("#");
						if (c[0].contains("Carne")) {
							String[] tipo = c[0].split(" ");
							String v = c[1];
							ptmp.addIngrediente(new Carne(VariedadeCarne.valueOf(v),Double.parseDouble(c[1]),Double.parseDouble(c[2]),Double.parseDouble(c[3])));
						}else if (c[0].contains("Peixe")) {
							String[] tipo = c[0].split(" ");
							String v = c[1];
							ptmp.addIngrediente(new Peixe(TipoPeixe.valueOf(v),Double.parseDouble(c[1]),Double.parseDouble(c[2]),Double.parseDouble(c[3])));
						}
					}else if (!ning.isBlank()) {
						String inf[] = ning.split("#");
						ptmp = new Prato(inf[0]);
					}
				}
			}else if (line.equals("ementa")) {
				int x = -1;
				Prato ptmp = null;
				while (fish.hasNextLine()) {
					String ning = fish.nextLine();
					if (ning.equals("fi")) {
						break;
					}else if (ning.contains("->")) {
						String t[] = ning.split("->");
						String c[] = t[0].split("#");
						if (c[0].contains("Carne")) {
							String[] tipo = c[0].split(" ");
							String v = c[1];
							System.out.println(v);
							ptmp.addIngrediente(new Carne(VariedadeCarne.valueOf(v),Double.parseDouble(c[1]),Double.parseDouble(c[2]),Double.parseDouble(c[3])));
						}
						if (c[0].contains("Peixe")) {
							String[] tipo = c[0].split(" ");
							String v = c[1];
							ptmp.addIngrediente(new Peixe(TipoPeixe.valueOf(v),Double.parseDouble(c[1]),Double.parseDouble(c[2]),Double.parseDouble(c[3])));
						}
					}else {
						boolean t = true;
						try {
							x = Integer.parseInt(ning);
						} catch (NumberFormatException e2) {
							t = false;
							String g[] = ning.split("#"); 
							ptmp = new Prato(g[0]);
						}
					}
					if (x!=-1) {
						e.addPrato(ptmp, DiaSemana.byIndex(x));
					}
				}
			}
		}
		System.out.println(" -----Saindo----- ");
		
	}
	public static void updatefile(File f, Ementa e, LinkedList<Alimento> ingredientes,LinkedList<Prato> pratos) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(f);
		pw.println(e.getinfo());
		pw.println("ing");
		if (ingredientes.isEmpty()) {
			pw.println();
		}else {
			for (Alimento alimento : ingredientes) {
				pw.println(alimento.getNome()+"#"+alimento.calorias()+"#"+alimento.proteinas()+"#"+alimento.peso());
			}
		}
		pw.println("ing");
		pw.println("pratos");
		if (pratos.isEmpty()) {
			pw.println();
		}else {
			for (Prato prato : pratos) {
				pw.println(prato.writeprato());
			}
		}
		pw.println("pratos");
		pw.println("ementa");
		pw.println(e.writeementa());
		pw.println("fi");
		pw.close();
	}
	public static void adding(LinkedList<Alimento> ingredientes) {
		//Scanner sc = new Scanner(System.in);
		int op = -1;
		System.out.println("-----------------------------");
		System.out.println("-- Adicionando Ingrediente --");
		System.out.println(" 1 - Adicionar Carne");
		System.out.println(" 2 - Adicionar Peixe");
		System.out.println(" 3 - Adicionar Cereal");
		System.out.println(" 4 - Adicionar Legume");
		try {
			System.out.printf(" ->| Opção : | ");
			op = Integer.parseInt(sc.nextLine());
		} catch (InputMismatchException e) {
			System.out.println("ERRO");
			return;
		}
		System.out.printf("| Informações do ALimento |\n");
		System.out.print(" | Calorias : ");
		double cal = Double.parseDouble(sc.nextLine());
		System.out.print(" | Proteínas : ");
		double prot = Double.parseDouble(sc.nextLine());
		System.out.print(" | Peso : ");
		double peso = Double.parseDouble(sc.nextLine());
		switch (op) {
		case 1:
			System.out.print(" | Variedade da Carne : ");
			String var = sc.nextLine();
			ingredientes.add(new Carne( VariedadeCarne.valueOf(var) ,prot,cal,peso));
			break;
		case 2:
			System.out.print(" | Tipo de Peixe : ");
			String varp = sc.nextLine();
			
			ingredientes.add(new Peixe( TipoPeixe.valueOf(varp) ,prot,cal,peso));
			break;
		case 3:
			System.out.print(" | Nome dos Cereais : ");
			String nome = sc.nextLine();
			
			ingredientes.add(new Cereal( nome ,prot,cal,peso));
			break;
		case 4:
			System.out.print(" | Nome do Legume : ");
			String nl = sc.nextLine();
			
			ingredientes.add(new Legume( nl ,prot,cal,peso));
			break;
		default:
			break;
		}
		
	}
	public static void criarprato(LinkedList<Prato> pratos) {
		System.out.println("-------------------------------");
		System.out.println("-------- Criando Prato --------");
		System.out.print(" | Nome : ");
		String nome = sc.nextLine();
		pratos.add(new Prato(nome));
	}
	public static void removerprato(LinkedList<Prato> pratos) {
		System.out.println("---------------------------------");
		System.out.println("-------- Removendo Prato --------");
		if (pratos.size()==0) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		for (int i = 0; i < pratos.size(); i++) {
			System.out.println(" -> |"+i+"| "+pratos.get(i).getNome());
		}
		System.out.println();
		System.out.printf(" | Index do prato: ");
		int i = Integer.parseInt(sc.nextLine());
		pratos.remove(i);
		
	}
	public static Prato selectprato(LinkedList<Prato> pratos) {
		System.out.println("-----------------------------------");
		System.out.println("-------- Selecinando Prato --------");
		if (pratos.size()==0) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return null;
		}
		showPratos(pratos);
		System.out.println();
		System.out.printf(" | Index do prato: ");
		int i = Integer.parseInt(sc.nextLine());
		System.out.println("| Prato Selecinado : "+pratos.get(i));
		return pratos.get(i);	
		
	}
	public static void showPratos(LinkedList<Prato> pratos) {
		if (pratos == null) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		if (pratos.size()==0) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		for (int i = 0; i < pratos.size(); i++) {
			System.out.println(" -> |"+i+"| "+pratos.get(i).getNome());
		}
	}
	public static void showIng(LinkedList<Alimento> ingredientes) {
		for (int i = 0; i < ingredientes.size(); i++) {
			System.out.println(" -> |"+i+"| "+ingredientes.get(i).getNome());
		}
	}
	public static void addingp(LinkedList<Prato> pratos, LinkedList<Alimento> ingredientes) {
		Prato tmp = selectprato(pratos);
		System.out.println("-----------------------------------");
		System.out.println("----- Adicionando Ingrediente -----");
		if (ingredientes.size()==0) {
			System.out.println("ERRO - Sem ingredientes disponiveis");
			return;
		}
		showIng(ingredientes);
		System.out.println();
		System.out.printf(" | Index do Ingrediente: ");
		int i = Integer.parseInt(sc.nextLine());
		System.out.println("-----------------------------------");
		System.out.println("| Adicionando :=> "+ingredientes.get(i));
		tmp.addIngrediente(ingredientes.get(i));
	}
	public static void remingp(LinkedList<Prato> pratos, LinkedList<Alimento> ingredientes) {
		Prato tmp = selectprato(pratos);
		if (tmp==null) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		System.out.println("---------------------------------");
		System.out.println("----- Removendo Ingrediente -----");
		if (ingredientes.size()==0) {
			System.out.println("ERRO - Sem ingredientes disponiveis");
			return;
		}
		showIng(ingredientes);
		System.out.println();
		System.out.printf(" | Index do Ingrediente: ");
		int i = Integer.parseInt(sc.nextLine());
		System.out.println("-----------------------------------");
		System.out.println("| Removendo :=> "+ingredientes.get(i));
		tmp.remIngrediente(ingredientes.get(i));
	}
	public static void addprato(LinkedList<Prato> pratos, Ementa ementa) {
		Prato tmp = selectprato(pratos);
		if (tmp==null) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		System.out.println("---------------------------------");
		System.out.println("----- Adicionando Prato -----");
		System.out.println(" | Dia da Semana : ");
		System.out.println(" | 0 -> Segunda  ");
		System.out.println(" | 1 -> Terça  ");
		System.out.println(" | 2 -> Quarta ");
		System.out.println(" | 3 -> Quinta ");
		System.out.println(" | 4 -> Sexta ");
		System.out.println(" | 5 -> Sabado ");
		System.out.println(" | 6 -> Domingo ");
		System.out.println(" | 7 -> Quarta ");
		System.out.println(" | 8 -> -RANDOM- ");
		System.out.printf(" ->| Opção : | ");
		int op = Integer.parseInt(sc.nextLine());
		if (op==8) {
			ementa.addPrato(tmp, DiaSemana.rand());
		}else {
			ementa.addPrato(tmp, DiaSemana.byIndex(op));
		}
	}
	public static void showementa(Ementa ementa) {
		if (ementa.isEmpty()) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		ementa.toString();
	}
	public static void remprato(Ementa ementa) {
		System.out.println("---------------------------");
		System.out.println("----- Removendo Prato -----");
		if (ementa.isEmpty()) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		String tm = ementa.toString();
		if (tm.isBlank()) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		System.out.println(" | Ementa : ");
		System.out.println(ementa.toString());
		System.out.println();
		System.out.println(" | Dia da Semana: ");
		System.out.println(" | 0 -> Segunda  ");
		System.out.println(" | 1 -> Terça  ");
		System.out.println(" | 2 -> Quarta ");
		System.out.println(" | 3 -> Quinta ");
		System.out.println(" | 4 -> Sexta ");
		System.out.println(" | 5 -> Sabado ");
		System.out.println(" | 6 -> Domingo ");
		System.out.println(" | 7 -> Quarta ");
		System.out.println(" | 8 -> -RANDOM- ");
		System.out.printf(" ->| Opção : | ");
		int op = Integer.parseInt(sc.nextLine());
		DiaSemana d ;
		if (op==8) {
			d = DiaSemana.rand();
		}else {
			d = DiaSemana.byIndex(op);
		}
		LinkedList<Prato> tmp = ementa.pratosbysemana(d);
		if (tmp==null) {
			showPratos(tmp);
			return;
		}
		showPratos(tmp);
		System.out.println();
		System.out.printf(" | Index do prato: ");
		int i = Integer.parseInt(sc.nextLine());
		System.out.println("| Prato Selecinado : "+tmp.get(i));
		ementa.remPrato(tmp.get(i), d);		
	}
	
	public static boolean chooseop(int op, LinkedList<Alimento> ingredientes,LinkedList<Prato> pratos, Ementa ementa, File f) throws FileNotFoundException {
		boolean cont = true;
		switch (op) {
		case 1:
			adding(ingredientes);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 2:
			criarprato(pratos);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 3:
			removerprato(pratos);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 4 :
			selectprato(pratos);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 5:
			addingp(pratos, ingredientes);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 6:
			remingp(pratos, ingredientes);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 7:
			addprato(pratos, ementa);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 8:
			remprato(ementa);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 9:
			System.out.println("------------------");
			System.out.println("----- Ementa -----");
			System.out.println(e);
			System.out.println(" -----Done----- ");
			System.out.println("--> faça enter para mostrar menu");
			sc.nextLine();
			break;
		case 10:
			updatefile(f, ementa, ingredientes, pratos);
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

	public static void menu() {
		System.out.println();
		System.out.println(" --------------------------------------- ");
		System.out.println(" |                Menu:                | ");
		System.out.println(" --------------------------------------- ");
		System.out.println(" | 1   - Adicionar Ingrediente         | ");
		System.out.println(" | 2   - Criar Prato                   | ");
		System.out.println(" | 3   - Apagar Prato                  | ");
		System.out.println(" | 4   - Selecionar Prato              | ");
		System.out.println(" | 5   - Adicionar Ingrediente a Prato | ");
		System.out.println(" | 6   - Remover Ingrediente a Prato   | ");
		System.out.println(" | 7   - Adicionar Prato a Ementa      | ");
		System.out.println(" | 8   - Remover Prato a Ementa        | ");
		System.out.println(" | 9   - Imprimir Ementa               | ");
		System.out.println(" | 10  - Guardar Ementa                | ");
		System.out.println(" | 0   - Sair                          | ");
		System.out.println(" --------------------------------------- ");
		
	}
}
