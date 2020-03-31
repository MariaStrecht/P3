package exam14;

public class Cama extends Mobiliario{
    private double comp,larg;
    private boolean colchao;

    public Cama(String designacao, int id, TipoCadeira material,double comp,double larg,boolean colchao) {
        super(designacao, id, material);
        this.comp=comp;
        this.larg=larg;
        this.colchao=colchao;
    }

    @Override
    public void saveCadeira(String s) {
    }

    @Override
    public void rescueCadeira(String s) {

    }

    @Override
    public String toString() {
        return "Cama{}";
    }
}
