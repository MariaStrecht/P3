package aula09.ex2;

public class Copo extends GeladoComplexo {

	public Copo(Gelado ice) {
		// TODO Auto-generated constructor stub
		super(ice);
	}

	public void base(int i) {
		// TODO Auto-generated method stub
		gc.base(i);
		System.out.print("em copo");
	}

}
