package aula05.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia {

	public BicicletaPolicia(String cor ,int ano) {
		super(cor,ano);
	}

	@Override
	public Serviço getTipo() {
		// TODO Auto-generated method stub
		return Serviço.PSP;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BICICLETAPOLICIA ("+super.getAno()+")";
	}

}
