package aula03;

public class Funcionario extends Cliente{
	private int nfunc;
	private int nif;

	public Funcionario(int nsocio, String nome, int cc, Data nasc, Data insc, int nfunc, int nif) {
		super(nsocio,nome,cc,nasc, insc);
		this.nfunc = nfunc;
		this.nif = nif;
	}
}
