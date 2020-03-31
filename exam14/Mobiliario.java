package exam14;

import java.io.ObjectInputStream;
import java.io.Serializable;

public abstract class Mobiliario implements Serializable {
    private String designacao;
    private int id;
    private TipoCadeira material;

    public Mobiliario(String designacao,int id,TipoCadeira material){
        this.designacao=designacao;
        this.id=id;
        this.material=material;
    }

    public abstract void saveCadeira(String s);

    public abstract void rescueCadeira(String s);

    public enum TipoCadeira {
        Madeira,Plastico,Metal,Sintetico
    }
    public void setAll(Object ob[]){
        this.designacao= (String) ob[0];
        this.id= (int) ob[1];
        this.material= (TipoCadeira) ob[2];
    }
    public Object[] getAll(){
        Object ob[]= {this.designacao,this.id,this.material};
        return ob;
    }

    @Override
    public String toString() {
        return "Mobiliario{" +
                "designacao='" + designacao + '\'' +
                '}';
    }
}
