package aula13.ex1v2;

import java.util.Objects;

public class Estado extends Regiao {
    Cidade capital;
    String tipo = "estado";

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capital, tipo);
    }

    public Estado(String nome, int populacao, Cidade capital) {
        super(nome, populacao);
        this.capital = capital;
    }

    public Cidade getCapital() {
        return capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estado estado = (Estado) o;
        return Objects.equals(capital, estado.capital);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "capital=" + capital +
                ", nome='" + nome + '\'' +
                ", populacao=" + populacao +
                '}';
    }
}
