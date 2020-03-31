package aula03;

public class Estudantev2 extends Cliente {
	private int nmec;
	private String curso;

	public Estudantev2(int nsocio, String nome, int cc, Data nasc, Data insc, int nmec, String curso) {
		super(nsocio,nome,cc,nasc, insc);
		this.nmec = nmec;
		this.curso = curso;
	}
}
