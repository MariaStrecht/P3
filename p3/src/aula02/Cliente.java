package aula02;

import java.time.LocalDate;
import java.util.*;

public class Cliente {
	/*Os clientes deste videoclube terão um número de sócio sequencial, data de inscrição de
	sócio e poderão ser de dois tipos:
	• Estudantes: caracterizados por um nome, número de CC, data de nascimento,
	número mecanográfico e curso;
	• Funcionários: caracterizados por um nome, número de CC, data de nascimento,
	número de funcionário e número fiscal.*/
	private String tipo;
	private int nsocio;
	private String nome;
	private int cc;
	private Data nasc;
	private Data insc;
	private int nmec;
	private String curso;
	private int nfunc;
	private int nif;
	private ArrayList<Video> vistos;
	
	public Cliente(String tipo,int nsocio, String nome, int cc, Data nasc, Data insc, int nmec, String curso) {
		this.tipo = tipo;
		this.nsocio = nsocio;
		this.nome = nome;
		this.cc = cc;
		this.nasc = nasc;
		this.insc = insc;
		this.nmec = nmec;
		this.curso = curso;
		this.vistos = new ArrayList<Video>();
	}
	public Cliente(String tipo, int nsocio, String nome, int cc, Data nasc, Data insc, int nfunc, int nif) {
		this.tipo = tipo;
		this.nsocio = nsocio;
		this.nome = nome;
		this.cc = cc;
		this.nasc = nasc;
		this.insc = insc;
		this.nfunc = nfunc;
		this.nif = nif;
	}
	public int getnsocio() {
		return this.nsocio;
	}
	public int getIdade() {
		LocalDate now = LocalDate.now();
		Data nasc = this.nasc;
		int idade = 0;
		
		if (now.getYear() > nasc.ano()) {
			if (now.getMonthValue() > nasc.mes()) {
				idade = now.getYear()-nasc.ano();
			}else if (now.getMonthValue() == nasc.mes()) {
				if (now.getDayOfMonth() < nasc.dia()) {
					idade = now.getYear()-nasc.ano()-1; 
				}else {
					idade = now.getYear()-nasc.ano();
				}
			}else {
				idade =  now.getYear()-nasc.ano() -1;
			}
		}
		return idade;
	}
	public String toString() {
		return String.format(" | %6d | %15s | %10d | %10s | \n", this.nsocio ,this.nome ,this.cc ,this.insc.toString());
	}
	public void addvid(Video v) {
		this.vistos.add(v);
	}
	public int vistos() {
		return this.vistos.size();
	}
}
