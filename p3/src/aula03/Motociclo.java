package aula03;

public class Motociclo extends Veiculo{
	private static Carta tiponeeded = new Carta('A');
	
	public Motociclo(int cilindrada,int potencia, int lotacao, int Peso_Bruto) {
		super(cilindrada,potencia,lotacao,Peso_Bruto, tiponeeded);
	}
	@Override public String toString() {
		return String.format("MOTOCICLOS => %s", super.toString());
	}
}
