package aula05.ex2;

import java.util.ArrayList;

import aula05.ex1.Figura;

//  ano, a matrícula, a cor base, o nº de rodas, a cilindrada, a velocidade máxima

public abstract class Veiculo implements Comparable<Veiculo> {
	private String cor;
	private int nrodas;
	private int ano;
	
	public Veiculo(String cor, int nrodas, int ano) {
		this.cor = cor;
		this.nrodas = nrodas;
		this.ano=ano;
	}
	public int getAno() {
		return this.ano;
	}
	public String getCor() {
		return this.cor;
	}
	public int getNRodas() {
		return this.nrodas;
	}
	public int compareTo(Veiculo v) {
		if (v==null) {
			throw new NullPointerException("Veiculo nulo");
		}
		return (int)(this.getAno()-v.getAno());
	}
}
