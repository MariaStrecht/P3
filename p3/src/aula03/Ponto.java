package aula03;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto() {
		this.x = 0;
		this.y = 0;
	}
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override public String toString() {
		return String.format("(%1.2f ; %1.2f)", this.x, this.y);
	}
	public double x() {
		return this.x;
	}
	public double y() {
		return this.y;
	}
}
