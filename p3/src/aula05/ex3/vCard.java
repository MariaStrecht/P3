package aula05.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import aula05.Data;

public class vCard implements AgendaStructure{

	@Override
	public void savecontacts(File ficheiro, Pessoa[] con) throws FileNotFoundException {
		System.out.printf(" Escrevendo no ficheiro");
		PrintWriter pw = new PrintWriter(ficheiro);
		pw.println("vCard");
		for (Pessoa pessoa : con) {
			pw.println(pessoa.vCardtype());
			System.out.print("-");
		}
		System.out.println();
		pw.close();
	}

	@Override
	public Pessoa[] seecontacts(File ficheiro) throws IOException {
		ArrayList<Pessoa> con = new ArrayList<Pessoa>();
		Scanner fich = new Scanner(ficheiro);
		System.out.printf(" Lendo ficheiro");
		fich.nextLine();
		while (fich.hasNextLine()) {
			String line = fich.nextLine();
			String tmp[] = line.split("#");
//			for (String string : tmp) {
//				System.out.println(string);
//			}
			String nome = tmp[1];
			int n = Integer.parseInt(tmp[2]);
			String[] d = tmp[3].split("/");
			Data dnasc = new Data( Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
			con.add(new Pessoa(nome,n,dnasc));
			System.out.print(".");
		}
		System.out.println();
		fich.close();
		return con.toArray(new Pessoa[0]);
	}
}
