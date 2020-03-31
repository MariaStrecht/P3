package aula03;

public class Pessoa {
	private String nome;
	private int cc;
	private Data nasc;
	private boolean available;
	
	
	public Pessoa(String nome, int cc, Data nasc) {
		this.nome = nome;
		this.cc = cc;
		this.nasc = nasc;
		this.available=true;
	}	
	public String nome() {
		return this.nome;
	}
	public void addpass() {
		this.available=false;
	}
	public boolean isavailable() {
		return this.available;
	}
	
	// "Andreia, BI: 9855678 Data: 18/7/1974"
	@Override public String toString() {
		return String.format("Nome: %s, BI: %d Data: %s", this.nome, this.cc, this.nasc.toString());
	}
	
}