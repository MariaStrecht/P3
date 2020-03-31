package aula04.ex3;

import java.util.ArrayList;


public class Catalogo {
private static ArrayList<Video> cat;
	
	public Catalogo() {
		cat = new ArrayList<Video>();
	}
	public static void add(String titulo, String categoria, String idade) {
		Video vtemp = new Video(cat.size(),titulo,categoria,idade);
		cat.add(vtemp);
	}
	public void rem(int id) {
		cat.remove(id);
	}
	public String showavailable() {
		String s ="";
		for (int i = 0; i < cat.size(); i++) {
			if (cat.get(i).disp()==true) {
				s = s + cat.get(i).toString();
			}
		}
		return s;
	}
	public Video[] to_array() {
		Video v[]= new Video[cat.size()];
		for (int i = 0; i < cat.size(); i++) {
			v[i]=cat.get(i);
		}
		return v;
	}
	public void showList(int idade){
		// idade (ALL, M6, M12, M16, M18)
		String s ="";
		boolean empty = false;
		if (idade >= 18) {
			if (!showM18(s).equals("")) {
				s = showM18(s);
			}else {
				empty = true;
			}
		}else if (idade >= 16) {
			if (!showM16(s).equals("")) {
				s = showM16(s);
			}else {
				empty = true;
			}			
		}else if (idade >= 12) {
			if (!showM12(s).equals("")) {
				s = showM12(s);
			}else {
				empty = true;
			}
		}else if (idade >= 6) {
			if (!showM6(s).equals("")) {
				s = showM6(s);
			}else {
				empty = true;
			}
		}else {
			if (!showAll(s).equals("")) {
				s = showAll(s);
			}else {
				empty = true;
			}
		}
		if (empty) {
			System.out.println(" Não existem videos disponiveis ");
		}else {
			System.out.println(" --------Videos Disponiveis--------- ");
			System.out.printf(" | %2s | %15s | %10s | %4s | %6s | \n","id","Título","Categoria","Idade","Rating");
			System.out.printf(s);
		}
	}
	public String showAll(String str) {
		for (int i = 0; i <cat.size(); i++) {
			if (cat.get(i).idade().equals("ALL")) {
				str = str +  cat.get(i).toString();
			}
		}
		return str;
	}
	public String showM6(String str) {
		for (int i = 0; i <cat.size(); i++) {
			if (cat.get(i).idade().equals("M6")) {
				str = str +  cat.get(i).toString();
			}
		}
		return showAll(str);
	}
	public String showM12(String str) {
		for (int i = 0; i <cat.size(); i++) {
			if (cat.get(i).idade().equals("M12")) {
				str = str +  cat.get(i).toString();
			}
		}
		return showM6(str);
	}
	public String showM16(String str) {
		for (int i = 0; i <cat.size(); i++) {
			if (cat.get(i).idade().equals("M16")) {
				str = str +  cat.get(i).toString();
			}
		}
		return showM12(str);
	}
	public String showM18(String str) {
		for (int i = 0; i <cat.size(); i++) {
			if (cat.get(i).idade().equals("M18")) {
				str = str +  cat.get(i).toString();
			}
		}
		return showM16(str);
	}
	public Video searchbyname(String name) {
		
		int id = 666;
		for (int i = 0; i < cat.size(); i++) {
			if (name.equals(cat.get(i).nome())) {
				id = i;
			}
		}
		return cat.get(id);
	}
	public Video getVideo(int id) {
		return cat.get(id);
	}
	public void devolucao(int id) {
		for (int i = 0; i < cat.size(); i++) {
			if (cat.get(i).currentuser() == id) {
				Video v = cat.get(i);
				v.devolucao();
				break;
			}else if (i == cat.size()-1) {
				System.out.println("Video nao requisitado por esse utilizador ");
			}
		}
	}
	public String showbyrating(double r) {
		String s ="";
		for (int i = 0; i < cat.size(); i++) {
			if (cat.get(i).rating() == r) {
				s = s + cat.get(i).toString();
			}
		}
		return s;	
	}
}
