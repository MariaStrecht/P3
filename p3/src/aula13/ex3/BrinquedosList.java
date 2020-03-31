package aula13.ex3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class BrinquedosList {

    private HashMap<String , Set<String>> nomes;

    public BrinquedosList(){
        nomes = new LinkedHashMap<>();
    }

    public void loadEmpregados(Set<String> empregado, Set<String> toys){
        Set<String> nome = empregado.stream().map(x -> {
            String n[] = x.split(" ");
            String primeiro = n[0];
            return primeiro;
        }).collect(Collectors.toSet());
        for (String em : nome){
            if (nomes.containsKey(em)) {
                Set<String> b = nomes.get(em);
                b.addAll(toys);
                b = b.stream().map(x -> {
                    return em+x;
                }).collect(Collectors.toSet());
                nomes.replace(em,b);
            }else {
                Set<String> b = new HashSet<>();
                b.addAll(toys);
                b = b.stream().map(x -> {
                    return em+" "+x;
                }).collect(Collectors.toSet());
                nomes.put(em,b);
            }
        }
    }
    public void showBrinquedos(){
        System.out.println();
        System.out.println("------> | Mostrando nomes de brinquedos possiveis |\n");
        for (String nome:nomes.keySet()) {
            System.out.printf("| ");
            for (String toy:nomes.get(nome)) {
                System.out.printf(toy+" | ");
            }
            System.out.println();
        }
        System.out.println();
    }



}
