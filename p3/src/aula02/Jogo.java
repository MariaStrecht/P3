package aula02;
import java.io.*;
import java.util.*;
public class Jogo {
	private ArrayList<String> words;
	private Grid sopa;
	private List<String> encontradas;
	
	public Jogo(String fname){
		Scanner scn=null;
		try {
			scn = new Scanner(new File(fname));
			String first = scn.nextLine();
			int tam = first.length();
			sopa = new Grid(tam);
			sopa.addword(first);
			words = new ArrayList<String>();
		} catch (Exception e) {
			System.out.println("Ficheiro nao encontrado");
			System.exit(1);
		}
		do {
			String line = scn.nextLine();
			if (line.contains(",")) {
				String temp[]=line.split(", ");
				for (int i = 0; i < temp.length; i++) {
					words.add(temp[i].toUpperCase());
				}
			}else if (line.contains(";")) {
				String temp[]=line.split(";");
				for (int i = 0; i < temp.length; i++) {
					words.add(temp[i].toUpperCase());
				}
			}else if (line.contains(" ")) {
				String temp[]=line.split(" ");
				for (int i = 0; i < temp.length; i++) {
					words.add(temp[i].toUpperCase());
				}
			}else {
				sopa.addword(line.toUpperCase());
			}
		} while (scn.hasNextLine());
		encontradas = new LinkedList<>();
	}
	public void start() {
		sopa.print();
		System.out.println();
		for (int i = 0; i < words.size(); i++) {
			searchword(words.get(i));
		}
		showresult();
	}
	public void searchword(String word) {
		char c = word.charAt(0);
		for (int y = 0; y < sopa.tam(); y++) {
			for (int x = 0; x < sopa.tam(); x++) {
				if (c == sopa.getletter(x, y)) {
					//System.out.println(x);
					//System.out.println(y);
					//System.out.println();
					if (toRigth(x,y,word)) {
						if(searchword("rigth",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"rigth"));
						}
					}else if (toLeft(x,y,word)) {
						if(searchword("left",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"left"));
						}
					}else if (toUp(x,y,word)) {
						if(searchword("up",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"up"));
						}
					}else if (toDown(x,y,word)) {
						if(searchword("down",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"down"));
						}
					}else if (toRigth(x,y,word)) {
						if(searchword("rigth",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"rigth"));
						}
					}else if (toRigthDown(x,y,word)) {
						if(searchword("rigthdown",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"rigthdown"));
						}
					}else if (toRigthUp(x,y,word)) {
						if(searchword("rigthhup",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"rigthhup"));
						}
					}else if (toLeftUp(x,y,word)) {
						if(searchword("leftup",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"leftup"));
						}
					}else if (toLeftDown(x,y,word)) {
						if(searchword("leftdown",x,y,word)) {
							encontradas.add(String.format(" %10s %d,%d %10s \n",word,y+1,x+1,"leftdown"));
						}
					}
				}
			}
		}
	}
	public boolean searchword(String direcao, int x, int y,String word) {
		int incx=0;
		int incy=0;
		if (direcao.contains("rigth")) {
			incx = 1;
		}else if(direcao.contains("left")){
			incx = -1;
		}
		if (direcao.contains("down")) {
			incy = 1;
		}else if(direcao.contains("up")){
			incy = -1;
		}
		String tmp ="";
		for (int i = 0; i < word.length(); i++) {
			tmp += sopa.getletter(x, y);
			x+=incx;
			y+=incy;
		}
		return tmp.equals(word);
	}
	public boolean toRigth(int x, int y,String word) {
		if (x + word.length() > sopa.tam()) {
			return false;
		}
		int id = x;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(id, y) != c) {		// percorrer a linha para a dieita
				return false;
			}
			id++;
		}
		return true;
	}
	public boolean toLeft(int x, int y, String word) {
		if ((x + 1 - word.length() )< 0) {
			return false;
		}
		int id =x;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(id, y) != c) {		// percorrer a linha para a esquerda
				return false;
			}
			id--;
		}
		return true;
	}
	public boolean toUp(int x, int y, String word) {
		if ((y + 1 - word.length() )< 0) {
			return false;
		}
		int id = y;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(x, id) != c) {		// percorrer a linha para cima
				return false;
			}
			id--;
		}
		
		return true;
	}
	public boolean toDown(int x, int y, String word) {
		if ((y + word.length() ) > sopa.tam()) {
			return false;
		}
		int id = y;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(x, id) != c) {		// percorrer a linha para baixo
				return false;
			}
			id++;
		}
		
		return true;
	}
	public boolean toLeftUp(int x,int y, String word) {
		if ((y + 1 - word.length() ) < 0 || (x + 1 - word.length() ) < 0) {
			return false;
		}
		int idX = x;
		int idY = y;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(idX, idY) != c) {		
				return false;
			}
			idX--;
			idY--;
		}
		return true;
	}
	public boolean toRigthUp(int x, int y, String word) {
		if ((y + 1 - word.length() ) < 0 || x + word.length() > sopa.tam()) {
			return false;
		}
		int idX = x;
		int idY = y;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(idX, idY) != c) {		
				return false;
			}
			idX++;
			idY--;
		}
		return true;
	}
	public boolean toLeftDown(int x, int y, String word) {
		if ((y + word.length() ) > sopa.tam() || x + 1 - word.length() < 0) {
			return false;
		}
		int idX = x;
		int idY = y;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(idX, idY) != c) {		
				return false;
			}
			idX--;
			idY++;
		}		
		return true;
	}
	public boolean toRigthDown(int x,int y , String word) {
		if ((y + word.length() ) > sopa.tam() || x + word.length() > sopa.tam()) {
			return false;
		}
		int idX = x;
		int idY = y;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (sopa.getletter(idX, idY) != c) {		
				return false;
			}
			idX++;
			idY++;
		}
		return true;
	}
	public void showresult() {
		for (int i = 0; i < encontradas.size(); i++) {
			System.out.println(encontradas.get(i));
		}
	}
	
}
