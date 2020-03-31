package aula01;

public class Circulo {
	private Ponto centro;
	private double raio;
	
	public Circulo(Ponto c, double r) {
		this.centro = c;
		this.raio = r;
	}
	public Circulo(double x, double y, double r) {
		this.centro = new Ponto(x,y);
		this.raio = r;
	}
	public double raio() {
		return this.raio;
	}
	public Ponto centro() {
		return this.centro;
	}
	public double perimetro() {
		return 2 * 3.14 * this.raio ;
	}
	public double area() {
		return 3.14 * Math.sqrt(this.raio); 
	}
	public String toString(){
		//return centro.toString();
		return String.format("Caracteristicas :\n Centro : %s \n Raio : %s \n Area : %f \n Perimetro : %f \n", centro.toString(), this.raio , area() , perimetro());
	}
	// Verifique se dois Círculos são iguais;
	public boolean equalcir(Circulo c2) {
		if (this.raio == c2.raio()) {
			return true;
		} 
		return false;
	}
	public boolean inter(Circulo c2) {
		double dist = Math.sqrt( Math.pow( (centro.x()-c2.centro().x()) , 2) + Math.pow( (centro.y()-c2.centro().y()) , 2) );
		if (dist > (this.raio + c2.raio( ))) {
			return false;
		}
		return false;
	}
	
	
}
