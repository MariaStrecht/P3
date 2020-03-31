package aula13.ex1;

import java.util.Objects;

public class Regiao {
    String nome;
    int populacao;

    public Regiao(String nome, int populacao) {
        this.nome = nome;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regiao regiao = (Regiao) o;
        return populacao == regiao.populacao &&
                Objects.equals(nome, regiao.nome);
    }

    @Override
    public String toString() {
        return "Regiao{" +
                "nome='" + nome + '\'' +
                ", populacao=" + populacao +
                '}';
    }
}
