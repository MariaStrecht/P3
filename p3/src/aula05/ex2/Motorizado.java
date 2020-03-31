package aula05.ex2;

public abstract class Motorizado extends Veiculo{
	private int cilindrada;
	private double vmax;
	private String matrícula;
	private int potencia;
	private String combustível;
	private int consumo;
	
	public Motorizado(int ano, String matrícula, String cor, int nrodas, int cilindrada, double vmax,int potencia,String combustivel,int consumo) {
		super(cor, nrodas,ano);
		this.cilindrada = cilindrada;
		this.vmax = vmax;
		this.matrícula = matrícula;
		this.potencia = potencia;
		this.combustível = combustivel;
		this.consumo = consumo;
		
	}
	
	public String getMatricula() {
		return this.matrícula;
	}
	public int getCilindrada() {
		return this.cilindrada;
	}
	public double getVmax() {
		return this.vmax;
	}
	public int getPotencia() {
		return this.potencia;
	}
	public int getConsumo() {
		return this.consumo;
	}
	public String getCombustivel() {
		return this.combustível;
	}
	public String data() {
		return "	Cor: "+super.getCor()+"; Nrodas: "+super.getNRodas()+"; Ano:"+super.getAno()+"; Matricula: "+this.matrícula+"; Cilindrada: "+this.cilindrada+"; VMax: "+this.vmax+"; Potencia: "+this.potencia+"; Consumo: "+this.consumo+"; Combustivel: "+this.combustível+"; ";
	}
	
}
