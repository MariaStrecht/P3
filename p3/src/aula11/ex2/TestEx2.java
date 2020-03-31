package aula11.ex2;
import aula11.Circulo;
import aula11.Figura;
import aula11.Quadrado;
import aula11.Retangulo;
import aula11.ex1.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class TestEx2 {
    public static void main(String[] args) {
        System.out.println("------Primeira Lista------");
        List<Figura> figList = new LinkedList<>();
        System.out.println("|Figuras Adicionadas|:");
        Circulo c1 = new Circulo(1,3, 1);
        Quadrado q1 = new Quadrado(3,4, 2);
        Retangulo r1 = new Retangulo(1,2, 2,5);
        System.out.println(c1);
        System.out.println(q1);
        System.out.println(r1);
        figList.add(c1);
        figList.add(q1);
        figList.add(r1);
        System.out.println("----Resulados----");
        System.out.println("Soma da Area de Lista de todas as Figuras: " + areaTotalJ8(figList));
        System.out.println("Soma da Area de Lista de todos os Circulos: " + areaTotalJ8(figList,"Circulo"));
        // Partindo do principio que Quadrado extends Rectangulo:
        System.out.println();
        System.out.println("------Segunda Lista------");
        List< Figura> quadList = new LinkedList<>();
        System.out.println("|Figuras Adicionadas|:");
        Quadrado q2 = new Quadrado(3,4, 2);
        Retangulo r2 = new Retangulo(1,2, 2,5);
        Retangulo r3 = new Retangulo(1,2, 9,3);
        System.out.println(q2);
        System.out.println(r2);
        System.out.println(r3);
        quadList.add(q2);
        quadList.add(r2);
        quadList.add(r3);
        System.out.println("----Resulados----");
        System.out.println("Figura com mais area da lista: " +	maiorFiguraJ7(quadList));
        System.out.println("Figura com mais perimetro da lista: " +	maiorPerFiguraJ7(quadList));
        System.out.println("Soma das areas dos retangulos da lista:  "+areaTotalJ8(quadList,"Retangulo"));
    }

    private static Figura maiorFiguraJ7(List<Figura> figs) {
        Object tmp = figs.stream().max(Comparator.comparing(Figura::area)).get();
        return (Figura) tmp;
    }

    private static Figura maiorPerFiguraJ7(List<Figura> figs) {
        Object tmp = figs.stream().max(Comparator.comparing(Figura::perimetro)).get();
        return (Figura) tmp;
    }
    private static double areaTotalJ8(List<Figura> figs) {
        Object tmp = figs.stream().mapToDouble(Figura::area).sum();
        return (double) tmp;
    }
    private static double areaTotalJ8(List<Figura> figs,String subtipoNome){
        Object tmp = figs.stream().filter(f -> f.getClass().getSimpleName().equals(subtipoNome)).mapToDouble(Figura::area).sum();
        return (double) tmp;
    }
}