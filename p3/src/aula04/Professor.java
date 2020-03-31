package aula04;

import java.time.LocalDate;

public class Professor extends Pessoa{
	// // Um professor é uma pessoa com nfunc e dataAdmissao
	int nfunc;
	static int nf = 0;
	Data dataAdmissao;
	static Data tmp = new Data(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
// Professor pf1 = new Professor("Jose Manuel", 11223344, new Data(11, 9, 1969));
	public Professor(String iNome, int BI, Data nasc) {
		super(iNome,BI,nasc);
		this.nfunc = nf++;
		this.dataAdmissao = Data.today();
	}
//	Jose Manuel, BI: 11223344, Nascido na Data: 11/9/1999, NMec: 1,
//	Admitido em Data: 25/10/2007
	public String toString() {
		return super.toString()+", Nfunc: "+this.nfunc+", \nAdmitido em Data: "+this.dataAdmissao.toString();
	}
	
}
