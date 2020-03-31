package aula13.ex1v2;

import java.util.LinkedList;
import java.util.Objects;

public class Pais {
    String nome;
    Cidade capital;
    LinkedList<Regiao> regioes = new LinkedList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nome, pais.nome) &&
                Objects.equals(capital, pais.capital) &&
                Objects.equals(regioes, pais.regioes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, capital, regioes);
    }

    public Pais(String nome, Cidade capital) {
        this.nome = nome;
        this.capital = capital;
    }

    public Pais(String nome) {
        this.nome = nome;
        this.capital = new Cidade("*Indefenida*",0);
    }

    public void addRegiao(Regiao reg) {
        if (reg.equals(null)){
            return;
        }
        if (!regioes.contains(reg)){
            regioes.add(reg);
        }
    }

    public boolean remRegiao(Regiao reg) {
        if (reg.equals(null)){
            return false;
        }
        if (regioes.contains(reg)){
            return regioes.remove(reg);
        }
        return false;
    }

    public int getPopulacao(){
        return regioes.stream().mapToInt(Regiao::getPopulacao).sum();
    }

    @Override
    public String toString() {
        return "Pais: "+this.nome+", Populaçao: "+getPopulacao()+" (Capital: "+this.capital;
    }

    public LinkedList<Regiao> getRegioes() {
        return regioes;
    }
}
