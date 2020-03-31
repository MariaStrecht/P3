package aula06.ex1;

public abstract class Alimento {
	private double calorias;
	private double proteinas;
	private double peso;
	
	public Alimento(double calorias, double proteinas, double peso) {
		this.calorias=calorias;
		this.peso=peso;
		this.proteinas=proteinas;
	}
	public String getInfo() {
		return this.calorias+"#"+this.proteinas+"#"+this.peso;
	}
	public double calorias() {
		return this.calorias;
	}
	public double proteinas() {
		return this.proteinas;
	}
	public double peso() {
		return this.peso;
	}
	// 'Carne frango, Proteínas 22.3, calorias 345.3, Peso	300.0'
	@Override
	public String toString() {
		return String.format(", Proteínas %.2f, calorias %.2f, Peso %.2f", this.proteinas,this.calorias,this.peso);
	}
	public String getNome() {
		return "Alimento";
	}
	
	@Override
	public int hashCode() {
		double hash = 31 * calorias;
		hash += 31 * proteinas;
		hash += 31 * peso;
		return (int) hash ;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		Alimento tmp = (Alimento) o;
		if (tmp.calorias() != this.calorias) {
			return false;
		}
		if (tmp.proteinas() != this.proteinas) {
			return false;
		}
		if (tmp.peso() != this.peso) {
			return false;
		}
		if (this.hashCode() != tmp.hashCode()) {
			return false;
		}
		return true;
	}
}
