package aula03;

import java.util.ArrayList;

public class ex3 {

	public static void main(String[] args) {
		
		
		Condutor c1 = new Condutor("Humberto Leal",999888777,new Data(3,10,1989),'B');
		Condutor c2 = new Condutor("Alexandra Ribeiro",543895039,new Data(2,8,1999),'A');
		Condutor c3 = new Condutor("Joana Almeida",965987333,new Data(4,5,1974),'D');
		
		Ligeiro l = new Ligeiro(200,100,4,1000); 
		Motociclo m = new Motociclo(100,50,2,500);
		Passageiros p = new Passageiros(150,100,50,1500);
		
		System.out.println("-------------------------- Condutores criados --------------------------");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println();
		System.out.println("-------------------------- Veiculos criados --------------------------");
		System.out.println(l);
		System.out.println(m);
		System.out.println(p);
		System.out.println();
		
		Pessoa p1 = new Pessoa("Maria Silva",245875309,new Data(4,5,2000));
		Pessoa p2 = new Pessoa("Bruno Gomes",223875459,new Data(2,7,2001));
		Pessoa p3 = new Pessoa("Joana Rodrigo",1234765097,new Data(5,2,2010));
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------- Tentando colocar passageiro no Ligeiro -------------");
		l.addpass(p1);
		System.out.println();

		System.out.println("-------------------------------------------------------------");
		System.out.println("------------- Adicionando condutor no Ligeiro -------------");
		System.out.println(" -> Tentar com condutor com carta-tipo 'A' :");
		l.addcond(c2);
		System.out.println();
		System.out.println(" -> Tentar com condutor com carta-tipo 'B' :");
		l.addcond(c1);
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println("------ Tentando colocar novamente passageiro no Ligeiro ------");
		l.addpass(p1);
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("------------- Adicionando condutor no Motociclo -------------");
		System.out.println(" -> Tentar com condutor com carta-tipo 'A' :");
		m.addcond(c2);
		System.out.println();
		System.out.println(" -> Tentar com condutor com carta-tipo 'B' :");
		m.addcond(c1);
		System.out.println();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------- Tentando adicionar passageiros no Motociclo  -------------");
		System.out.println(" -> Primeiro passsageiro : ");
		m.addpass(p1);
		System.out.println(" -> Segundo passsageiro : ");
		m.addpass(p2);
		System.out.println(" -> Terceiro passsageiro : ");
		m.addpass(p3);
		ArrayList<Pessoa> autocarro = new ArrayList();
		for (int i = 0; i < 51; i++) {
			Pessoa pi = new Pessoa("Passageiro",i,new Data(3,10,2000));
			autocarro.add(pi);
		}
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("------------- Adicionando conjunto de passageiros no Autocarro  -------------");
		System.out.println(" -> Condutor :");
		System.out.println(" -> Tentar com condutor com carta-tipo 'D' :");
		p.addcond(c3);
		System.out.println(" -> Agora passageiros : ");
		p.addpass(autocarro);
		
		
		
		
		
	
	

	}
}
