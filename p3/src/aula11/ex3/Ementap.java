package aula11.ex3;

import java.io.*;
import java.util.*;

public class Ementap {
	static Scanner sc = new Scanner(System.in);
	static Collection<Alimento> ingredientes;
	static Collection<Prato> pratos ;
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
		if (op2==2) {
			System.out.println("Info do restaurante ");
			System.out.printf("Nome :");
			String nomer = sc.nextLine();
			System.out.printf("Local :");
			String localr = sc.nextLine();
			e = new Ementa(nomer,localr);
			updatefile(e,ingredientes,pratos);
		}else {
			readfile();
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
			if (chooseop(op,ingredientes,pratos,e)==false) {
				break;
			}
		}
	}
	public static void readfile(){
		deserialize_ementa();
		deserialize_ingredientes();
		deserialize_pratos();
		System.out.println(" -----Saindo----- ");
		
	}
	public static void save_pratos(Collection<Prato> pratos){
		try {
			FileOutputStream fos = new FileOutputStream("pratos.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(pratos);
			oos.close();
			fos.close();
			System.out.println("    + Set contendo lista de Jogos serializada e salvada em pratos.ser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void save_alimentos(Collection<Alimento> ingredientes){
		try {
			FileOutputStream fos = new FileOutputStream("ingredientes.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ingredientes);
			oos.close();
			fos.close();
			System.out.println("    + Set contendo lista de Jogos serializada e salvada em ingredientes.ser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void save_ementa(Ementa e){
		try {
			FileOutputStream fos = new FileOutputStream("ementa.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(e);
			oos.close();
			fos.close();
			System.out.println("    + Set contendo lista de Jogos serializada e salvada em ementa.ser");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void deserialize_pratos() {
		try {
			FileInputStream fis = new FileInputStream("pratos.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			pratos = (Collection<Prato>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}
	public static void deserialize_ingredientes() {
		try {
			FileInputStream fis = new FileInputStream("ingredientes.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ingredientes = (Collection<Alimento>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}
	public static void deserialize_ementa() {
		try {
			FileInputStream fis = new FileInputStream("ementa.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			e = (Ementa) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}
	public static void updatefile(Ementa e, Collection<Alimento> ingredientes,Collection<Prato> pratos){
		save_alimentos(ingredientes);
		save_pratos(pratos);
		save_ementa(e);
	}
	public static void adding(Collection<Alimento> ingredientes) {
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
	public static void criarprato(Collection<Prato> pratos) {
		System.out.println("-------------------------------");
		System.out.println("-------- Criando Prato --------");
		System.out.print(" | Nome : ");
		String nome = sc.nextLine();
		pratos.add(new Prato(nome));
	}
	public static void removerprato(Collection<Prato> pratos) {
		System.out.println("---------------------------------");
		System.out.println("-------- Removendo Prato --------");
		if (pratos.size()==0) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		Iterator<Prato> i = pratos.iterator();
		int c=0;
		while (i.hasNext()) {
			System.out.println(" -> |"+c+"| "+i.next().getNome());
			c++;
		}
		System.out.println();
		System.out.printf(" | Index do prato: ");
		int t = Integer.parseInt(sc.nextLine());
		pratos.remove(t);
		
	}
	public static Prato selectprato(Collection<Prato> pratos) {
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
		Iterator<Prato> it = pratos.iterator();
		int c=0;
		Prato tmp = null;
		while (it.hasNext()) {
			if (c==i){
				tmp = it.next();
				break;
			}
			c++;
		}
		System.out.println("| Prato Selecinado : "+tmp);
		return tmp;
		
	}
	public static void showPratos(Collection<Prato> pratos) {
		if (pratos == null) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		if (pratos.size()==0) {
			System.out.println("ERRO - Sem pratos disponiveis");
			return;
		}
		Iterator<Prato> it = pratos.iterator();
		int c=0;
		while (it.hasNext()) {
			System.out.println(" -> |"+c+"| "+it.next().getNome());
			c++;
		}
	}
	public static void showIng(Collection<Alimento> ingredientes) {
		Iterator<Alimento> it = ingredientes.iterator();
		int c=0;
		while (it.hasNext()) {
			System.out.println(" -> |"+c+"| "+it.next().getNome());
			c++;
		}
	}
	public static void addingp(Collection<Prato> pratos, Collection<Alimento> ingredientes) {
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

		Iterator<Alimento> it = ingredientes.iterator();
		int c=0;
		Alimento temp = null;
		while (it.hasNext()) {
			if (c==i){
				temp = it.next();
				break;
			}
			c++;
		}
		System.out.println("-----------------------------------");
		System.out.println("| Adicionando :=> "+temp);
		tmp.addIngrediente(temp);
	}
	public static void remingp(Collection<Prato> pratos, Collection<Alimento> ingredientes) {
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
		Iterator<Alimento> it = ingredientes.iterator();
		int c=0;
		Alimento temp = null;
		while (it.hasNext()) {
			if (c==i){
				temp = it.next();
				break;
			}
			c++;
		}
		System.out.println("-----------------------------------");
		System.out.println("| Removendo :=> "+temp);
		tmp.remIngrediente(temp);
	}
	public static void addprato(Collection<Prato> pratos, Ementa ementa) {
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
	
	public static boolean chooseop(int op, Collection<Alimento> ingredientes, Collection<Prato> pratos, Ementa ementa) throws FileNotFoundException {
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
			updatefile(e,ingredientes,pratos);
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
