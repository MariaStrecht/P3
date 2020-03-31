package aula05.ex1;


public class Figura implements Comparable<Figura> {
	private Ponto centro;
	public double a;
	public double b;
	
	public Figura(Ponto c,double a,double b){
		this.centro = c;
		if (a>b) {
			this.a = a;
			this.b = b;
		}else {
			this.a = b;
			this.b = a;
		}
	}
	public double area() {
		return a*b;
	}
	public double perimetro() {
		return (a+b)*2;
	}
	public Ponto centro() {
		return this.centro;
	}
	public double a() {
		return this.a;
	}
	public double b() {
		return this.b;
	}
	@Override public String toString() {
		return "Centro"+this.centro;
	}
	@Override public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Figura other = (Figura) obj;
			//Verify if the objects attributes are equals
		if (centro == null) {
			if (other.centro != null) {
				return false;
			}
		}else if (!centro.equals(other.centro)) {
			return false;
		}	
		if (this.a != other.a || this.b != other.b) {
			return false;
		}
		return true;
	}
	public int compareTo(Figura fig) {
		if (fig==null) {
			throw new NullPointerException("Figura nula");
		}
		return (int) (this.area()-fig.area());
	}
}
