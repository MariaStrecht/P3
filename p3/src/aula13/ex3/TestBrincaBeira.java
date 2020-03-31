package aula13.ex3;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class TestBrincaBeira {

    public static void main(String[] args) {

        String nomes[] = {"Maria Joana","Joaquim Antunes","Ana Catarina","Alexandre Rafael","Tatiana Bruna","Maria Barros","Ana Isabel","Jose Manuel","Jose Gabriel"};
        String brinquedos[] = {"Furry","Barbie","Polly","Peluche","Carro","Robo"};
        // Alinea a
        System.out.println("-------------------------|   Testando a lista de empregados  |-------------------------");
        EmpregadosList e = new EmpregadosList();
        System.out.println("--> Adicionando empregados");
        for (String em: nomes) {
            e.addicionar(em);
        }
        System.out.println("--> Removendo empregados");
        System.out.println("    + Testando com empregado existente : "+e.remover("Maria Joana"));
        System.out.println("    + Testando com empregado inexistente : "+e.remover("Mariana Luna"));
        System.out.println("--> Mostrando empregados");
        e.showList();
        // Alinea b
        System.out.println("-------------------------|   Testando o Gerador de premios  |-------------------------");
        RewardGenerator gen = new RewardGenerator();
        System.out.println("--> Generando pares pessoa-brinquedo");
        int cont = 0;
        for (String toy : brinquedos) {
            if (cont==3){
                break;
            }
            gen.generate(toy,e.getNomes());
            cont++;
        }
        System.out.println("--> Mostrando pares");
        gen.show_rew();
        // Alinea c
        System.out.println("-------------------------|   Testando a lista de brinquedos  |-------------------------");
        BrinquedosList bl = new BrinquedosList();
        bl.loadEmpregados(e.getNomes(), Arrays.stream(brinquedos).collect(Collectors.toSet()));
        bl.showBrinquedos();
        // Alinea d
        System.out.println("-------------------------|   Testando a lista de brinquedos(v2)  |-------------------------");
        BrinquedosListv2 bl2 = new BrinquedosListv2();
        for (String nome:nomes) {
            bl2.addicionar(nome);
        }
        bl2.show();
        System.out.println(" + Retirando 'Ana Catarina'");
        bl2.remover("Ana Catarina");
        bl2.show();
        System.out.println("-------------------------|   Testando a Gerador de Bilhetes  |-------------------------");
        BilhetesGenerator bg = new BilhetesGenerator(nomes);
        System.out.println(" -> Atribuindo 3 bilhetes");
        bg.generate(3);
        bg.show();
        System.out.println(" -> Atribuindo mais 5 bilhetes");
        bg.generate(5);
        bg.show();
    }

}
