package aula03;

public class Ligeiro extends Veiculo{
	private static Carta tiponeeded = new Carta('B');
	
	public Ligeiro(int cilindrada,int potencia, int lotacao, int Peso_Bruto ) {
		super(cilindrada,potencia,lotacao,Peso_Bruto, tiponeeded);
		
	} 
	@Override public String toString() {
		return String.format("LIGEIRO => %s", super.toString());
	}
}
