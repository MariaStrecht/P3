package exam14;

public class Marquesa extends Cama{
    private boolean inclinacao;

    public Marquesa(String designacao, int id, TipoCadeira material, double comp, double larg, boolean colchao,boolean inclinacao) {
        super(designacao, id, material, comp, larg, colchao);
        this.inclinacao=inclinacao;
    }

    @Override
    public String toString() {
        return "Marquesa{}";
    }
}
