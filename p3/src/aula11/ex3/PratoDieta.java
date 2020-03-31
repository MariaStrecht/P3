package aula11.ex3;

public class PratoDieta extends Prato{
	private double maxcalorias;
	
	public PratoDieta(String nome, double maxcalorias) {
		super(nome);
		this.maxcalorias = maxcalorias;
	}
	public String getinfo() {
		return "dieta#"+this.maxcalorias+"#"+super.getinfo();
	}
	@Override
	public boolean canDo(double c) {
		double tmp = super.getCalorias() + c;
		if(tmp > maxcalorias) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Dieta ("+this.maxcalorias+" Calorias) "+super.toString();
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
		PratoDieta other = (PratoDieta) o;
		if (this.hashCode() != other.hashCode()) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		String nome = "Dieta";
		byte tmp[] = nome.getBytes();
		for (byte b : tmp) {
			hash += 31 * b;
		}
		hash += 31 * maxcalorias;
		return (int)hash;
	}
}
