package aula13.ex1v2;

import java.util.Objects;

public class Provincia extends Regiao {
    String governador;

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), governador);
    }

    public Provincia(String nome, int populacao, String gov) {
        super(nome, populacao);
        this.governador=gov;
    }

    public String getGovernador() {
        return governador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(governador, provincia.governador);
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "governador='" + governador + '\'' +
                ", nome='" + nome + '\'' +
                ", populacao=" + populacao +
                '}';
    }
}
