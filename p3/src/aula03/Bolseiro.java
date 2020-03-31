package aula03;

import java.time.LocalDate;

public class Bolseiro extends Estudante{
/**	 Crie a classe Bolseiro que deverá incluir um atributo com o montante da bolsa.
	 Defina novos métodos ou reescreva os métodos que julgar conveniente. Acrescente
	 métodos get/set associados ao valor da bolsa	**/
	private int montante;
	static Data tmp = new Data(LocalDate.now().getDayOfMonth(),LocalDate.now().getDayOfMonth(),LocalDate.now().getYear());
	
	// Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974));
	public Bolseiro(String iNome, int iBI, Data iDataNasc, Data iDataInsc) {
		super(iNome,iBI,iDataNasc,iDataInsc);
		this.montante=0;
		
	}
	public Bolseiro(String iNome, int iBI, Data iDataNasc) {
		this(iNome,iBI,iDataNasc,tmp);
	}
	public void setBolsa(int m) {
		this.montante = m;
	}
	public int bolsa() {
		return this.montante;
	}
/** public int nMec() {
		return super.nMec();
	}
	public String nome() {
		return super.nome();
	}**/
	@Override public String toString() {
		return String.format("%s, Bolsa: %d ",super.toString(),this.bolsa());
	}
}
