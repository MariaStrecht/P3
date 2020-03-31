package exam14;

public class CadeiraRodas extends Cadeira implements Transporte{
    private int nrodas;
    private boolean eletrica;
    private TipoTransporte tipoTransporte;
    public CadeiraRodas(String designacao, int id, Mobiliario.TipoCadeira material, Cadeira.TipoCadeira tipo, double altura, int numero, int nrodas, boolean elet) {
        super(designacao,id,material,tipo,altura,numero);
        this.nrodas=nrodas;
        this.eletrica=elet;
    }

    @Override
    public void setTipo(TipoTransporte tran) {
        this.tipoTransporte=tran;
    }

    @Override
    public TipoTransporte getTipo() {
        return tipoTransporte;
    }

    @Override
    public String toString() {
        return "CadeiraRodas{" +
                "tipoTransporte=" + tipoTransporte +
                '}';
    }
}
