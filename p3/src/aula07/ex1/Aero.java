package aula07.ex1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;




public class Aero {

	private List<Voo> lvoos = new ArrayList<>();
	private HashMap<String,String> sigla_companhia = new HashMap<>();
	
	public void read(String fvoos, String fcomp) throws IOException{
		Path pp = Paths.get(fvoos);
		Path pc = Paths.get(fcomp);
		List<String> voos = Files.readAllLines(pp);
		List<String> companhias = Files.readAllLines(pc);
		
		//LOAD COMPANHIAS
		for (int i = 1; i < companhias.size(); i++) {
			String l[] = companhias.get(i).split("\t");
			sigla_companhia.put(l[0], l[1]);
		}
		
		//LOAD VOOS
		for (int i = 1; i < voos.size(); i++) {
			String[] l = voos.get(i).split("\t");
			String companhia = sigla_companhia.get(l[1].substring(0, 2));
			if(companhia == null) continue;
			Hora atraso;
			if(l.length < 4) {
				atraso = new Hora(0,0);
			}
			else {
				atraso = new Hora(l[3]);
			}
			lvoos.add(new Voo(new Hora(l[0]),l[1],companhia,l[2],atraso));
		}
		
	}
	public void atraso_c() {
		List<Companhia> c = new ArrayList<>();
		String com_infoo[] = sigla_companhia.values().toArray(new String[0]);
		Voo a_voos[] = lvoos.toArray(new Voo[0]);
		for (String cp : com_infoo) {
			int cont = 0;
			int soma = 0;
			for (Voo voo : a_voos) {
				if (voo.getcomp().equals(cp)) {
					soma += voo.getat().tominutos();
					cont++;
				}
			}
			double med = (soma/cont);
			//System.out.println("->"+(int)med);
			c.add(new Companhia(cp,(int)med));
		}
		
		//	ORDENAR
		Collections.sort(c,new Comparator<Companhia>() {
			@Override
			public int compare(Companhia c1, Companhia c2) {
				return c1.compareTo(c2);
			}
		});
		System.out.printf("%-17s\t %s\n","Companhia" , "Atraso Médio");
		for (Companhia comp : c) {
			System.out.println(comp.toString());
		}
	}
	public void cidades_v(String fish) throws IOException {
		HashMap<String,Integer> cidades = new HashMap<String, Integer>();
		Voo a_voos[] = lvoos.toArray(new Voo[0]);
		for (Voo voo : a_voos) {
			String key = voo.geto();
			if (cidades.containsKey(voo.geto())) {
				int value = cidades.get(key);
				cidades.put(key, value+1);
			}else {
				cidades.put(key, 1);
			}
		}
		
		// HashMap to Array
		String a_c[] = cidades.keySet().toArray(new String[0]);
		
		//	ORDENAR
		Arrays.sort(a_c,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return cidades.get(s1)-cidades.get(s2); // diferenca dos atrasos
			}
		});
		String print = String.format("%-17s\t %s\n","Origem" , "Voos");
		for (String cid : a_c) {
			print += String.format("%-17s\t %s\n",cid , cidades.get(cid));
		}
		savefile(fish, print);
		
	}
	
	public void printVoos() {
		System.out.println("Hora \t Voo \t\t Companhia \t\t Origem \t\t Atraso\tObs");
		for(Voo v: lvoos) {
			System.out.println(v);
		}
	}
	public String print_f(){
		String s = "Hora \t Voo \t\t Companhia \t\t Origem \t\t Atraso\tObs\n";
		for(Voo v: lvoos) {
			s += v.toString()+"\n";
		}
		return s;
	}
	
	public void savefile(String fish ,String s) throws IOException {
		Path fs = Paths.get(fish);
		Files.write(fs,s.getBytes());
	}
	public void savefile_bin(String fs ,String s) throws IOException {
		RandomAccessFile file = new RandomAccessFile(fs, "rw");
		file.write(s.getBytes());
		file.close();
	}
	public void readfile_bin(String fs) throws IOException {
		RandomAccessFile file = new RandomAccessFile(fs, "rw");
		byte[] info = new byte[(int)file.length()];
		file.readFully(info);
		file.close();
		System.out.println(new String(info));
	}
}
