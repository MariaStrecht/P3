package aula05.ex2;

public class Bicicleta extends Veiculo{

	public Bicicleta(String cor,int ano) {
		super(cor, 2,ano);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BICICLETA ("+super.getAno()+")";
	}
	public String data() {
		return "	Cor: "+super.getCor()+"; Nrodas : "+super.getNRodas()+";"; 
	}

}
