package aula08.ex3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;


import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
public class Engine extends JFrame {
	
	JTextArea question, c_price;
	JButton ajudap, telefone, cinquenta, desistir, confirmar;
	JRadioButton r1, r2, r3, r4;
	ButtonGroup buttons;
	JLabel imagem = new JLabel();
	private JScrollPane jScrollPanel = new JScrollPane();
	Conteudo quiz;
	Pergunta c_pergunta;
	int premios[] = {0, 25,    50,    125,    250,   500,750,   1500,  2500,  5000,   10000, 16000, 32000, 64000, 125000, 250000};
	int respondidas;
	
	
	
	public Engine() {
		super("Quem quer ser milionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		int width = 660;
		int height = 455;
		setLayout(new FlowLayout());
		quiz = new Conteudo();
		question = new JTextArea();
		
		show();
		
		loadfromfile();
		
		ajudap = new JButton("Ajuda Público");
		ajudap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			});
		
		telefone = new JButton("Ajuda Público");
		telefone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			});
		
		cinquenta = new JButton("Ajuda Público");
		cinquenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			});
		
		desistir = new JButton("Ajuda Público");
		desistir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			});
		
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			});
		r1 = new JRadioButton("");
		r2 = new JRadioButton("");
		r3 = new JRadioButton("");
		r4 = new JRadioButton("");
		buttons = new ButtonGroup();
		buttons.add(r1);
		buttons.add(r2);
		buttons.add(r3);
		buttons.add(r4);
		
		question = new JTextArea();
//		question.setBackground(new Color(240, 240, 240));
//	    question.setColumns(20);
//	    question.setEditable(false);
//	    question.setFont(new Font("Arial", 0, 25));
//	    question.setLineWrap(true);
//	    question.setRows(5);
	    question.setWrapStyleWord(true);
	    question.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 0));
	    jScrollPanel.setViewportView(question);
		
	    show();
	    
	    nextQuestion();
	    
		setSize(width,height);
		setVisible(true);
	}
	public void nextQuestion() {
		if (quiz.getnperg()==0) {
			fim();
			return;
		}else {
			ArrayList<Pergunta> question_opcions = quiz.get(quiz.getC_if()) ;
			int id = (int)Math.random()*question_opcions.size();
			c_pergunta = question_opcions.get(id);
			question.setText(c_pergunta.getpergunta());
			c_price.setText(premios[respondidas]+"€");
			
			
		}
	}
	public void check(String selecionada) {
		if (selecionada.equals(c_pergunta.correctanswer())) {
			respondidas++;
			quiz.remPergunta(c_pergunta);
			nextQuestion();
		}else fim();
	}
	public void fim() {
		String s = "Ganhou "+ premios[respondidas]+"euros";
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame,s);
		System.exit(1);
	}
	public void show() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);	
		var okButton = new JButton("OK");
        var closeButton = new JButton("Close");
//		layout.setAutoCreateGaps(true);
//		layout.setAutoCreateContainerGaps(true);
//		layout.setHorizontalGroup(layout.createSequentialGroup()
//		        .addPreferredGap(RELATED,
//		                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//		        .addComponent(okButton)
//		        .addComponent(closeButton)
//		);
//		layout.linkSize(SwingConstants.HORIZONTAL, confirmar, desistir);
//		pack();
//		setTitle("Buttons");
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout.setHorizontalGroup(layout.createSequentialGroup()
        	    .addComponent(okButton)
        	    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
        	    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
        	);
        
//		add(imagem);
//		add(c_price);
//		add(jScrollPanel);
//		add(r1);
//		add(r2);
//		add(r3);
//		add(r4);
//		add(confirmar);
//		add(desistir);
		
//		layout.setHorizontalGroup(layout.createParallelGroup(1)
//			      .add(layout.createSequentialGroup()
//			        .addContainerGap()
//			        .add(layout.createParallelGroup(1)
//			          .add(layout.createSequentialGroup()
//			            .add(imageHolder, -2, 297, -2)
//			            .addPreferredGap(1)
//			            .add(layout.createParallelGroup(1)
//			              .add(jScrollPanel, -2, 274, -2)
//			              .add(levelHolder, -1, 274, 32767)))
//			          .add(layout.createSequentialGroup()
//			            .add(layout.createParallelGroup(2)
//			              .add(1, optionC, -1, 203, 32767)
//			              .add(1, layout.createSequentialGroup()
//			                .add(buttonPublico, -1, -1, 32767)
//			                .addPreferredGap(0)
//			                .add(buttonTelefone, -2, 100, -2))
//			              .add(1, optionA, -1, 203, 32767))
//			            .addPreferredGap(0)
//			            .add(layout.createParallelGroup(1)
//			              .add(button50, -2, 99, -2)
//			              .add(optionB, -2, 218, -2)
//			              .add(layout.createSequentialGroup()
//			                .add(optionD, -2, 218, -2)
//			                .addPreferredGap(0)
//			                .add(buttonDesistir, -1, -1, 32767)
//			                .addPreferredGap(0)
//			                .add(buttonConfirmar)))))
//			        .addContainerGap()));
		
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
					if (tmp==null) {
						break;
					}			
				imagem.setIcon(new ImageIcon(tmp.getimagem()));
				List<Integer> ordem = new ArrayList<Integer>();
				for (int i = 0; i < 4; i++) {
					ordem.add(i);
				}
				Collections.shuffle(ordem);
				String respostas[] = tmp.getanswers();
				r1.setText(respostas[ordem.get(0)]);
				r2.setText(respostas[ordem.get(1)]);
				r3.setText(respostas[ordem.get(2)]);
				r4.setText(respostas[ordem.get(3)]);
				quiz.addPergunta(tmp);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
		System.out.println("LOAD FILE COMPLETE");
	}
	
}
