package aula09.ex2;

public class Cone extends GeladoComplexo{
	
	public Cone(Gelado ice) {
		// TODO Auto-generated constructor stub
		super(ice);
	}

	public void base(int i) {
		// TODO Auto-generated method stub
		gc.base(i);
		System.out.print("em cone");
	}

}
