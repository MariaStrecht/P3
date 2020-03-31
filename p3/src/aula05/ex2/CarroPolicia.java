package aula05.ex2;

public class CarroPolicia extends Automovel implements Policia{

	public CarroPolicia(int ano, String matrícula, String cor, int nrodas, int cilindrada, double vmax, int potencia,String combustivel,int consumo) {
		super(ano, matrícula, cor, cilindrada, vmax,potencia, combustivel, consumo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Serviço getTipo() {
		// TODO Auto-generated method stub
		return Serviço.PSP;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CARROPOLICIA ("+super.getAno()+")";
	}

}
