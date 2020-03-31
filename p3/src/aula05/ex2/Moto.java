package aula05.ex2;

public class Moto extends Motorizado{

	public Moto(int ano, String matrícula, String cor, int nrodas, int cilindrada, double vmax,int potencia,String combustivel,int consumo) {
		super(ano, matrícula, cor, nrodas, cilindrada, vmax, potencia, combustivel, consumo);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MOTO ("+super.getAno()+")";
	}
	
}
