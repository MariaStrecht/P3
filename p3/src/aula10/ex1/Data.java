package aula10.ex1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		if(dataValida(dia,mes,ano)){
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}else {
			throw new IllegalArgumentException("Data Invalida");
		}
	}
	public int dia() {
		return this.dia;
	}
	public int mes() {
		return this.mes;
	}
	public int ano() {
		return this.ano;
	}
	private boolean dataValida(int dia, int mes,int ano) {
		if(mes <1 || mes >12) {
			return false;
		}
		if(dia <= 0) {
			return false;
		}
		if(ano <= 0) {
			return false;
		}
		if(diasdoMes(mes,ano) >= dia) {
			return true;
		}
		return false;
	}
	private int diasdoMes(int m, int a) {
		int dias[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		boolean bis = (a%4 ==0 & a%100 !=0 || a%400 ==0);
		if(m == 2 && bis==true) return 29;
		return dias[m];
	}
	public String toString() {
		return String.format("%d/%d/%d", dia(),mes(),ano());
	}
	public static Data today() {
		String s = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());
		String[] hoje = s.split("-");
		int dia = Integer.parseInt(hoje[0]);
		int mes = Integer.parseInt(hoje[1]);
		int ano = Integer.parseInt(hoje[2]);
		Data t = new Data( dia, mes, ano);
		return t;
	}
}
