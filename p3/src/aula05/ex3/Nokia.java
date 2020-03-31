/**
 * 
 */
package aula05.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import aula05.Data;

/**
 * @author maria
 *
 */
public class Nokia implements AgendaStructure{

	@Override
	public void savecontacts(File ficheiro, Pessoa[] con) throws FileNotFoundException {
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

	@Override
	public Pessoa[] seecontacts(File ficheiro) throws IOException {
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
//			System.out.println("Nome:"+nome);
//			System.out.println("cc:"+n);
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
}
