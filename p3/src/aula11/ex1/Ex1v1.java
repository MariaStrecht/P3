package aula11.ex1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Ex1v1 {

    public static void main(String[] args) {
        String file = "/src/aula11/ex1/nobodysperfect.txt";
        file = "/home/maria/Documents/P_III/P3/src/aula11/ex1/nobodysperfect.txt";
        alinea_b(file);
     //   alinea_c(file);
     //   alinea_d(file);

    }

    public static void alinea_b(String file) {
        System.out.println("----Alinea b----");
        HashSet<String> hs = new HashSet<>();
        int wordcount = 0;
        try {
            List<String> rawInfo = Files.readAllLines(Paths.get(file));
            for (String string : rawInfo) {
                if (string.isEmpty()) {
                    continue;
                }
                String tmp[] =  string.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+");
                for (String string2 : tmp) {
                    hs.add(string2);
                }
                wordcount += tmp.length;
            }
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
        int size=0;
        try {
            List<String> rawInfo = Files.readAllLines(Paths.get(file));
            for (String string : rawInfo) {
                if (string.isEmpty()) {
                    continue;
                }
                String tmp[] =  string.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+");
                size += tmp.length;
                for (String string2 : tmp) {
                    if (string2.isEmpty()) {
                        continue;
                    }
                    string2 = string2.toLowerCase();
                    if (hm.containsKey(string2)) {
                        int c = hm.get(string2);
                        c++;
                        hm.replace(string2, c);
                    }else {
                        hm.put(string2, 1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("file not found");
        }
        System.out.println("Número Total de Palavras: " +size+
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
            for (String string : rawInfo) {
                if (string.isEmpty()) {
                    continue;
                }
                String tmp[] =  string.split("[* \\[\\]\\,\\.\\(\\)\\#\\%\\;\\-\\'\\[\\]\\:\\!]+");
                size += tmp.length;
                for (String string2 : tmp) {
                    if (string2.isEmpty()) {
                        continue;
                    }
                    string2 = string2.toLowerCase();
                    if (hm.containsKey(string2)) {
                        int c = hm.get(string2);
                        c++;
                        hm.replace(string2, c);
                    }else {
                        hm.put(string2, 1);
                    }
                }
            }
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