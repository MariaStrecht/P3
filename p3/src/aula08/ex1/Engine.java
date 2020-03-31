package aula08.ex1;
import javax.swing.JToggleButton;

public class Engine {
	static String op;
	static String winner;
	static String[][] game = new String[3][3];
	static int nplays;
	
	public Engine(String op) {
		this.op = op;
		this.nplays = 0;
	}
	public void changeop() {
		if (op.equals("X")) {
			this.op = "O";
		}else {
			this.op = "X";
		}
	}
	
	public void changeText(JToggleButton b, int x, int y) {
		this.nplays++;
		if (b.getText()=="") {
			b.setText(op);
			addplay(x,y);
		}
		changeop();
		if (ISwinner("X")) {
			this.winner = "X";
		}else if (ISwinner("O")) {
			this.winner = "O";
		}else if (nplays==9) {
			this.winner = "empate";
		}
	}
	
	public boolean ISwinner(String s_op) {
		boolean w = true;
		
		// check lines
		for (int i = 0; i < 3; i++) {
			w = true;
			for (int j = 0; j < 3; j++) {
				if (game[i][j] != s_op) w = false; 
			}
			if (w) {
				return true;
			}
		}
		
		// check columns
		for (int i = 0; i < 3; i++) {
			w = true;
			for (int j = 0; j < 3; j++) {
				if (game[j][i] != s_op) w = false; 
			}
			if (w) {
				return true;
			}
		}
		
		// check diagonals
		if ((game[0][0]==s_op) && (game[1][1]==s_op) && (game[2][2]==s_op)) {
			return true;
		}else if ((game[2][0]==s_op) && (game[1][1]==s_op) && (game[0][2]==s_op)) {
			return true;
		}
		
		return false;
		
	}
	
	public void addplay(int x, int y) {
		game[x][y] = op;
	}
	public void printGame() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				System.out.print("|"+game[x][y]+"|");
			}
			System.out.println("\n---------");
		}
		System.out.println();
	}
	
}
