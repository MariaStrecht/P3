package exam14;

public class CamaArticulada extends Cama{
    private boolean eletrica;

    public CamaArticulada(String designacao, int id, TipoCadeira material, double comp, double larg, boolean colchao,boolean eletrica) {
        super(designacao, id, material, comp, larg, colchao);
        this.eletrica=eletrica;
    }

    @Override
    public String toString() {
        return "CamaArticulada{" +
                "eletrica=" + eletrica +
                '}';
    }
}
