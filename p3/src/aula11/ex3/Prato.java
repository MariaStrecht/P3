package aula11.ex3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Prato implements Comparable<Prato> , Serializable {
	private String nome;
	private Collection<Alimento> conjal;
	private double totalcalorias=0;
	
	public Prato(String nome) {
		this.nome = nome;
		conjal = new ArrayList<Alimento>();
	}
	public String getinfo() {
		return nome+"#";
	}
	public String writeprato() {
		String tmp=this.nome+"#"+this.totalcalorias+"\n";
		for (Alimento alimento : conjal) {
			tmp += "->"+alimento.getInfo()+"\n";
		}
		return tmp;
	}
	public boolean addIngrediente(Alimento aux) {
		if (aux == null) {
			return false;
		}
		if (canDo(aux.calorias())) {
			conjal.add(aux);
			totalcalorias += aux.calorias();
			return true;
		}
		return false;
	}
	public boolean remIngrediente(Alimento aux) {
		if (aux == null) {
			return false;
		}
		conjal.remove(aux);
		totalcalorias -= aux.calorias();
		return true;
	}
	public boolean canDo(double c) {
		return true;
	}
	public String getNome() {
		return this.nome;
	}
	public double getCalorias() {
		return totalcalorias;
	}
	
	//  Dieta (0.0 Calorias) Prato 'Prato N.0 (Dieta)' composto por 0 Ingredientes
	@Override
	public String toString() {
		return String.format("Prato '%s' composto por %d Ingredientes" , this.nome, this.conjal.size());
	}
	
	@Override
	public int compareTo(Prato prato) {
		// TODO Auto-generated method stub
		if (prato==null) {
			throw new NullPointerException("Figura nula");
		}
		return (int) (this.getCalorias()-prato.getCalorias());
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		for (Alimento alimento : conjal) {
			hash += 31 * alimento.hashCode();
		}
		byte tmp[] = nome.getBytes();
		for (byte b : tmp) {
			hash += 31 * b;
		}
		return (int)hash;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!super.equals(o)) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Prato other = (Prato) o;
		if (this.hashCode() != other.hashCode()) {
			return false;
		}
		return true;
	}
	
}
