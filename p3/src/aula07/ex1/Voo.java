package aula07.ex1;

import java.util.List;


public class Voo {
	private Hora hora;
	private String infoVoo;
	private String companhia;
	private String origem;
	private Hora atraso;
	private String obs;
	
	public Voo(Hora hora, String infoVoo, String Companhia, String Origem, Hora Atraso) {
		this.hora = hora;
		this.infoVoo = infoVoo;
		this.companhia = Companhia;
		this.origem = Origem;
		this.atraso = Atraso;
		this.obs = "";
	}
	public String getcomp() {
		return this.companhia;
	}
	public Hora getat() {
		return this.atraso;
	}
	public String geto() {
		return this.origem;
	}
	
	@Override
	public String toString() {
		String a;
		String b;
		if (atraso.nulo()) {
			a="";
			b="";
		}else {
			a= atraso.toString();
			b = "Previsto: "+hora.hatraso(atraso).toString();
		}
		return String.format("%s\t %-10s \t %-18s \t %-20s \t %-5s \t %s",  hora.toString(),infoVoo,companhia,origem.toString(),a,b);

	}
	
}
