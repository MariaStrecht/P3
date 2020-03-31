package aula13.ex1v2;

import java.util.Objects;

public class Aldeia extends Regiao {
    String tipo = "aldeia";
    public Aldeia(String nome, int populacao) {
        super(nome, populacao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aldeia aldeia = (Aldeia) o;
        return Objects.equals(tipo, aldeia.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipo);
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Aldeia " + this.nome + ", populacao " + this.populacao + ")";
    }
}
