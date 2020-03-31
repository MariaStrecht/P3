package aula03;

public class Quadrado extends Figura {
	
	public Quadrado(Ponto centro, double lado) {
		super(centro,lado,lado);
	}
	public Quadrado(double lado) {
		super(new Ponto(),lado,lado);
	}
	public Quadrado(double x, double y,double lado) {
		super(new Ponto(x,y),lado,lado);
	}
	public Quadrado(Quadrado q) {
		this(q.centro(),q.a());
	}
	@Override public String toString() {
		return String.format("%s , Lado: %2.2f QUADRADO ", super.toString(),this.a());
	}
}
