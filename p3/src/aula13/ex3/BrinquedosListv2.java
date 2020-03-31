package aula13.ex3;

import java.util.*;
import java.util.stream.Collectors;

public class BrinquedosListv2 {

    private Map<String,Integer> counter;
    private HashMap<String , Set<String>> nomes;

    public BrinquedosListv2(){
        nomes = new LinkedHashMap<>();
        counter = new HashMap<>();
    }

    public void addicionar(String nome){
        String empreg = nome.split(" ")[0];
        if (counter.containsKey(empreg)){
            int c = counter.get(empreg);
            c++;
            counter.replace(empreg,c);
        }else{
            counter.put(empreg,1);
        }
    }
    public boolean remover(String nome){
        nome = nome.split(" ")[0];
        if (counter.containsKey(nome)){
            if (counter.get(nome)==1) {
                counter.remove(nome);
            }else{
                int i = counter.get(nome);
                i--;
                counter.replace(nome,i);
            }
        }else{
            return false;
        }
        return true;
    }

    public void show(){
        System.out.println("    |    Nome | contador");
        for (String nome:counter.keySet()) {
            System.out.println("    |    "+nome + " | "+counter.get(nome));
        }
    }

}
