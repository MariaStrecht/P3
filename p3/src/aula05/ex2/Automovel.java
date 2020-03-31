package aula05.ex2;

public class Automovel extends Motorizado{
	public Automovel(int ano,String matrícula,String cor, int cilindrada, double vmax, int potencia,String combustivel,int consumo) {
		super(ano,matrícula,cor,4,cilindrada,vmax,potencia, combustivel, consumo);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "AUTOMOVEL ("+super.getAno()+")";
	}
}
