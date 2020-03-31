package aula12.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface AgendaStructure {
	public void savecontacts(File ficheiro,Pessoa con[]) throws FileNotFoundException;
	public Pessoa[] seecontacts(File ficheiro) throws IOException;
	
}
