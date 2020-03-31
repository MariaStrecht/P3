package aula01;

import java.util.*;

public class ex3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Menu :");
		System.out.println("1 - Círculo");
		System.out.println("2 - Quadrado");
		System.out.println("3 - Retangulo");
		System.out.println("0 - Sair");
		System.out.printf("Selecione a sua opcao : ");
		String op = sc.nextLine();
		String temp[] = op.split(" ");
	/*	for (int i = 0; i < temp.length; i++) {
			System.out.printf("-"+temp[i]+"-");
		}
	*/
		boolean b = (temp.length != 1);
		if (b) {
			System.out.println("Opçao invalida.");
			System.exit(0);
		}
		switch (temp[0]) {
		case "1":
			System.out.print("Raio :");
			double r = sc.nextDouble() ;
			System.out.println("Centro :");
			System.out.print("x: ");
			double x = sc.nextDouble() ;
			System.out.print("y: ");
			double y = sc.nextDouble() ;
			Circulo ci = new Circulo(x,y,r);
			circu(ci);
			break;
		case "2":
			System.out.print("Lado :");
			double l = sc.nextDouble() ;
			Quadrado q = new Quadrado(l);
			quad(q);
			break;
		case "3":
			System.out.print("Comprimento :");
			double comp = sc.nextDouble() ;
			System.out.print("Largura :");
			double larg = sc.nextDouble() ;
			Retangulo re = new Retangulo(comp, larg);
			retan(re);
			break;
		default:
			break;
		}
	}
	public static void circu(Circulo c) {
		System.out.println(c.toString());
		System.out.print("Comparar com outro Circulo (s/n):");
		String opc = sc.next();
		if (Objects.equals(opc,"s")) {
			System.out.print("Raio :");
			double r = sc.nextDouble() ;
			System.out.println("Centro :");
			System.out.print("x: ");
			double x = sc.nextDouble() ;
			System.out.print("y: ");
			double y = sc.nextDouble() ;
			Circulo ci = new Circulo(x,y,r);
			System.out.printf("Sao iguais : "+c.equalcir(ci)+"\n");
			System.out.printf("Intercetam-se : "+c.inter(ci));
		}
		System.exit(0);
	}
	public static void retan(Retangulo c) {
		System.out.println(c.toString());
		System.exit(0);
	}
	public static void quad(Quadrado c) {
		System.out.println(c.toString());
		System.exit(0);
	}

}
