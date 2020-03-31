package aula06.ex2;

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
		return String.format(" x: %1.1f, y: %1.1f ", this.x, this.y);
	}
	public double x() {
		return this.x;
	}
	public double y() {
		return this.y;
	}
}
