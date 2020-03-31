/**
 * 
 */
package aula12.reflection.plugins;

import aula12.ex3.Data;
import aula12.ex3.Pessoa;
import aula12.ex3.AgendaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author maria
 *
 */

public class Nokia implements AgendaPlugin {
	@Override
	public Pessoa[] loadFile(String fname) throws FileNotFoundException {
		File ficheiro = new File(fname);
		ArrayList<Pessoa> con = new ArrayList<Pessoa>();
		Scanner fich = new Scanner(ficheiro);
		System.out.printf(" Lendo ficheiro");
		while (fich.hasNextLine()) {
			fich.nextLine();
			String nome="";
			try {
				nome = (String) fich.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
			int n = Integer.parseInt(fich.nextLine());
			String m = fich.nextLine();
			String[] d = m.split("/");
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
		PrintWriter pw = new PrintWriter(ficheiro);
		System.out.printf(" Escrevendo no ficheiro");
		pw.println("Nokia");
		for (Pessoa pessoa : con) {
//			System.out.println(pessoa.Nokiatype());
			pw.println(pessoa.Nokiatype());
			pw.println();
			System.out.print("-");
		}
		System.out.println();
		pw.close();
	}
}
