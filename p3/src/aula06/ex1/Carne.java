package aula06.ex1;

public class Carne extends Alimento{
	private VariedadeCarne tipo;
	
	public Carne(VariedadeCarne tipo,double proteinas, double calorias, double peso) {
		super(calorias,proteinas,peso);
		this.tipo = tipo;
	}
	public VariedadeCarne getTipo() {
		return this.tipo;
	}
	@Override
	public String getInfo() {
		return this.getNome()+"#"+super.getInfo();
	}
	@Override
	public String getNome() {
		return "Carne "+tipo.toString();
	}
	@Override
	public String toString() {
		return "Carne "+tipo.toString()+super.toString();
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!super.equals(o)) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Carne other = (Carne) o;
		if (this.hashCode() != other.hashCode()) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		double hash = super.hashCode();
		hash += 33 * tipo.getIndex();
		return (int)hash;
	}
}
