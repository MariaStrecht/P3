package aula09.ex2;

public abstract class GeladoComplexo implements Gelado{
	public Gelado gc;
	public GeladoComplexo(Gelado g) {
		this.gc = g;
	}
	public Gelado get() {
		return gc;
	}

}
