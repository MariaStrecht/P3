package aula07.ex1;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("TEST");
		Aero a = new Aero();
		a.read("/home/maria/Documents/P_III/p3/src/aula07/ex1/voos.txt","/home/maria/Documents/P_III/p3/src/aula07/ex1/companhias.txt");
		System.out.println("--- Voos Carregados ---");
		a.printVoos();
		System.out.println();
		
		System.out.println("--- Guardar Voos  ---");
		a.savefile("/home/maria/Documents/P_III/p3/src/aula07/ex1/Infopublico.txt", a.print_f());
		System.out.println();
		
		System.out.println("--- Apresentar Atraso Medios ---");
		a.atraso_c();
		System.out.println();
		
		System.out.println("--- Guardar cidades ---");
		a.cidades_v("/home/maria/Documents/P_III/p3/src/aula07/ex1/cidades.txt");
		System.out.println();
		
		System.out.println("--- Guardar voos em bin ---");
		a.savefile_bin("/home/maria/Documents/P_III/p3/src/aula07/ex1/Infopublico.bin", a.print_f());
		System.out.println();
		
		System.out.println("--- Ler voos do ficheiro bin ---");
		a.readfile_bin("/home/maria/Documents/P_III/p3/src/aula07/ex1/Infopublico.bin");
	}

}
