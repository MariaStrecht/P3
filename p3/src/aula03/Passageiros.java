package aula03;

public class Passageiros extends Pesado{
	private static Carta tiponeeded =new Carta('D');
	

	public Passageiros(int cilindrada,int potencia, int lotacao, int Peso_Bruto ) {
		super(cilindrada,potencia,lotacao,Peso_Bruto, tiponeeded
				);
	}
	
	@Override public String toString() {
		return String.format("PESADO DE PASSAGEIROS => %s", super.toString());
	}
}
