package aula13.ex3;

import java.util.*;

public class BilhetesGenerator {

    private List<String> nome;
    private Set<String> luckyones;
    private int current_id;

    public BilhetesGenerator(String nomes[]){
        nome = Arrays.asList(nomes);
        luckyones = new HashSet<>();
        current_id=0;
    }

    public void generate(int num){
        Set<String> recebem = new HashSet<>();
        for (int i = 0; i < num; i++) {
            luckyones.add(nome.get(current_id));
            current_id++;
            if (current_id==nome.size()-1){
                current_id=0;
            }
        }
    }

    public void show(){
        System.out.println("    -+ | Empregados com bilhete atribuido |");
        for (String n:luckyones){
            System.out.println("    -+      "+n);
        }
    }

}
