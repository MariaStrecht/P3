package aula03;

public class Test {
	public static void main(String[] args) {
		Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974));
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Data(11, 5, 1976));
		bls.setBolsa(745);
		System.out.println("Estudante: "+est.nome());
		System.out.println(est);
		System.out.println("Bolseiro: "+ bls.nome() + ", NMec: " + bls.nMec() + ", Bolsa:" + bls.bolsa());
		System.out.println(bls);
		Bolseiro bls2 = new Bolseiro ("Maria", 93089, new Data(4, 5, 2000));
		System.out.println("Bolseiro: "+ bls2.nome() + ", NMec: " + bls2.nMec() + ", Bolsa:" + bls2.bolsa());
		System.out.println(bls2);
	}
}
