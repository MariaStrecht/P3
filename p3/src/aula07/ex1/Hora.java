package aula07.ex1;

public class Hora {
	private int h;
	private int min;

	public Hora(String s) {
		this.h = Integer.parseInt(s.substring(0, 2));
		this.min = Integer.parseInt(s.substring(3, 5));
	}
	public Hora(int h, int m) {
		this.h = h;
		this.min = m;
	}
	public int geth() {
		return this.h;
	}
	public int getm() {
		return this.min;
	}
	public Hora hatraso(Hora m) {
		int th = m.geth();
		int tm = m.getm();
		int tmp_m = this.min+tm;
		int tmp_h = this.h +th;
		double hora = 0;
		double minutos = 0;
		if (tmp_m >= 60) {
			double r = tmp_m % 60;
			hora = tmp_h + 1;
			minutos = r;
			if (hora > 24) {
				hora = hora % 24;
			}
		}else {
			minutos = tmp_m;
			hora = tmp_h + 1;
			if (hora > 24) {
				hora = hora % 24;
			}
		}
		return new Hora((int)hora,(int)minutos);
	}
	public int tominutos() {
		return this.h*60+this.min;
	}
	public boolean nulo() {
		if (h==0 && min==0)return true;
		return false;
	}
	@Override
	public String toString() {
		return String.format("%2d:%2d", this.h,this.min);
	}
}
