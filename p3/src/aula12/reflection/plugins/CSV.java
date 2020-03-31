package aula12.reflection.plugins;

import aula12.ex3.Data;
import aula12.ex3.Pessoa;
import aula12.ex3.AgendaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV implements AgendaPlugin {
	@Override
	public Pessoa[] loadFile(String fname) {
		ArrayList<Pessoa> con = new ArrayList<Pessoa>();
		try {
			File ficheiro = new File(fname);
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return con.toArray(new Pessoa[0]);
	}

	@Override
	public void saveFile(Pessoa[] con, String fname) throws FileNotFoundException {
		File ficheiro = new File("src/aula12/ex3/"+fname);
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
}
