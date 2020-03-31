package aula06.ex1;

public enum DiaSemana {
	Segunda(0),
	Terca(1),
	Quarta(2),
	Quinta(3),
	Sexta(4),
	Sabado(5),
	Domingo(6);
	
	private int index;
	
	private DiaSemana(int i) {
		index = i;
	}
	
	public int getIndex() {
		return index;
	}
	public static DiaSemana rand() {
		int r = (int)(Math.random()*6);
		DiaSemana d = null;
		for (DiaSemana di : DiaSemana.values()) {
			if (di.getIndex() == r) {
				d = di;
			}
		}
		return d;
	}
	public static DiaSemana byIndex(int i) {
		DiaSemana d = null;
		for (DiaSemana di : DiaSemana.values()) {
			if (di.getIndex() == i) {
				d = di;
			}
		}
		return d;
	}
}
