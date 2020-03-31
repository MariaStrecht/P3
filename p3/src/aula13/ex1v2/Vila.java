package aula13.ex1v2;

import java.util.Objects;

public class Vila extends Regiao {
    String tipo = "vila";

    public Vila(String nome, int populacao) {
        super(nome, populacao);
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vila vila = (Vila) o;
        return Objects.equals(tipo, vila.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipo);
    }

    @Override
    public String toString() {
        return "Vila " + this.nome + ", populacao " + this.populacao + ")";
    }
}
