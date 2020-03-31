package aula11.ex1;
import aula11.Circulo;
import aula11.Figura;
import aula11.Quadrado;
import aula11.Retangulo;

import java.util.Iterator;

public abstract class TestGeneric {
    public static void main(String[] args) {
        ArrayListGeneric<Pessoa> vp = new ArrayListGeneric<Pessoa>();
        for (int i=0; i<10; i++)
            vp.addElem(new Pessoa("Bebé no Vector "+i,
                    1000+i, Data.today()));
        Iterator<Pessoa> vec = vp.iterator();
        printSet(vp.iterator());
        LinkedListGeneric<Pessoa> lp = new LinkedListGeneric<Pessoa>();
        while ( vec.hasNext() )
            lp.addElem( vec.next() );
        Iterator<Pessoa> lista = lp.iterator();
        while ( lista.hasNext() )
            System.out.println( lista.next() );
        LinkedListGeneric<Figura> figList = new LinkedListGeneric<Figura>();
        figList.addElem(new Circulo(1,3, 1));
        figList.addElem(new Quadrado(3,4, 2));
        figList.addElem(new Retangulo(1,2, 2,5));
        printSet(figList.iterator());
        System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
        // Partindo do principio que Quadrado extends Rectangulo:
        LinkedListGeneric< Retangulo > quadList = new LinkedListGeneric<Retangulo>();
        quadList.addElem(new Quadrado(3,4, 2));
        quadList.addElem(new Retangulo(1,2, 2,5));
        System.out.println("Soma da Area de Lista de Quadrados: " +	sumArea(quadList));
    }


    public static double sumArea (LinkedListGeneric<? extends Figura> l) {
        // Deve aceitar uma Lista de (sub)tipos Figura e retornar o somatório das suas áreas
        double area = 0;

        for (Figura figura : l) {
            area += figura.area();
        }

        return area;
    }
    public static void printSet (Iterator MyIterator) {
        // Deve aceitar um iterador (MyIterator) e imprimir todos os elementos

        while (MyIterator.hasNext()) {
            System.out.println(MyIterator.next());

        }
    }

}