package aula12.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
	private ArrayList<Pessoa> contactos = new ArrayList<Pessoa>();
	private ArrayList<AgendaPlugin> plug = new ArrayList<>();

	public Agenda(){
		plugins_load();
	}
	public void plugins_load(){
		File proxyList = new File("src/aula12/reflection/plugins");
		for (String f: proxyList.list()) {
			System.out.println(f);
			try {
				plug.add(PluginManager.load("aula12.reflection.plugins."+f.substring(0,f.lastIndexOf('.'))));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void save(String fname, AgendaPlugin pl) throws FileNotFoundException {
		pl.saveFile(contactos.toArray(new Pessoa[contactos.size()]),fname);
	}
	public void show_agenda(){
		for (Pessoa p: contactos) {
			System.out.println(p);
		}
	}
	public void load(String fname) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		File f = new File(fname);

/**		File folder = new File("src/aula12/ex3/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}**/
		if (f.exists()) System.out.println("existe");
		Scanner s = new Scanner(f);
		String tipo = s.nextLine();
		Class cl = Class.forName("reflection.plugins."+tipo);
		AgendaPlugin ap = (AgendaPlugin) cl.newInstance();
		s.close();
		update(ap.loadFile(fname));
	}
	public void add(Pessoa p){
		contactos.add(p);
	}
	public ArrayList<AgendaPlugin> getplugins(){
		return plug;
	}
	@Override
	public String toString() {
		return contactos.toString();
	}
	
	public void update(Pessoa p[]) {
		for (Pessoa i : p) {
			contactos.add(i);
		}
	}

}
