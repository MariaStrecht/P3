package aula13.ex1v2;

public class Cidade extends Regiao {
    String tipo = "cidade";
    public Cidade(String nome, int populacao) {
        super(nome, populacao);
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Cidade " + this.nome + ", populacao " + this.populacao + ")";
    }
}
