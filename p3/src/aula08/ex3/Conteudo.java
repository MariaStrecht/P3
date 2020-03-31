package aula08.ex3;

import java.util.ArrayList;
import java.util.HashMap;

public class Conteudo {
	
	private HashMap<String,ArrayList<Pergunta>> quiz = new HashMap<>();	//organizado por nivel de dificuldade
	private int nperguntas = 0;
	
	public void addPergunta(Pergunta p) {
		String dificuldade = String.valueOf(p.getdif());
		if (quiz.containsKey(dificuldade)) {
			quiz.get(dificuldade).add(p);
		}else {
			ArrayList<Pergunta> tmp = new ArrayList<Pergunta>();
			tmp.add(p);
			quiz.put(dificuldade, tmp);
		}
		nperguntas++;
		System.out.println("adic pergunta");
	}
	public boolean remPergunta(Pergunta p) {
		String dific[] = quiz.keySet().toArray(new String[0]);

		for (String string : dific) {
			ArrayList<Pergunta> ap = quiz.get(string);
			if(ap.remove(p)) {
				if(ap.size() == 0) quiz.remove(string);
				nperguntas--;
				return true;
			}
		}

		return false;
		
	}
	
	public int getC_if() {
		int min = Integer.MAX_VALUE;
		for(String key : quiz.keySet().toArray(new String[0])) {
			min = Math.min(Integer.parseInt(key), min);
		}
		return min;
	}
	public int getnperg() {
		return this.nperguntas;
	}
	public ArrayList<Pergunta> get(int key) {
		return quiz.get(String.valueOf(key));
	}
}
