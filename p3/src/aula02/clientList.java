package aula02;

import java.util.ArrayList;

public class clientList {
	public ArrayList<Cliente> cl;
	
	public clientList() {
		cl = new ArrayList<Cliente>();
	}
	public void addclient(String tipo, String nome, int cc, Data nasc, Data insc, int nmec, String curso) {
		Cliente cltemp = new Cliente(tipo,cl.size(),nome,cc,nasc,insc,nmec,curso);
		cl.add(cltemp);
	}
	public void addclient(String tipo,String nome, int cc, Data nasc, Data insc, int nfunc, int nif) {
		Cliente cltemp = new Cliente(tipo,cl.size(),nome,cc,nasc,insc,nfunc,nif);
		cl.add(cltemp);
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
