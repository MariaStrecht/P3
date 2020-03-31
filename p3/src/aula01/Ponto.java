package aula01;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return String.format("(%f,%f)", this.x, this.y);
	}
	public double x() {
		return this.x;
	}
	public double y() {
		return this.y;
	}
}
