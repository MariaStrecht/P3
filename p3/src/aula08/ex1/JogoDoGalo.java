package aula08.ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JogoDoGalo {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Jogo do Galo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 400);
		Engine j = new Engine("X");
//		JPanel content = new JPanel();
//		content.setBackground(Color.white);
//		content.setLayout(new FlowLayout());
//		JButton b1 = new JButton("Button 1");
//		JButton b2 = new JButton("Button 2");
//		content.add(b1);
//		content.add(b2);
//		f.setContentPane(content);
//		f.setVisible(true);
//		
		JPanel gpanel = new JPanel();
		gpanel.setLayout(new GridLayout(3, 3));
		JToggleButton b1 = new JToggleButton("");
		JToggleButton b2 = new JToggleButton("");
		JToggleButton b3 = new JToggleButton("");
		JToggleButton b4 = new JToggleButton("");
		JToggleButton b5 = new JToggleButton("");
		JToggleButton b6 = new JToggleButton("");
		JToggleButton b7 = new JToggleButton("");
		JToggleButton b8 = new JToggleButton("");
		JToggleButton b9 = new JToggleButton("");
		b1.setFont(new Font("Arial", Font.BOLD, 100));
		b2.setFont(new Font("Arial", Font.BOLD, 100));
		b3.setFont(new Font("Arial", Font.BOLD, 100));
		b4.setFont(new Font("Arial", Font.BOLD, 100));
		b5.setFont(new Font("Arial", Font.BOLD, 100));
		b6.setFont(new Font("Arial", Font.BOLD, 100));
		b7.setFont(new Font("Arial", Font.BOLD, 100));
		b8.setFont(new Font("Arial", Font.BOLD, 100));
		b9.setFont(new Font("Arial", Font.BOLD, 100));
		gpanel.add(b1);
		gpanel.add(b2);
		gpanel.add(b3);
		gpanel.add(b4);
		gpanel.add(b5);
		gpanel.add(b6);
		gpanel.add(b7);
		gpanel.add(b8);
		gpanel.add(b9);
		f.setContentPane(gpanel);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b1,0,0);
				showWinner(j);
				b1.setEnabled(false);
			}
			});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b2,0,1);
				showWinner(j);
				b2.setEnabled(false);
				//j.printGame();
			}
			});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b3,0,2);
				showWinner(j);
				b3.setEnabled(false);
//				j.printGame();
			}
			});
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b4,1,0);
				showWinner(j);
				b4.setEnabled(false);
//				j.printGame();
			}
			});
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b5,1,1);
				showWinner(j);
				b5.setEnabled(false);
//				j.printGame();
			}
			});
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b6,1,2);
				showWinner(j);
				b6.setEnabled(false);
//				j.printGame();
			}
			});
		
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b7,2,0);
				showWinner(j);
				b7.setEnabled(false);
//				j.printGame();
			}
			});
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b8,2,1);
				showWinner(j);
				showWinner(j);
				b8.setEnabled(false);
//				j.printGame();
			}
			});
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j.changeText(b9,2,2);
				showWinner(j);
				b9.setEnabled(false);
//				j.printGame();
			}
			});
		
		f.setVisible(true);
	}
	public static void showWinner(Engine j) {
		if (j.winner!=null) {
			String s = String.format("✧･ﾟ: *✧･ﾟ:*✧･ﾟ: *✧･ﾟ:*  \nO Jogador '%s' GANHOU!\n%d jogadas\n✧･ﾟ: *✧･ﾟ:* ✧･ﾟ: *✧･ﾟ:* ",j.winner,j.nplays);
			if (j.winner == "empate") {
				s = "✧･ﾟ: *✧･ﾟ:*✧･ﾟ: *✧･ﾟ:*  \nFoi um EMPATE\n"+j.nplays+" jogadas\n✧･ﾟ: *✧･ﾟ:* ✧･ﾟ: *✧･ﾟ:* ";
			}
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,s);
			System.exit(1);
		}
	}
	
}
	