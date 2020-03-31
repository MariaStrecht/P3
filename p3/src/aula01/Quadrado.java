package aula01;

public class Quadrado {
	private double lado;
	
	public Quadrado(double lado) {
		this.lado = lado;
	}
	public double area() {
		return lado * lado; 
	}
	public double perimetro() {
		return lado * 4;
	}
	public double getLado() {
		return this.lado;
	}
	public String toString(){
		return String.format("Caracteristicas :\n Lado : %f \n Area : %f \n Perimetro : %f \n", this.lado , area() , perimetro());
	}

}
