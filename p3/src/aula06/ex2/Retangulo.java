package aula06.ex2;

public class Retangulo extends Figura{
	public Retangulo(double comp, double larg) {
		super(new Ponto(), comp,larg);
	}
	public Retangulo(double x, double y, double comp, double larg) {
		super(new Ponto(x,y), comp,larg);
	}
	public Retangulo(Ponto centro, double comp, double larg) {
		super(centro,comp,larg);
	}
	public Retangulo(Retangulo r) {
		this(r.centro(),r.a(),r.b());
	}
	@Override public String toString() {
		return String.format("Retangulo de %s, altura %1.1f, comprimento %1.1f", super.toString(),this.a(),this.b());
	}
}
