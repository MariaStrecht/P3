package aula03;

import java.time.LocalDate;

public class Estudante extends Pessoa{
	//... definição de atributos
	private static int current_nmec = 100;
	private int nmec;
	static Data tmp = new Data(LocalDate.now().getDayOfMonth(),LocalDate.now().getDayOfMonth(),LocalDate.now().getYear());
	private Data insc;
	
	// Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974));
	public Estudante(String iNome, int iBI, Data iDataNasc, Data iDataInsc) {
		super(iNome,iBI,iDataNasc);
		this.insc = iDataInsc;
		this.nmec = current_nmec++;
		
	}
	public Estudante(String iNome, int iBI, Data iDataNasc) {
		this(iNome,iBI,iDataNasc,tmp);
		this.nmec = this.nmec++;
	}
	/**public String nome() {
		return super.nome();
	}	**/
	public int nMec() {
		return this.nmec;
	}
	//Andreia, BI: 9855678, Nasc. Data: 18/7/1974, NMec: 100, inscrito em
	//Data: 29/9/2014
	@Override public String toString() {
		return String.format("%s, NMec: %d, inscrito em %s ",super.toString(), this.nmec, this.insc.toString());
	}
	
}