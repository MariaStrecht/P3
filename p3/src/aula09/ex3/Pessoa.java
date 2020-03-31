package aula09.ex3;

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
	public int getBI() {
		return this.cc;
	}
	public Data getData() {
		return this.nasc;
	}
	public void addpass() {
		this.available=false;
	}
	public boolean isavailable() {
		return this.available;
	}
	
	// "Andreia, BI: 9855678 Data: 18/7/1974"
	@Override public String toString() {
		return String.format("%s, BI : %d, DataNasc: %s, ", this.nome, this.cc, this.nasc.toString());
	}
}
