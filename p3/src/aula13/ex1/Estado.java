package aula13.ex1;

import java.util.Objects;

public class Estado extends Regiao{
    Localidade capital;

    public Estado(String nome, int populacao, Localidade capital) {
        super(nome, populacao);
        if (capital.getTipo().equals(TipoLocalidade.Cidade)) {
            this.capital = capital;
        }else{
            throw new IllegalArgumentException("Capital Invalida");
        }
    }

    public Localidade getCapital() {
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
