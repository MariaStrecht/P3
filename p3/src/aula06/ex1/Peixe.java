package aula06.ex1;

public class Peixe extends Alimento{
	private TipoPeixe tipo;
	
	public Peixe(TipoPeixe t ,double proteinas, double calorias, double peso) {
		super(calorias,proteinas,peso);
		this.tipo = t;
	}
	
	public TipoPeixe getTipo() {
		return this.tipo;
	}
	@Override
	public String getInfo() {
		return this.getNome()+"#"+super.getInfo();
	}
	@Override
	public String getNome() {
		return "Peixe "+tipo.toString();
	}
	@Override
	public String toString() {
		return "Peixe "+tipo.toString()+super.toString();
	}
	@Override
	public int hashCode() {
		double hash = super.hashCode();
		hash += 31 * tipo.getIndex();
		return (int)hash;
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
		Peixe other = (Peixe) o;
		if (this.hashCode() != other.hashCode()) {
			return false;
		}
		return true;
	}
}
