package aula12.reflection.plugins;

import aula12.ex3.Data;
import aula12.ex3.Pessoa;
import aula12.ex3.AgendaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class vCard implements AgendaPlugin {
	@Override
	public Pessoa[] loadFile(String fname) throws FileNotFoundException {
		File ficheiro = new File(fname);
		ArrayList<Pessoa> con = new ArrayList<Pessoa>();
		Scanner fich = new Scanner(ficheiro);
		System.out.printf(" Lendo ficheiro");
		fich.nextLine();
		while (fich.hasNextLine()) {
			String line = fich.nextLine();
			String tmp[] = line.split("#");
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

	@Override
	public void saveFile(Pessoa[] con, String fname) throws FileNotFoundException {
		File ficheiro = new File("src/aula12/ex3/"+fname);
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
}
