package aula09.ex2;

public class Topping extends GeladoComplexo{
	private String tipo;
	
	public Topping(Gelado ice, String string) {
		// TODO Auto-generated constructor stub
		super(ice);
		this.tipo = string;
	}
	@Override
	public void base(int i) {
		// TODO Auto-generated method stub
		gc.base(i);
		System.out.print(" com "+tipo);
	}

}
