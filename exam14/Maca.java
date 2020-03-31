package exam14;

public class Maca extends Marquesa implements Transporte{
    private int ngrades;
    private TipoTransporte transporte;

    public Maca(String designacao, int id, TipoCadeira material, double comp, double larg, boolean colchao, int ngrades) {
        super(designacao, id, material, comp, larg, colchao, false);
        this.ngrades=ngrades;
    }

    @Override
    public void setTipo(TipoTransporte tran) {
        this.transporte=tran;
    }

    @Override
    public TipoTransporte getTipo() {
        return transporte;
    }

    @Override
    public String toString() {
        return "Maca{}";
    }
}
