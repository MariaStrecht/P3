package aula05.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Arrays;

import aula05.Data;

public class Agenda {
	private ArrayList<Pessoa> contactos = new ArrayList<Pessoa>();
	
	public void add(File ficheiro, Pessoa con) throws IOException {
		// TODO Auto-generated method stub
		System.out.println();
		AgendaStructure ag = null;
		Scanner sc = new Scanner(System.in);
		Scanner fich ;
		try {
			fich = new Scanner(ficheiro);
		} catch (FileNotFoundException e) {
			System.out.println("-------Criando ficheiro-------");
			ficheiro.createNewFile();
		}
		String tipo="";
		boolean newf = false;
		Pessoa[] tmp = new Pessoa[1];
		tmp[0] = con;
		fich = new Scanner(ficheiro);
		try {
			tipo = fich.next();
//			System.out.println(tipo);
		} catch ( Exception e ) {
			
			System.out.println("Selecionar tipo:");
			System.out.println("1 - Nokia");
			System.out.println("2 - CSV");
			System.out.println("3 - vCard");
			System.out.print("Op :");
			String oop = sc.nextLine();
			switch (oop) {
			case "1":
				tipo="Nokia";
				break;
			case "2":
				tipo="CSV";
				break;
			case "3":
				tipo="vCard";
				break;
			default:
				break;
			}
			newf = true;
		}
		System.out.println("-------Adicionando a ficheiro ja existente-------");
		
		while (fich.hasNextLine()) {
			String l = fich.nextLine();
			if (l.isEmpty()) {
				break;
			}
			
		}
		System.out.println();
		switch (tipo) {
		case "Nokia":
			ag = new Nokia();
			break;
		case "CSV":
			ag = new CSV();
			break;
		case "vCard":
			ag = new vCard();
			break;
		default:
			System.out.println("Default"); 
			break;
		}
		fich.close();
		if (newf) {
			ag.savecontacts(ficheiro, tmp);
		}else {
			Pessoa c[] = ag.seecontacts(ficheiro);
			Pessoa b[] = new Pessoa[c.length+1];
//			System.out.println("C:");
//			for (Pessoa pessoa : c) {
//				System.out.println(pessoa.toString());
//			}
			System.arraycopy(c,0, b, 0,c.length);
			System.arraycopy(tmp, 0, b, c.length, tmp.length);
//			System.out.println("B:");
//			System.out.println("->> "+tmp[0].toString());
//			for (Pessoa pessoa : b) {
//				System.out.println(pessoa.toString());
//			}
			ag.savecontacts(ficheiro, b);
		}
		
		
	}
	
	public Pessoa[] see(File ficheiro) throws IOException {
		AgendaStructure ag = null;
		try {
			Scanner fich = new Scanner(ficheiro);
			String tipo = fich.nextLine();
			
			switch (tipo) {
			case "Nokia":
				ag = new Nokia();
				fich.close();
				break;
			case "CSV":
				ag = new CSV();
				fich.close();
				break;
			case "vCard":
				ag = new vCard();
				fich.close();
				break;
			default:
				break;
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERRO: Ficheiro nao encontrado");
			e.printStackTrace();
		}
		
		update(ag.seecontacts(ficheiro));
		return contactos.toArray(new Pessoa[0]);
		
	}
	@Override
	public String toString() {
		return contactos.toString();
	}
	
	public void update(Pessoa p[]) {
		contactos = new ArrayList<Pessoa>();
		for (Pessoa i : p) {
			contactos.add(i);
		};
	}

}
