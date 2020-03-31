package aula12.ex3;

import aula12.ex3.Pessoa;

import java.io.FileNotFoundException;

public interface AgendaPlugin {
    public Pessoa[] loadFile(String fname) throws FileNotFoundException;
    public void saveFile(Pessoa[] con ,String fname) throws FileNotFoundException;
}
