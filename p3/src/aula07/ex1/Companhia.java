package aula07.ex1;


public class Companhia implements Comparable<Companhia>{
	private final String nome;
	private int atraso_m;
	
	public Companhia(String nome, int atraso) {
		this.nome=nome;
		this.atraso_m = atraso;
	}
	public int getat() {
		return this.atraso_m;
	}
	@Override
	public String toString() {
		return String.format("%-20s\t %d", this.nome, this.atraso_m);
	}

	@Override
	public int compareTo(Companhia comp2) {
		// TODO Auto-generated method stub
		return this.atraso_m - comp2.atraso_m;
	}
}
