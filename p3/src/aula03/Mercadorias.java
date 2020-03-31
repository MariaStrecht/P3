package aula03;

public class Mercadorias extends Pesado{
	private static Carta  tiponeeded =  new Carta('C');
	
	public Mercadorias(int cilindrada,int potencia, int lotacao, int Peso_Bruto ) {
		super(cilindrada,potencia,lotacao,Peso_Bruto, tiponeeded);
	}
	@Override public String toString() {
		return String.format("PESADO DE MERCADORIAS => %s", super.toString());
	}
}
