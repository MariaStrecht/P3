package aula08.ex2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import aula07.ex2.Bitmap;
import aula07.ex2.BitmapFileHeader;
import aula07.ex2.BitmapInfoHeader;
import aula07.ex2.BitmapUtils;

public class BMPView {
	JPanel im;
	JFrame f;
	JTextArea log;
	JButton openButton, saveButton , viewButton , flipButton , fliphButton , flipvButton , redimButton;
	private JFileChooser fc;
	String path;
	String b_tmp;
	Bitmap bitimage;
	JPanel j_tmp;
	boolean hasim ;
	private JButton saveasButton;
	
		
	public void main() {
		hasim = false;
		f = new JFrame("BMPViewer");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 600);
		f.setLayout(new BorderLayout());
		log = new JTextArea(5,20);
	    log.setMargin(new Insets(5,5,5,5));
	    log.setEditable(false);
	    log.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
	    JScrollPane logScrollPane = new JScrollPane(log);
	    
	    openButton = new JButton("Open"
                ,createImageIcon("Open16.gif"));
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				choosefile();
				try {
					inicialize_bitmap(path);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String tmp[] = path.split(".bmp");
//				for (String string : tmp) {
//					System.out.println(string);
//				}
				b_tmp = tmp[0]+"_tmp.bmp";
//				b_tmp ="";
//				System.out.println(path);
//				String[] partes = path.split("/");
//				for (int i = 0; i < partes.length-1; i++) {
//					b_tmp += "/" + partes[i];
//				}
//				b_tmp += "/.temp.bmp"; 
//				System.out.println(b_tmp);
//				b_tmp = "/home/maria/Figura_tmp.bmp";
				try (RandomAccessFile temp = new RandomAccessFile(b_tmp, "rw")){
					BitmapUtils.copy(temp);
					System.out.println("COPIA CRIADA");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("ERRO AO CRIAR COPIA");
					e1.printStackTrace();
				}
				showim();
			
				//System.out.println(Bitmap.bitmapFileHeader);
				//System.out.println(Bitmap.bitmapInfoHeader);
//				System.out.println("---- TOTAL FLIPPED VERSION ----");
//			    try (RandomAccessFile tfv = new RandomAccessFile("/home/maria/Documents/P_III/p3/src/aula08/ex2/Figura_tflipped.bmp", "rw")) {
//					BitmapUtils.totalflip(tfv);
//					System.out.println("IMAGEM FLIPPED CRIADA (Figura_tflipped.bmp)");
//				} catch (Exception e) {
//					System.out.println("|ERRO| -> ao criar figura invertida");
//					e.printStackTrace();
//				}
			}
			});
							
															    //Create the save button.  We use the image from the JLF
															    //Graphics Repository (but we extracted it from the jar).
		saveButton = new JButton("Save"
		               ,createImageIcon("Save16.gif"));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try (RandomAccessFile temp = new RandomAccessFile(path, "rw")){
					BitmapUtils.copy(temp);
					System.out.println("COPIA CRIADA");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("ERRO AO CRIAR COPIA");
					e1.printStackTrace();
				}
				log.append("Saved Image.\n");
			}
			});
		saveasButton = new JButton("Save as"
	               ,createImageIcon("Save16.gif"));
		saveasButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				log.append("Selecting directory.\n");
				JFileChooser newfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				newfc.setDialogType(JFileChooser.SAVE_DIALOG);
				final int fd = newfc.showDialog(null, "Choose folder");
				String new_p ="";
			    if (fd == JFileChooser.APPROVE_OPTION) {
			    	new_p= newfc.getSelectedFile() + ".bmp";
			    } else {
			    	JOptionPane.showMessageDialog(null,"Invalid path.");
			    	log.append("ERROR - Invalid path.\n");
			    }			    
				try (RandomAccessFile newf = new RandomAccessFile(new_p, "rw")){
					BitmapUtils.copy(newf);
					System.out.println("COPIA CRIADA");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("ERRO AO CRIAR COPIA");
					e1.printStackTrace();
				}
				log.append("Saved Image in"+new_p+".\n");
			}
			
		});
		
		
		
		//PANEL COM OPEN E SAVE													//For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel(); 								//use FlowLayout
		buttonPanel.setBackground(new Color(51,153,255));
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(saveasButton);
		f.add(logScrollPane, BorderLayout.WEST);
		f.add(buttonPanel, BorderLayout.PAGE_START);
		
		//PANEL COM BOTOES DE ACOES
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout(1,5));
		
		
		viewButton= new JButton("View Original");
		flipButton = new JButton("Fip Image");
		fliphButton = new JButton("Horizontal Flip Image");
		flipvButton = new JButton("Vertical Flip Image");
		redimButton = new JButton("Reduce Image");
		
		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showim();
			}
			});
		flipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try (RandomAccessFile tf = new RandomAccessFile(b_tmp, "rw")){
					inicialize_bitmap(path);
					BitmapUtils.totalflip(tf);
					if (hasim) {
						f.remove(j_tmp);
					}
					j_tmp = imagepanel(b_tmp);
					f.remove(im);
					
					f.add(j_tmp, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(f);
					log.append("Image Flipped.\n");
					hasim = true;
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			});
		fliphButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try (RandomAccessFile tf = new RandomAccessFile(b_tmp, "rw")){
					inicialize_bitmap(path);
					BitmapUtils.hflip(tf);
					if (hasim) {
						f.remove(j_tmp);
					}
					j_tmp = imagepanel(b_tmp);
					f.remove(im);
					
					f.add(j_tmp, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(f);
					log.append("Image Flipped Horizontally.\n");
					hasim = true;
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			});
		flipvButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try (RandomAccessFile tf = new RandomAccessFile(b_tmp, "rw")){
					inicialize_bitmap(path);
					BitmapUtils.vflip(tf);
					if (hasim) {
						f.remove(j_tmp);
					}
					j_tmp = imagepanel(b_tmp);
					f.remove(im);
					
					f.add(j_tmp, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(f);
					log.append("Image Flipped Vertically.\n");
					hasim = true;
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			});
		redimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try (RandomAccessFile tf = new RandomAccessFile(b_tmp, "rw")){
					inicialize_bitmap(path);
					BitmapUtils.reduce(tf);
					if (hasim) {
						f.remove(j_tmp);
					}
					j_tmp = imagepanel(b_tmp);
					f.remove(im);
					f.add(j_tmp, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(f);
					log.append("Image Reduced.\n");
					hasim = true;
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			});
		
		botoes.add(viewButton);
		botoes.add(flipButton);
		botoes.add(fliphButton);
		botoes.add(flipvButton);
		botoes.add(redimButton);
		f.add(botoes, BorderLayout.SOUTH); 
		
	    
		f.setVisible(true);
	}
	
	public void choosefile() {
		//Create a file chooser
	    File fileRoot = new File(System.getProperty("user.home"));
	    fc = new JFileChooser(fileRoot);
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP Images", "bmp");
		fc.setFileFilter(filter);
	    int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            path = file.getAbsolutePath();
            //This is where a real application would open the file.
            log.append("Opening: " + file.getName() + ".\n");    
            
        } else {
            log.append("Open command cancelled by user.\n");
        }
	}
	public JPanel imagepanel(String p) {
		try {
			inicialize_bitmap(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel t = new PanelImage(Bitmap.data, Bitmap.bitmapInfoHeader.width, Bitmap.bitmapInfoHeader.height);
		return t;
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = BMPViewer.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public void inicialize_bitmap(String path) throws IOException {
		try(RandomAccessFile imfile = new RandomAccessFile(path, "r")) {
			Bitmap.bitmapFileHeader = new BitmapFileHeader(imfile);
			Bitmap.bitmapInfoHeader = new BitmapInfoHeader(imfile);
			// ler imagem
		    byte[] pixelData = new byte[((Bitmap.bitmapInfoHeader.width+3)*Bitmap.bitmapInfoHeader.height)*3]; 
		    int size = 0;
		    try {
		    		size = imfile.read(pixelData);
	    		}
			catch (EOFException ex) {
		    		System.out.println("Figura.bmp foi lido com sucesso.");
		    } 
			finally {
				Bitmap.data = new byte[size];
				System.arraycopy(pixelData, 0, Bitmap.data, 0, size);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
        
	}
    public void showim() {
    	JPanel tmp = imagepanel(path);
		if (hasim) {
			f.remove(j_tmp);
		}
		im = tmp;
		f.add(im, BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(f);
		log.append("Showing Image.\n");
    }
	
}
