package aula09.ex2;

public class GeladoSimples implements Gelado {
	String tipo;
	
	public GeladoSimples(String string) {
		// TODO Auto-generated constructor stub
		this.tipo = string;
	}
	@Override
	public void base(int i) {
		System.out.printf("\n"+i+" bolas de gelado de "+tipo);
	}

}
