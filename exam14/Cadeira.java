package exam14;

import java.io.*;

public class Cadeira extends Mobiliario{
    private int numero;
    private double altura;
    private TipoCadeira tipoCadeira;

    public Cadeira(String designaçao, int id, Mobiliario.TipoCadeira material, TipoCadeira tipoCadeira, double altura, int numero) {
        super(designaçao,id,material);
        this.tipoCadeira=tipoCadeira;
        this.altura=altura;
        this.numero=numero;
    }

    public enum TipoCadeira {
         Escritorio,Espera,Atendimento
    }

    @Override
    public void saveCadeira(String s) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(s)))) {
            Cadeira t = new Cadeira("",0, Mobiliario.TipoCadeira.Metal,this.tipoCadeira,this.altura,this.numero);
            t.setAll(this.getAll());
            out.writeObject(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rescueCadeira(String s) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(s)))) {
            Cadeira tem = (Cadeira) in.readObject();
            this.numero=tem.numero;
            this.altura=tem.altura;
            this.tipoCadeira=tem.tipoCadeira;
            this.setAll(tem.getAll());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Cadeira{" +
                "numero=" + numero +
                ", altura=" + altura +
                ", tipoCadeira=" + tipoCadeira +
                '}';
    }
}
