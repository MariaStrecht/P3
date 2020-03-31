package aula02;

import java.util.Arrays;

public class Grid {
	private char grid[][];
	private int tam;
	private int cont;
	
	public Grid(int tam) {
		this.cont=0;
		this.tam = tam;
		this.grid = new char[tam][tam];
	}
	public void addword(String word) {
		for (int i = 0; i < word.length(); i++) {
			grid[cont][i]= word.charAt(i);
		}
		cont++;
	}
	public int tam() {
		return this.tam;
	}
	public char getletter(int x, int y) {
		return grid[y][x];
	}
	public void print() {
		for (int x = 0; x < grid.length;x ++) {
			for (int y = 0; y < grid.length; y++) {
				System.out.print(grid[y][x]);
			}
			System.out.println();
		}
	}
}
