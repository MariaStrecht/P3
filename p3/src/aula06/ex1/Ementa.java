package aula06.ex1;

import java.util.HashMap;
import java.util.LinkedList;

public class Ementa {
	private String nome;
	private String local;
	private HashMap< DiaSemana , LinkedList<Prato>> pratos;
	
	public Ementa(String nome, String local) {
		this.nome = nome;
		this.local = local;
		this.pratos = new HashMap<DiaSemana, LinkedList<Prato>>();
	}
	public String getinfo() {
		return this.nome+"/"+this.local;
	}
	public String writeementa() {
		String tmp="";
		for (int i = 0; i < 6; i++) {
			DiaSemana d = DiaSemana.byIndex(i);
			tmp += i+"\n";
			if (pratos.containsKey(d)) {
				if (pratosbysemana(d).size()!=0) {
					for (Prato p : pratosbysemana(d)) {
						tmp += p.writeprato();
					}
				}
			}
		}
		return tmp;
	}
	public void addPrato(Prato p, DiaSemana d) {
		if (pratos.containsKey(d)) {
			pratos.get(d).add(p);
		}else {
			LinkedList<Prato> tmp = new LinkedList<Prato>();
			tmp.add(p);
			pratos.put(d, tmp);
		}
	}
	public void remPrato(Prato p, DiaSemana d) {
		if (pratos.containsKey(d)) {
			pratos.get(d).remove(p);
		}else {
			System.out.println("ERRO");
		}
	}
	public LinkedList<Prato> pratosbysemana(DiaSemana d){
		return pratos.get(d);
	}
	public boolean isEmpty() {
		if (pratos.size()==0) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i <= 6; i++) {
			LinkedList<Prato> tmp = pratos.get(DiaSemana.byIndex(i));
			if (tmp != null) {
				for (Prato prato : tmp) {
					if (prato != null) {
						s += prato.toString()+", dia "+ DiaSemana.byIndex(i).toString() +"\n";
					}
				}
			}
		}
		return s;
	}
	@Override
	public int hashCode() {
		double hash = pratos.hashCode();
		byte tmp[] = nome.getBytes();
		for (byte b : tmp) {
			hash += 31 * b;
		}
		byte tmp1[] = local.getBytes();
		for (byte b : tmp1) {
			hash += 31 * b;
		}
		return (int) hash;
	}
	
}
