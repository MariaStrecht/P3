package aula13.ex1;

import java.util.Objects;

public class Localidade extends Regiao {
    TipoLocalidade tipo ;

    public Localidade(String nome, int populacao, TipoLocalidade tipo) {
        super(nome, populacao);
        this.tipo = tipo;
    }

    public TipoLocalidade getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Localidade that = (Localidade) o;
        return tipo == that.tipo;
    }

    @Override
    public String toString() {
        if (this.tipo == null){
            return this.nome + ", populacao " + this.populacao + ")";
        }
        return this.tipo + " " + this.nome + ", populacao " + this.populacao + ")";
    }
}
