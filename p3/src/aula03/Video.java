package aula03;

import java.util.ArrayList;
import java.util.Scanner;


public class Video {
		/*Um vídeo é caracterizado por um ID sequencial, um título, uma categoria (Ação,
		Comédia, Infantil, Drama, etc.) e uma idade (ALL, M6, M12, M16, M18) */
	private int id;
	private String titulo;
	private String categoria;
	private String idade;
	private boolean disp;
	private double rating_m;
	private int rating_total;
	private ArrayList<Cliente> visualizadores ;
	static Scanner sc = new Scanner(System.in);

	public Video(int id, String titulo, String categoria, String idade) {
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
		this.disp = true;
		this.rating_m=0;
		this.rating_total=0;
		visualizadores = new ArrayList<Cliente>();
	}
	public String toString() {
		return  String.format(" | %2d | %15s | %10s | %5s | %2.3f | \n",this.id,this.titulo,this.categoria,this.idade,this.rating_m);
	
	}
	public String idade() {
		return this.idade;
	}
	public String nome() {
		return this.titulo;
	}
	public int id() {
		return this.id;
	}
	public boolean disp() {
		return this.disp;
	}
	public boolean emprestimo(int id, clientList cl) {
		boolean done = false;
		if (this.disp==true) {
			if (do_emp(cl.getcl(id)) == false) {
				System.out.println("O Utilizador tem Idade insuficiente");
			}else {
				this.disp = false;
				visualizadores.add(cl.getcl(id));
				done = true;
			}
		}else {
			System.out.println("O Video escolhido nao esta disponivel");
			done = false;
		}
		return done;
	}
	public boolean do_emp(Cliente c) {
		int age = c.getIdade();
		if (age >= 18) {
			return true;
		}else if (age >= 16) {
			if (this.idade.equals("M18")) {
				return false;
			}else {
				return true;
			}
		}else if (age >= 12) {
			if (this.idade.equals("M18") || this.idade.equals("M16")) {
				return false;
			}else {
				return true;
			}
		}else if (age >= 6) {
			if ( this.idade.equals("M18") || this.idade.equals("M16") || this.idade.equals("M12") ) {
				return false;
			}else {
				return true;
			}
		}else {
			if (this.idade.equals("ALL")) {
				return true;
			}else {
				return false;
			}
		}
	}
	public void devolucao() {
		System.out.printf("Rating que atribui ao Video (1 a 10): ");
		int r = Integer.parseInt(sc.nextLine());
		this.disp = true;
		this.rating_m = (this.rating_total+r)/this.visualizadores.size();
		this.rating_total += r;
	}
	public int currentuser() {
		if (disp) {
			return 666;
		}
		int id_e = visualizadores.size()-1;
		return visualizadores.get(id_e).getnsocio();
	}
	public void showvis() {
		String s = "";
		for (int i = 0; i < visualizadores.size(); i++) {
			s = s + visualizadores.get(i).toString() ;
		}
		if (s.equals("")) {
			System.out.println("O Video '"+this.titulo+"' ainda não foi visualizador por ninguem");
		}else {
			System.out.println(" ------ Utilizadores que visualizaram '"+this.titulo+"' ------");
			System.out.printf(" | %7s  | %15s | %10s | %10s | \n" , "Nsocio", "Nome", "CC","Data de inscrição");
			System.out.println(s);
		}
	}
	public double rating() {
		return this.rating_m;
	}
}
