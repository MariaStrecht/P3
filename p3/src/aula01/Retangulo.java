package aula01;

public class Retangulo {
	private double comp;
	private double larg;
	
	public Retangulo(double c, double l) {
		this.comp = c;
		this.larg = l;
	}
	public double perimetro() {
		return 2*(this.comp + this.larg) ;
	}
	public double area() {
		return this.comp * this.larg ; 
	}
	public String toString(){
		return String.format("Caracteristicas :\n Comprimento : %f \n Largura : %f \n Area : %f \n Perimetro : %f \n", this.comp, this.larg , area() , perimetro());
	}
}
