package aula06;

import java.time.LocalDate;
import aula04.*;

public class Estudante  extends Pessoa{
	//... definição de atributos
		private static int current_nmec = 100;
		private int nmec;
		private Data insc;
		
		// Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974));
		public Estudante(String iNome, int iBI, Data iDataNasc, Data iDataInsc) {
			super(iNome,iBI,iDataNasc);
			this.insc = iDataInsc;
			this.nmec = current_nmec++;
			
		}
		public Estudante(String iNome, int iBI, Data iDataNasc) {
			this(iNome,iBI,iDataNasc,Data.today());
			this.nmec = this.nmec++;
		}
		public int getNMec() {
			return this.nmec;
		}
		//Andreia, BI: 9855678, Nasc. Data: 18/7/1974, NMec: 100, inscrito em
		//Data: 29/9/2014
//		Jose, BI: 85265426, Nascido na Data: 15/2/1976, Estudante NMec: 102, Inscrito em Data:
//			25/10/2007
		@Override public String toString() {
			return String.format(" %sEstudante NMec: %d, Inscrito em %s ",super.toString(), this.nmec, this.insc.toString());
		}
}
