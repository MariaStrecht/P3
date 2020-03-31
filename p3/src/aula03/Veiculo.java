package aula03;

import java.util.ArrayList;

public class Veiculo {
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private int Peso_Bruto;
	private Condutor cond;
	private ArrayList<Pessoa> passageiros;
	private Carta tipo;
	
	public Veiculo(int cilindrada,int potencia, int lotacao, int Peso_Bruto, Carta carta) {
		this.cilindrada=cilindrada;
		this.potencia = potencia;
		this.lotacao = lotacao;
		this.Peso_Bruto = Peso_Bruto;
		this.tipo = carta;
		passageiros = new ArrayList<Pessoa>();
		
	}
	public int getcilindrada() {
		return this.cilindrada;
	}
	public int getpotencia() {
		return this.potencia;
	}
	public int getlotacao() {
		return this.lotacao;
	}
	public int getpeso() {
		return this.Peso_Bruto;
	}
	public void addcond(Condutor c) {
		if (this.cond!=null) {
			System.out.println("Ja existe um condutor utilizando esse veiculo ");
		}else {
			if (c.getCartatipo() == this.tipo.getTipo()) {
				this.cond=c;
				System.out.println("Condutor : "+c.nome()+ " ,adicionado com Sucesso");
			}else {
				System.out.println("-> |ERRO| : Condutor selecionado não tem tipo de Carta necessária para conduzir esse veiculo");
			}
			
		}
	}
	public void addpass(Pessoa e) {
		if (passageiros.size()==lotacao-1) {
			System.out.println(" ||ERRO|| - Lotacao maxima atingida");
		}else if(this.cond==null) {
			System.out.println(" ||ERRO|| - Não é permitido adicionar passageiro sem condutor");
		}else {
			if (e.isavailable()) {
				passageiros.add(e);
				e.addpass();
				System.out.println("Passageiro : "+e.nome()+ " ,adicionado com Sucesso");
			}else {
				System.out.println(" |ERRO| - Passageiro ja colocado noutro veiculo ");
			}
			
		}
	}
	public void addpass(ArrayList<Pessoa> pass) {
		int npass = 0;
		for (int i = 0; i < pass.size(); i++) {
			Pessoa tmp = pass.get(i);
			if (passageiros.size()==lotacao-1) {
				System.out.println(" ||ERRO|| - Lotacao maxima atingida");
				break;
			}else if(this.cond==null) {
				System.out.println(" ||ERRO|| - Não é permitido adicionar passageiro sem condutor");
				break;
			}
			if (tmp.isavailable()) {
				npass++;
				passageiros.add(tmp);
				tmp.addpass();
			}
		}
		System.out.println(" | Done -> Adicionado "+npass+" passageiros ");
	}
	public void takepass(Pessoa p) {
		int index = passageiros.indexOf(p);
		passageiros.remove(index);
	}
	@Override public String toString() {
		return String.format("Cilindrada : %d, Potencia : %d, Lotacao : %d, Peso-Bruto : %d", this.cilindrada,this.potencia,this.lotacao,this.Peso_Bruto);
	}
}	