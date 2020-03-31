package aula03;

public class Retangulo extends Figura {

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
		return String.format("%s , L1: %2.2f ,L2: %2.2f RETANGULO ", super.toString(),this.a(),this.b());
	}
}
