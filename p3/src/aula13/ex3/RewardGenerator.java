package aula13.ex3;

import java.util.*;

public class RewardGenerator {

    private HashMap<String,String> rewarded;

    public RewardGenerator(){
        rewarded = new HashMap<>();
    }
    public void generate(String brinquedo, Set<String> empregados){
        System.out.println("------| Atribuindo premio |");
        System.out.println("    + Brinquedo a ser oferecido : "+brinquedo);
        String emp=gen_empregado(empregados);
        System.out.println("    + Empregado a ser premiado : "+emp);
        rewarded.put(emp,brinquedo);
    }
    public String gen_empregado(Set<String> empregados){
        String empregado = "";
        boolean found = false;
        while (!found){
            int id = (int) (Math.random() * empregados.size());
            int i = 0;
            for (String emp:empregados) {
                if (id==i){
                    if (rewarded.containsKey(emp)){
                        continue;
                    }
                    empregado = emp;
                    found = true;
                    break;
                }
                i++;
            }
        }
        return empregado;
    }
    public void show_rew(){
        System.out.println(" |   Empregado --> brinquedo    ");
        for (String emp:rewarded.keySet()) {
            System.out.println(" | "+emp+" --> "+rewarded.get(emp));
        }
    }
}
