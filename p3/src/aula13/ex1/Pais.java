package aula13.ex1;

import javax.print.PrintException;
import java.util.LinkedList;

public class Pais {
    String nome;
    Localidade capital;
    LinkedList<Regiao> regioes = new LinkedList<>();

    public Pais(String nome, Localidade capital) {
        this.nome = nome;
        if (capital.getTipo().equals(TipoLocalidade.Cidade)) {
            this.capital = capital;
        }else{
            throw new IllegalArgumentException("Capital Invalida");
        }

      //  addRegiao(capital);
    }

    public Pais(String nome) {
        this.nome = nome;
        this.capital = new Localidade("*Indefenida*",0,null);
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
}
