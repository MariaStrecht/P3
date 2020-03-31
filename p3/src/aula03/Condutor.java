package aula03;

public class Condutor extends Pessoa{
	private Carta cc ;
	
	public Condutor(String nome, int cc, Data nasc, char tipo) {
		super(nome,cc,nasc);
		this.cc= new Carta(tipo);
	}
	public char getCartatipo() {
		return cc.getTipo();
	}
	@Override public String toString() {
		return String.format("%s Carta-tipo: %c", super.toString(),cc.getTipo());
	}
}
