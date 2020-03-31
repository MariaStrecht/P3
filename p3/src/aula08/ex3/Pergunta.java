package aula08.ex3;

public class Pergunta {
	private String pergunta;
	private String respostas[];
	private String imagem;
	private int dificuldade;
	
	public Pergunta(String pergunta, String imagem, String respostas[],  int dificuldade) {
		this.pergunta = pergunta;
		this.respostas = respostas;
		this.imagem = imagem;
		this.dificuldade = dificuldade;
		System.out.println(this.pergunta+"-"+this.respostas[0]+"-"+this.imagem+"-"+this.dificuldade);
	}
	
	public int getdif() {
		return dificuldade;
	}
	public String getpergunta() {
		return this.pergunta;
	}
	public String getimagem() {
		return this.imagem;
	}
	public String[] getanswers() {
		return this.respostas;
	}
	public String correctanswer() {
		return this.respostas[0];
	}
	
}
