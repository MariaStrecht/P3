package aula04.ex1;

import java.util.ArrayList;

import aula04.*;

public class Disciplina {
	
//	Nome da disciplina (String)
//	o Área científica (String)
//	o ECTS (int)
//	o Responsável (Professor) // Um professor é uma pessoa com nfunc e dataAdmissao
//	o Alunos (Estudante[ ]) // Vetor dinâmico de Estudantes não "repetidos"
	String nome;
	String area;
	int ECTs;
	Professor responsavel;
	ArrayList<Estudante> alunos;
	// Disciplina dis = new Disciplina("P5", "Informatica", 6, pf1);
	public Disciplina(String nome, String area,int ects , Professor p) {
		this.nome = nome;
		this.area=area;
		this.responsavel = p;
		this.ECTs = ects;
		alunos = new ArrayList<Estudante>();
	}
	
	public boolean addAluno(Estudante est) // Adiciona um aluno à Disciplina
	{
		if (alunoInscrito(est.nMec())) {
			return false;
		}
		return alunos.add(est);
	}
	public boolean delAluno(int nMec) // Remove um aluno da Disciplina
	{
		if (!alunoInscrito(nMec)) {
			return false;
		}
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).nMec()==nMec) {
				alunos.remove(alunos.get(i));
				break;
			}
		}
		return true;
	}
	public boolean alunoInscrito(int nMec) // Verifica se aluno está inscrito à	disciplina
	{
		if (alunos.isEmpty()) {
			return false;
		}
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).nMec()==nMec) {
				return true;
			}
		}
		return false;
	}
	public int numAlunos() // Retorna o Nº de Alunos Inscritos
	{
		return alunos.size();
	}
	
//	Disciplina: P5 ( 6 ECTS) da Area de Informatica
//	Responsável: PROFESSOR: Jose Manuel, BI: 11223344, Nascido na Data: 11/9/1999, NMec: 1,
//	Admitido em Data: 25/10/2007
//	Existem 6 Alunos Inscritos
	
	public String toString() // Retorna as características da Disciplina
	{
		return "Disciplina: "+this.nome+" ( "+this.ECTs+" ECTS ) da Are de Informatica\nResponsável: PROFESSOR: "+this.responsavel.toString()+",\nExistem "+this.numAlunos()+" Alunos Inscritos ";
		//return "Nome : "+this.nome+"; Area : "+this.area+";\n Info do Responsavel : "+this.responsavel.toString();
	}
	public Estudante[] getAlunos() // Retorna uma lista com todos os alunos da disciplina
	{
		Estudante[] tmp = new Estudante[alunos.size()];
		tmp = alunos.toArray(tmp);
		return tmp;
	}
	public Estudante[] getAlunos(String tipo) // Retorna uma lista com todos os alunos da disciplina do subtipo “tipo”
	{
		ArrayList<Estudante> tmp = new ArrayList<Estudante>();
		for (int i = 0; i < getAlunos().length; i++) {
			if (getAlunos()[i].getClass().getSimpleName().toString().contains(tipo)) {
				tmp.add(getAlunos()[i]);
			}
		}
		return tmp.toArray(new Estudante[0]);
	}
}
