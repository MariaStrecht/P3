package aula11.ex3;

import java.io.Serializable;

public enum TipoPeixe implements Serializable {
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
