package aula13.ex3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EmpregadosList {

    private static Set<String> nomes;

    public EmpregadosList(){
        nomes = new HashSet<>();
    }

    public boolean addicionar(String nome){
        return nomes.add(nome);
    }

    public boolean remover(String nome){
        return nomes.remove(nome);
    }

    public void showList(){
        System.out.println("| id | Nome");
        Iterator<String> it = nomes.iterator();
        for (int j = 0; j < nomes.size(); j++) {
            System.out.println("| "+j+"  |-> "+it.next());
        }
    }

    public Set<String> getNomes() {
        return nomes;
    }
}
