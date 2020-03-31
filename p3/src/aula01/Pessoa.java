package aula01;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String nome, int cc, Data datanasc) {
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = datanasc;
	}
	public String nome() {
		return this.nome;
	}
	public int cc() {
		return this.cc;
	}
	public Data dataNasc() {
		return this.dataNasc;
	}
	public String toString() {
		return String.format(" %20s | %10d | %17s ", nome(), cc(), dataNasc().toString());
	}
}
