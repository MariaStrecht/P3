package aula05.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import aula05.Data;

public class CSV implements AgendaStructure{

	@Override
	public void savecontacts(File ficheiro, Pessoa[] con) throws FileNotFoundException {
		System.out.printf(" Escrevendo no ficheiro");
		PrintWriter pw = new PrintWriter(ficheiro);
		pw.println("CSV");
		for (Pessoa pessoa : con) {
			pw.println(pessoa.CSVtype());
			System.out.print("-");
		}
		System.out.println();
		pw.close();
		System.out.println("Done");
		System.out.println();
	}

	@Override
	public Pessoa[] seecontacts(File ficheiro) throws IOException {
		ArrayList<Pessoa> con = new ArrayList<Pessoa>();
		Scanner fich = new Scanner(ficheiro);
		System.out.printf(" Lendo ficheiro");
		fich.nextLine();
		while (fich.hasNextLine()) {
			String a = fich.nextLine();
			String temp2[] = a.split("	");
			int n = Integer.parseInt(temp2[1]);
			String[] d = temp2[2].split("/");
			Data dnasc = new Data( Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
			con.add(new Pessoa(temp2[0],n,dnasc));
			
			System.out.print(".");
		}
		System.out.println();
		fich.close();
		return con.toArray(new Pessoa[0]);
	}
}
