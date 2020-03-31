package aula08.ex3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class QQSMEngine {
	JFrame f;
	JLabel image,pergunta,premio;
	JButton aj_pub, aj_tel, aj_50, confirmar,desistir;
	JRadioButton r1,r2,r3,r4;
	ButtonGroup bg;
	Conteudo quiz;
	Pergunta c_pergunta;
	int premios[] = {0, 25,    50,    125,    250,   500,750,   1500,  2500,  5000,   10000, 16000, 32000, 64000, 125000, 250000};
	int respondidas;
	String selected;
	String correct_b;
	
	public void app() {
		f = new JFrame("Quem que ser Milionário");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 600);
		f.setLayout(new BorderLayout());
		image = new JLabel();
		quiz = new Conteudo();
		r1 = new JRadioButton("");
		r2 = new JRadioButton("");
		r3 = new JRadioButton("");
		r4 = new JRadioButton("");
		bg = new ButtonGroup();
		pergunta = new JLabel();
		premio = new JLabel();
		
		JPanel l = new JPanel();
		l.setLayout(new BoxLayout(l,BoxLayout.PAGE_AXIS));
		//l.setBackground(Color.MAGENTA);
		l.add(premio);
		l.add(Box.createRigidArea(new Dimension(0,10)));
		l.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JPanel tmp = new JPanel();
		tmp.setLayout(new BorderLayout());
		tmp.add(pergunta, BorderLayout.CENTER);
		pergunta.setBorder(BorderFactory.createLineBorder(Color.black));
		//pergunta.setFont(new Font("Arial", Font.BOLD, 10));
		l.add(tmp);
		JPanel opcoes = new JPanel();
		
		aj_pub = new JButton("Ajuda Público");
		aj_pub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int l = -1;
				int h = -1;
				if(quiz.getC_if()==0) {
					h = 90;
					l = 70;
				}else if(quiz.getC_if()==1) {
					h = 70;
					l = 50;
				}else if(quiz.getC_if()==2) {
					h = 50;
					l = 40;
				}
				//ordena de forma aleatoria os botoes
				Enumeration<AbstractButton> temp = bg.getElements();
				List<String> op = new ArrayList<String>();
				while(temp.hasMoreElements()) op.add(temp.nextElement().getText());
				
				Collections.shuffle(op);
				String janela = "";
				int id = -1;
				for(int i = 0; i < 4; i++) {
					if(op.get(i).equals(c_pergunta.correctanswer())) id = i;
				}
				//Escolhe probabilidade da resposta correta
				int corr_p = l + (int)(Math.random() * (h - l + 1));
				h = 100-corr_p;
				l = 0;
				int num = 0;
				for(int i = 0; i < 4; i++){
					if(i == id) {
						janela += op.get(i)+": "+corr_p+"%\n";
						continue;
					}
					if(num >= 2) {
						janela += op.get(i)+": "+h+"%\n";
						continue;
					}
					int prob = l + (int)(Math.random() * (h - l + 1));
					janela += op.get(i)+": "+prob+"%\n";
					h = h - prob;
					num++;
				}
				JOptionPane.showMessageDialog(null,janela,"Respostas do Publico", JOptionPane.INFORMATION_MESSAGE);
				aj_pub.setEnabled(false);
			}
			});
		
		aj_tel = new JButton("Telemovel");
		aj_tel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int l = -1;
				int h = -1;
				if(quiz.getC_if()==0) {
					h = 100;
					l = 80;
				}else if(quiz.getC_if()==1) {
					h = 80;
					l = 60;
				}else if(quiz.getC_if()==2) {
					h = 60;
					l = 40;
				}
				String info = "Uma das seguintes:\n";
				int corr_p =l + (int)(Math.random() * (h - l));
				int id = 1 + (int)(Math.random()*3);
				info += corr_p+"% -> "+ c_pergunta.getanswers()[0]+"\n";
				info += (100-corr_p)+"% -> "+ c_pergunta.getanswers()[id]+"\n";
				JOptionPane.showMessageDialog(null,info,"Telefone", JOptionPane.INFORMATION_MESSAGE);
				aj_tel.setEnabled(false);
			}
			});
		
		aj_50 = new JButton("50_50");
		aj_50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				do {
					i = (int)(Math.random()*4);
				} while (i == 0);
				System.out.println(i);
				System.out.println("ENTROU");
				r1.setEnabled(false);
				r2.setEnabled(false);
				r3.setEnabled(false);
				r4.setEnabled(false);
				enableb(i);
				enableb(0);
				aj_50.setEnabled(false);
			}
			});
		
		desistir = new JButton("Desistir");
		desistir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				end();
			}
			});
		
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				checkanswer();
			}
			});	
		r1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected = r1.getActionCommand();
			}
			});	
		r2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected = r2.getActionCommand();
			}
			});
		r3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected = r3.getActionCommand();
			}
			});
		r4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected = r4.getActionCommand();
			}
			});
		JPanel but= new JPanel();
		but.setLayout(new BoxLayout(but , BoxLayout.PAGE_AXIS));
		JPanel ajudas = new JPanel();
		ajudas.setLayout(new GridLayout(1,3));
		ajudas.add(aj_pub);
		ajudas.add(aj_tel);
		ajudas.add(aj_50);
		but.add(ajudas);
		
		opcoes.setLayout(new GridLayout(2,2));
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		opcoes.add(r1);
		opcoes.add(r2);
		opcoes.add(r3);
		opcoes.add(r4);
		
		JPanel c_d = new JPanel();
		c_d.setLayout(new GridLayout(0,2));
		c_d.add(confirmar);
		c_d.add(desistir);
		l.add(c_d);
		but.add(opcoes);
		loadfromfile();
		
		//f.add(premio, BorderLayout.PAGE_START);
		f.add(l, BorderLayout.EAST);
		f.add(image , BorderLayout.CENTER);
		f.add(but, BorderLayout.SOUTH);
		//f.add(opcoes,BorderLayout.SOUTH);
		f.setVisible(true);
	}
	public void loadfromfile() {
		try {
			List<String> rawInfo = Files.readAllLines(Paths.get("/home/maria/Documents/P_III/p3/src/aula08/ex3/perguntas.txt"));
			for (String string : rawInfo) {
				if (string.isBlank()) {
					break;
				}
				String info[] = string.split("%");
				String r[] = {info[2],info[3],info[4],info[5]};
				Pergunta tmp = new Pergunta(info[0], info[1], r, Integer.parseInt(info[6]));		
				System.out.println(tmp.getimagem());
				quiz.addPergunta(tmp);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
		System.out.println("LOAD FILE COMPLETE");
		loadnextq();
	}
	
	public void checkanswer() {
		if (selected.equals(c_pergunta.correctanswer())) {
			quiz.remPergunta(c_pergunta);
			respondidas++;
			loadnextq();
		}else {
			end();
		}
	}
	public void end() {
		String s = String.format("✧･ﾟ: *✧･ﾟ:*✧･ﾟ: *✧･ﾟ:*  \nGANHOU!\n%d euros\n✧･ﾟ: *✧･ﾟ:* ✧･ﾟ: *✧･ﾟ:* ",premios[respondidas]);
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame,s);
		System.exit(1);
	}
	
	public void loadnextq() {
		 if (quiz.getnperg()==0) {
			end();
			 return;
		}
		System.out.println(quiz.getC_if());
		 
		ArrayList<Pergunta> question_opcions = quiz.get(quiz.getC_if()) ;
		
		System.out.println(question_opcions.size());
		
		int id = (int)(Math.random()*question_opcions.size());
		
		System.out.println(id);
		
		c_pergunta = question_opcions.get(id);
		System.out.println(c_pergunta.getpergunta());
		pergunta.setText(c_pergunta.getpergunta());
		premio.setText(premios[respondidas]+"€");
		System.out.println("-----");
		String respostas[] = c_pergunta.getanswers();
		List<Integer> ordem = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			ordem.add(i);
		}
		Collections.shuffle(ordem);											// Definir ordem das respostas
		r1.setText(respostas[ordem.get(0)]);
		r2.setText(respostas[ordem.get(1)]);
		r3.setText(respostas[ordem.get(2)]);
		r4.setText(respostas[ordem.get(3)]);
		bg.clearSelection();
		enableall();
		ImageIcon imageIcon = new ImageIcon(c_pergunta.getimagem()); // load the image to a imageIcon
		Image imagem = imageIcon.getImage(); // transform it 
		Image newimg = imagem.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		image.setIcon(imageIcon);
		SwingUtilities.updateComponentTreeUI(f);
	}
	public void enableall() {
		r1.setEnabled(true);
		r2.setEnabled(true);
		r3.setEnabled(true);
		r4.setEnabled(true);
	}
	public void enableb(int i) {
		switch (getbutton(c_pergunta.getanswers()[i])) {
		case "r1":
			r1.setEnabled(true);
			break;
		case "r2":
			r2.setEnabled(true);
			break;
		case "r3":
			r3.setEnabled(true);
			break;
		case "r4":
			r4.setEnabled(true);
			break;
		default:
			break;
		}
	}
	public String getbutton(String ans) {
		if (ans.equals(r1.getActionCommand())) {
			return "r1";
		}else if (ans.equals(r2.getActionCommand())) {
			return "r2";
		}else if (ans.equals(r3.getActionCommand())) {
			return "r3";
		}else if (ans.equals(r4.getActionCommand())) {
			return "r4";
		}
		return "";
	}
}
