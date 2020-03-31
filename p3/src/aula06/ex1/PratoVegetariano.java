package aula06.ex1;

public class PratoVegetariano extends Prato{
	
	public PratoVegetariano(String nome) {
		super(nome);
	}
	@Override
	public String toString() {
		return "Vegetariano "+super.toString();
	}
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		String nome = "Vegetariano";
		byte tmp[] = nome.getBytes();
		for (byte b : tmp) {
			hash += 31 * b;
		}
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
		PratoVegetariano other = (PratoVegetariano) o;
		if (this.hashCode() != other.hashCode()) {
			return false;
		}
		return true;
	}
}
