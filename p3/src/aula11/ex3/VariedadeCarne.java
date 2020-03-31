package aula11.ex3;

import java.io.Serializable;

public enum VariedadeCarne implements Serializable {
	vaca(0),
	porco(1),
	peru(2),
	frango(3),
	outra(4);
	
	private int index;
	
	private VariedadeCarne(int i) {
		index = i;
	}
	public int getIndex() {
		return index;
	}
	public VariedadeCarne get(int x) {
		VariedadeCarne c = null;
		for (VariedadeCarne v : this.values()) {
			if (v.getIndex()==x) {
				return v;
			}
		}
		return c;
	}
}
