package aula12.ex3;

public class Pessoa {
	private String nome;
	private int cc;
	private Data nasc;
	
	public Pessoa(String nome, int cc, Data nasc) {
		this.nome = nome;
		this.cc = cc;
		this.nasc = nasc;
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
	// "Andreia, BI: 9855678 Data: 18/7/1974"
	@Override public String toString() {
		return String.format("%s, BI : %d, DataNasc: %s, ", this.nome, this.cc, this.nasc.toString());
	}
	public String Nokiatype() {
		return String.format("%s\n%d\n%s", this.nome, this.cc, this.nasc.toString());
	}
	public String CSVtype() {
		return String.format("%s\t%d\t%s", this.nome, this.cc, this.nasc.toString());
	}
	public String vCardtype() {
		return String.format("#%s#%d#%s", this.nome, this.cc, this.nasc.toString());
	}
}
