package aula04.ex2;

import java.util.ArrayList;

import aula04.Estudante;

public class ColecaoFiguras {
	private double maxArea;
	private ArrayList<Figura> figuras;
	private double areaTotal;
	
	public ColecaoFiguras(double maxArea) { // O construtor define a área máxima da coleção de figuras
		this.maxArea = maxArea;
		this.figuras = new ArrayList<Figura>();
		this.areaTotal=0;
	}
	public boolean addFigura(Figura f) { // Adiciona uma figura à coleção
		if (exists(f)) {
			return false;
		}
		if (this.areaTotal+f.area()>maxArea) {
			return false;
		}
		this.areaTotal += f.area();
		return figuras.add(f);
	}
	public boolean delFigura(Figura f) {// Remove uma figura da coleção
		if (!exists(f)) {
			return false;
		}
		this.areaTotal -= f.area();
		figuras.remove(figuras.indexOf(f));
		return true;
	}
	public double areaTotal() { // Retorna a área total das figuras
		return this.areaTotal;
	}
	public boolean exists(Figura f) { // Verifica se uma figura existe na coleção
		if (figuras.isEmpty()) {
			return false;
		}
		for (int i = 0; i < figuras.size(); i++) {
			if (figuras.get(i).equals(f)) {
				return true;
			}
		}
		return false;
	}
//	public String toString() { // Retorna as características da coleção
//		
//	}
	public Figura[] getFiguras() { // Retorna uma lista com todas	as figuras da coleção
		return this.figuras.toArray(new Figura[0]);
	}
	public Ponto[] getCentros() { // Retorna uma lista com todos os centros	das figuras da coleção
		Ponto[] p = new Ponto[figuras.size()];
		for (int i = 0; i < figuras.size(); i++) {
			p[i] = figuras.get(i).centro();
		}
		return p ;
	}
}
