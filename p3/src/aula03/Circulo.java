package aula03;

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
	public String perimetro() {
		return String.format("%2.2f", 2 * 3.14 * this.raio) ;
	}
	@Override
	public String area() {
		return String.format("%2.2f", 3.14 * Math.sqrt(this.raio));
	}
	public double raio() {
		return this.raio;
	}
	@Override public String toString() {
		return super.toString()+" , Raio: "+this.raio()+" CIRCULO ";
	}
	@Override public boolean equals(Object obj) {
		return super.equals( obj ) && tipo == ( (Circulo) obj ).tipo;
	}
	
	
}
