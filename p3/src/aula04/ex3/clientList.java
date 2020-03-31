package aula04.ex3;

import java.util.ArrayList;
import aula04.*;

public class clientList {
	public ArrayList<Cliente> cl;
	
	public clientList() {
		cl = new ArrayList<Cliente>();
	}
	public void addclient(String nome, int cc, Data nasc, Data insc, int nmec, String curso) {
		Cliente e = new Estudantev2(cl.size(),nome,cc,nasc,insc,nmec,curso);
		cl.add(e);
	}
	public void addclient(String nome, int cc, Data nasc, Data insc, int nfunc, int nif) {
		Cliente f = new Funcionario(cl.size(),nome,cc,nasc,insc,nfunc,nif);
		cl.add(f);
	}
	public void removeclient(int nsocio) {
		for (int i = 0; i < cl.size(); i++) {
			if (cl.get(i).getnsocio() == nsocio) {
				cl.remove(i);
				break;
			}
		}
	}
	public int getidade (int id) {
		return cl.get(id).getIdade();
	}
	public Cliente getcl(int id) {
		return cl.get(id);
	}
}
