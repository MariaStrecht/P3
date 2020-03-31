package aula13.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Ex2 {

    private static TreeMap<String,Map<String,Integer>> found = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        readfile("src/aula13/ex2/Policarpo.txt");
        show();
    }
    public static void readfile(String text){
        List<String> linhas = null;
        List<String> words = null;
        try {
            linhas = Files.readAllLines(Paths.get(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String linha:linhas) {
            String w[] = linha.split("[ \\\t\\\n\\.\\,\\:\\'\\‘\\’\\;\\?\\!\\-\\*\\{\\}\\=\\+\\&\\/\\(\\)\\[\\]\\”\\“\\\"\\'\\\\]+");
            words = Arrays.stream(w).filter(x -> (x.length()>3 && !x.isBlank())).map(x-> x.toLowerCase()).collect(Collectors.toList());
            loadconteudo(words);
        }
    }
    public static void loadconteudo(List<String> words){
        String palavras[] = words.toArray(new String[words.size()]);
        for (int i = 0; i < palavras.length -1 ; i++) {
            String a = palavras[i];     //carrega palavra atual e seguinte
            String b = palavras[i+1];
            if (found.containsKey(a)){      //verifica se a palavra atual ja foi encontrada e se ja adiciona a seguinte
                Map<String,Integer> tmp = found.get(a); // se ainda nao tiver sido adicionada
                int c = 1;                                    // se esta ja existir incrementa o contador
                if (tmp.containsKey(b)){
                    c = tmp.get(b);
                    c++;
                }
                tmp.put(b,c);
            }else{                              // se a palavra atual nao tiver sido encontrada adiciona a e adiciona
                Map<String,Integer> tmp = new TreeMap<>();  // a seguinte tambem
                tmp.put(b,1);
                found.put(a,tmp);
            }
        }
    }
    public static void show(){
        System.out.print(found.toString().replaceAll("},","}\n"));
    }
}
