package aula11.ex1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex1v2 {

    public static int wordcount;
    public static int tmp;

    public static void main(String[] args) {
        String file = "/src/aula11/ex1/nobodysperfect.txt";
        file = "/home/maria/Documents/P_III/P3/src/aula11/ex1/nobodysperfect.txt";
        alinea_b(file);
        alinea_c(file);
        alinea_d(file);

    }

    public static void alinea_b(String file) {
        System.out.println("----Alinea b----");
        HashSet<String> hs = new HashSet<>();
        wordcount = 0;
        try {
            List<String> rawInfo = Files.readAllLines(Paths.get(file));
            rawInfo.stream().flatMap(line -> {  // tranforma todas as linhas em arrays de palavras
                return Arrays.stream(line.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]"));
            }).forEach(word-> {
                if (!word.isEmpty()) {
                    hs.add(word);       // adiciona cada string ao hashset
                    wordcount++;        //incrementa num de palavras lidas
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Número Total de Palavras: " +wordcount+
                "\nNúmero de Diferentes Palavras: "+hs.size());
        System.out.println();
    }

    public static void alinea_c(String file) {
        System.out.println("----Alinea c----");
        HashMap<String , Integer> hm = new HashMap<String, Integer>();
        wordcount = 0;
        try {
            List<String> rawInfo = Files.readAllLines(Paths.get(file));
            rawInfo.stream().flatMap(line -> {
                return Arrays.stream(line.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+"));
            }).forEach(word -> {
                word = word.toLowerCase();
                if (!word.isEmpty()) {
                    wordcount++;
                    if (hm.containsKey(word)) {
                        tmp = hm.get(word);
                        tmp++;
                        hm.replace(word, tmp);
                    } else {
                        hm.put(word, 1);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("file not found");
        }
        System.out.println("Número Total de Palavras: " +wordcount+
                "\nNúmero de Diferentes Palavras: "+hm.keySet().size());
        printHashMap(hm);
        System.out.println();
    }

    public static void alinea_d(String file) {
        System.out.println("----Alinea d----");
        Map<String , Integer> hm = new TreeMap<String, Integer>();
        int size=0;
        try {
            List<String> rawInfo = Files.readAllLines(Paths.get(file));
            rawInfo.stream().flatMap(line -> {
                return Arrays.stream(line.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+"));
            }).forEach(word -> {
                word = word.toLowerCase();
                if (!word.isEmpty()) {
                    wordcount++;
                    if (hm.containsKey(word)) {
                        tmp = hm.get(word);
                        tmp++;
                        hm.replace(word, tmp);
                    } else {
                        hm.put(word, 1);
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("file not found");
        }
        LinkedList<String> tmp =  new LinkedList<String>(hm.keySet());
        Collections.sort(tmp,new Comparador());
        System.out.println("Número Total de Palavras: " +size+
                "\nNúmero de Diferentes Palavras: "+hm.keySet().size());
        Map<String , Integer> ordenada = new TreeMap<String, Integer>();
        for (String s:tmp
             ) {
            ordenada.put(s,hm.get(s));
        }
        printTreeMap(ordenada);
        System.out.println();
    }

    public static void printHashMap(HashMap<String,Integer> hm) {
        for (String word : hm.keySet().toArray(new String[hm.keySet().size()])) {
            System.out.println("|"+word+"|"+" -> "+hm.get(word));
        }
    }
    public static void printTreeMap(Map<String,Integer> hm) {
        for (String word : hm.keySet().toArray(new String[hm.keySet().size()])) {
            System.out.println("|"+word+"|"+" -> "+hm.get(word));
        }
    }

    public static class Comparador implements Comparator<String>{

        @Override
        public int compare(String s1, String s2) {

            return s1.compareTo(s2);

        }

    }

}