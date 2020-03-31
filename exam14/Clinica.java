package exam14;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Clinica implements Serializable{
    private String nome;
    private ListaGeneric<Mobiliario> moveis = new ListaGeneric<>();

    public Clinica(String nome){
        this.nome=nome;
    }

    public boolean addMobiliario(Mobiliario cd1) {
        if (!moveis.contains(cd1)){
            moveis.addElem(cd1);
            return true;
        }
        return false;
    }

    public void removeMobiliario(Mobiliario cd1) {
        if (moveis.contains(cd1)){
            moveis.removeElem(cd1);
            return;
        }
        System.out.println("ERRO");
    }

    public List<Transporte> listTransportes() {

        return moveis.toList().stream().map(movel ->{
            if (movel instanceof Transporte){
                return (Transporte) movel;
            }
            return null;
        }).filter(m->m!=null).collect(Collectors.toList());
    }

    public MyRangeIterator<Mobiliario> iterator() {
        return new MyIterator();
    }

    public void saveClinica(String fname) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(new File(fname)));
            o.writeObject(nome);
            o.writeObject(moveis);
            o.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rescueClinica(String fname) {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(new File(fname)))) {
            nome= (String) o.readObject();
            moveis = (ListaGeneric<Mobiliario>) o.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public class MyIterator implements MyRangeIterator<Mobiliario>{
        int i=0;

        @Override
        public boolean hasNext() {
            if (i<moveis.totalElem()){
                return true;
            }
            return false;
        }

        @Override
        public Mobiliario next() {
            if (hasNext()){
                return moveis.get(i++);
            }
            return null;
        }
    }
}
