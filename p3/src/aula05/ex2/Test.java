package aula05.ex2;

import aula05.UtilCompare;

public class Test {
	public static void main(String[] args) {
		
		
		// Veiculos sem servico
		Automovel aut = new Automovel(2000, "MT-20-30", "branco", 1600 , 280, 80,"gasoleo",7);
		Moto mo = new Moto(2010, "CR-79-98", "vermelho", 2, 500, 180, 50,"gasolina", 6);
		Bicicleta bic = new Bicicleta("branco",2017);
		
		//Veiculos com serviço
		CarroPolicia cp = new CarroPolicia(2018, "PS-98-76", "azul", 4, 2000, 200, 140, "gasolina", 9);
		MotoPolicia mp = new MotoPolicia(2000, "KX-09-78", "azul", 2, 500, 180, 50, "gasolina", 6);
		BicicletaPolicia bp = new BicicletaPolicia("preta",2014);
		
		System.out.println("----Veiculos Disponiveis----");
		System.out.println("|"+aut+"|");
		System.out.println(aut.data());
		
		System.out.println("|"+mo+"|");
		System.out.println(mo.data());
		
		System.out.println("|"+bic+"|");
		System.out.println(bic.data());
		
		System.out.println("|"+cp+"|");
		System.out.println(cp.data()+"Serviço: "+cp.getTipo());
		
		System.out.println("|"+mp+"|");
		System.out.println(mp.data()+"Serviço: "+mp.getTipo());
		
		System.out.println("|"+bp+"|");
		System.out.println(bp.data()+"Serviço: "+bp.getTipo());
		System.out.println();
		
		System.out.println("----Testando funçoes de retorno----");
		System.out.println("- Automovel tem a mesma cor que a bicicleta : ");
		System.out.println("	-> "+aut.getCor().equals(bic.getCor())); //TRUE
		System.out.println("- Automovel tem a mesma cilindrada que a moto : ");
		System.out.println(String.format("	-> %b", aut.getCilindrada()== mo.getCilindrada())); //FALSE
		
		System.out.println("- CarroPolicia tem o mesmo serviço que a MotoPolicia : ");
		System.out.println(String.format("	-> %b", cp.getTipo()== mp.getTipo())); //TRUE
		System.out.println();
		System.out.println("----Comparação de veiculos----");
		System.out.println("Criando Lista de Veiculos para ordenar");
		Veiculo lista[]= new Veiculo[6];
		lista[0]=aut;
		lista[1]=mo;
		lista[2]=bic;
		lista[3]=cp;
		lista[4]=mp;
		lista[5]=bp;
		
		System.out.println("-> Lista sem ser ordenada : ");
		for (Veiculo veiculo : lista) {
			System.out.println("	-"+veiculo.toString());
		}
		System.out.println();
		System.out.println("-> Lista ordenada : ");
		UtilCompare.sortArray(lista);
		for (Veiculo veiculo : lista) {
			System.out.println("	-"+veiculo.toString());
		}
	}
	
}
