package aula06.ex2;

public class Circulo extends Figura{
	private double raio;
	private static String tipo = "FIGURA";
	public Circulo(double raio) {
		super(new Ponto(),raio,raio);
		this.raio=raio;
		
	}
	public Circulo(Ponto centro,double raio) {
		super(centro,raio,raio);
		this.raio = raio;
	}
	public Circulo(double x, double y,double raio) {
		super(new Ponto(x,y),raio,raio);
		this.raio = raio;
	}
	public Circulo(Circulo c) {
		this(c.centro(),c.raio());
	}
	public double perimetro() {
		return  2 * Math.PI * this.raio ;
	}
	@Override
	public double area() {
		return Math.PI * (this.raio) * this.raio;
	}
	public double raio() {
		return this.raio;
	}
	@Override public String toString() {
		return "Circulo de "+super.toString()+"e de raio "+this.raio;
	}
	@Override public boolean equals(Object obj) {
		return super.equals( obj ) && tipo == ( (Circulo) obj ).tipo;
	}
}
