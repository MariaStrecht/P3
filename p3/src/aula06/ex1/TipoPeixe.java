package aula06.ex1;

public enum TipoPeixe {
	congelado(0),
	fresco(1);
	private int index;
	
	private TipoPeixe(int i) {
		index = i;
	}
	public int getIndex() {
		return index;
	}
}
