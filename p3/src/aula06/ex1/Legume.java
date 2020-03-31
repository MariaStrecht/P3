package aula06.ex1;

public class Legume extends Alimento implements Vegetariano{
	private String nome;
	
	public Legume(String nome, double proteinas, double calorias, double peso) {
		super(calorias,proteinas,peso);
		this.nome = nome;
	}
	@Override
	public String getNome() {
		return "Legume "+this.nome;
	}
	@Override
	public String getInfo() {
		return this.getNome()+"#"+super.getInfo();
	}
	@Override
	public String toString() {
		return "Legume "+this.nome+super.toString();
	}
	
	@Override
	public int hashCode() {
		double hash = super.hashCode();
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
		Legume other = (Legume) o;
		if (this.hashCode() != other.hashCode()) {
			return false;
		}
		return true;
	}
	
}
