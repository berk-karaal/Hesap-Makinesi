import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hesap_Makinesi {

	private JFrame frmHesapMakinesi;
	private final JLabel xDis = new JLabel("");
	private final JLabel yDis = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hesap_Makinesi window = new Hesap_Makinesi();
					window.frmHesapMakinesi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public static String deleteLastChar(String str) {	
		return str.substring(0,str.length()-1);
	}
	
	public Hesap_Makinesi() {
		initialize();
	}

	
	private void initialize() {
		frmHesapMakinesi = new JFrame();
		frmHesapMakinesi.setUndecorated(true);
		frmHesapMakinesi.getContentPane().setForeground(Color.GRAY);
		frmHesapMakinesi.setForeground(Color.BLACK);
		frmHesapMakinesi.setBackground(Color.LIGHT_GRAY);
		frmHesapMakinesi.setFont(new Font("Open Sans", Font.PLAIN, 12));
		frmHesapMakinesi.setIconImage(Toolkit.getDefaultToolkit().getImage(Hesap_Makinesi.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		frmHesapMakinesi.setTitle("Hesap Makinesi");
		frmHesapMakinesi.setResizable(false);
		frmHesapMakinesi.getContentPane().setBackground(SystemColor.activeCaption);
		frmHesapMakinesi.setBounds(100, 100, 285, 459);
		frmHesapMakinesi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHesapMakinesi.getContentPane().setLayout(null);
		frmHesapMakinesi.setFocusable(false);
		
		JPanel TitleBar = new JPanel();
		TitleBar.setBounds(0, 0, 285, 25);
		frmHesapMakinesi.getContentPane().add(TitleBar);
		TitleBar.setLayout(null);
		
		JLabel kapa_lbl = new JLabel("");
		kapa_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmHesapMakinesi.dispose();
			}
		});
		yDis.setBounds(0, 0, 0, 0);
		TitleBar.add(yDis);
		xDis.setBounds(0, 0, 0, 0);
		TitleBar.add(xDis);
		kapa_lbl.setIcon(new ImageIcon(Hesap_Makinesi.class.getResource("/image/Close.png")));
		kapa_lbl.setBounds(260, 0, 25, 25);
		kapa_lbl.setFocusable(false);
		TitleBar.add(kapa_lbl);
		
		JLabel Bar_lbl = new JLabel("");
		Bar_lbl.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frmHesapMakinesi.setLocation(e.getXOnScreen()-Integer.parseInt(xDis.getText()),e.getYOnScreen()-Integer.parseInt(yDis.getText()));
			}
		});
		Bar_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xDis.setText(""+(e.getXOnScreen() - frmHesapMakinesi.getX()));
				yDis.setText(""+(e.getYOnScreen() - frmHesapMakinesi.getY()));
			}
		});
		
		JLabel lblHesapMakinesi = new JLabel(" Hesap Makinesi");
		lblHesapMakinesi.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblHesapMakinesi.setBounds(0, 0, 155, 25);
		TitleBar.add(lblHesapMakinesi);
		Bar_lbl.setIcon(new ImageIcon(Hesap_Makinesi.class.getResource("/image/title.png")));
		Bar_lbl.setBounds(0, 0, 290, 25);
		Bar_lbl.setFocusable(false);
		TitleBar.add(Bar_lbl);
		
		JLabel lbl_ust = new JLabel("");
		lbl_ust.setForeground(SystemColor.windowBorder);
		lbl_ust.setOpaque(true);
		lbl_ust.setBackground(SystemColor.activeCaption);
		lbl_ust.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_ust.setBounds(10, 37, 256, 16);
		lbl_ust.setFocusable(false);
		frmHesapMakinesi.getContentPane().add(lbl_ust);
		
		JLabel lbl_alt = new JLabel("");
		lbl_alt.setForeground(SystemColor.desktop);
		lbl_alt.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_alt.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_alt.setFont(new Font("Open Sans", Font.BOLD, 25));
		lbl_alt.setBounds(10, 65, 256, 37);
		lbl_alt.setFocusable(false);
		frmHesapMakinesi.getContentPane().add(lbl_alt);
		
		JButton btnGeriAl = new JButton("C");
		btnGeriAl.setBorderPainted(false);
		btnGeriAl.setFocusable(false);
		btnGeriAl.setBackground(new Color(255, 153, 0));
		btnGeriAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText() != "") {
					lbl_alt.setText(deleteLastChar(lbl_alt.getText()));
				}
			}
		});
		btnGeriAl.setFont(new Font("Open Sans", Font.BOLD, 29));
		btnGeriAl.setBounds(10, 113, 65, 65);
		frmHesapMakinesi.getContentPane().add(btnGeriAl);
		
		JButton btnAc = new JButton("AC");
		btnAc.setBorderPainted(false);
		btnAc.setFocusable(false);
		btnAc.setBackground(new Color(255, 0, 102));
		btnAc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbl_alt.setText("");
				lbl_ust.setText("");
			}
		});
		btnAc.setFont(new Font("Open Sans", Font.BOLD, 20));
		btnAc.setBounds(77, 113, 65, 65);
		frmHesapMakinesi.getContentPane().add(btnAc);
		
		JButton button_kok = new JButton("\u221A");
		button_kok.setForeground(new Color(220, 220, 220));
		button_kok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_kok.setBackground(new Color(51, 102, 102));
		button_kok.setBorderPainted(false);
		button_kok.setFocusable(false);
		button_kok.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbl_alt.setText(""+Math.sqrt(Double.parseDouble(lbl_alt.getText())));
			}
		});
		button_kok.setFont(new Font("Open Sans", Font.BOLD, 35));
		button_kok.setBounds(144, 113, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_kok);
		
		JButton button_Arti = new JButton("+");
		button_Arti.setForeground(new Color(220, 220, 220));
		button_Arti.setBackground(new Color(51, 102, 102));
		button_Arti.setBorderPainted(false);
		button_Arti.setFocusable(false);
		button_Arti.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText() != ""  && lbl_alt.getText() != "-") {
				if(lbl_ust.getText() == "") {
					lbl_ust.setText(""+Double.parseDouble(lbl_alt.getText())+" +");
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '+'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))+Double.parseDouble(lbl_alt.getText())+" +"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '-'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))-Double.parseDouble(lbl_alt.getText())+" +"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '/'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))/Double.parseDouble(lbl_alt.getText())+" +"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == 'x'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))*Double.parseDouble(lbl_alt.getText())+" +"));
					lbl_alt.setText("");
				}
				}
			}
		});
		button_Arti.setFont(new Font("Open Sans", Font.BOLD, 45));
		button_Arti.setBounds(211, 113, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_Arti);
		
		JButton button_7 = new JButton("7");
		button_7.setBackground(new Color(51, 204, 204));
		button_7.setBorderPainted(false);
		button_7.setFocusable(false);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "7");
				
			}
		});
		button_7.setForeground(SystemColor.desktop);
		button_7.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_7.setBounds(10, 180, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setBackground(new Color(51, 204, 204));
		button_8.setBorderPainted(false);
		button_8.setFocusable(false);
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "8");
			}
		});
		button_8.setForeground(SystemColor.desktop);
		button_8.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_8.setBounds(77, 180, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setBackground(new Color(51, 204, 204));
		button_9.setBorderPainted(false);
		button_9.setFocusable(false);
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "9");
			}
		});
		button_9.setForeground(SystemColor.desktop);
		button_9.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_9.setBounds(144, 180, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_9);
		
		JButton button_Eksi = new JButton("-");
		button_Eksi.setForeground(new Color(220, 220, 220));
		button_Eksi.setBackground(new Color(51, 102, 102));
		button_Eksi.setBorderPainted(false);
		button_Eksi.setFocusable(false);
		button_Eksi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText() != "-") {
					if(lbl_alt.getText()=="") {
						lbl_alt.setText("-");
					}
					else if(lbl_ust.getText() == "") {
						lbl_ust.setText(""+Double.parseDouble(lbl_alt.getText())+" -");
						lbl_alt.setText("");
					}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '+'){
						lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))+Double.parseDouble(lbl_alt.getText())+" -"));
						lbl_alt.setText("");
					}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '-'){
						lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))-Double.parseDouble(lbl_alt.getText())+" -"));
						lbl_alt.setText("");
					}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '/'){
						lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))/Double.parseDouble(lbl_alt.getText())+" -"));
						lbl_alt.setText("");
					}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == 'x'){
						lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))*Double.parseDouble(lbl_alt.getText())+" -"));
						lbl_alt.setText("");
					}
				}
			}
		});
		button_Eksi.setFont(new Font("Open Sans", Font.BOLD, 30));
		button_Eksi.setBounds(211, 180, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_Eksi);
		
		JButton button_4 = new JButton("4");
		button_4.setBackground(new Color(51, 204, 204));
		button_4.setBorderPainted(false);
		button_4.setFocusable(false);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "4");
			}
		});
		button_4.setForeground(SystemColor.desktop);
		button_4.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_4.setBounds(10, 247, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setBackground(new Color(51, 204, 204));
		button_5.setBorderPainted(false);
		button_5.setFocusable(false);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "5");
			}
		});
		button_5.setForeground(SystemColor.desktop);
		button_5.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_5.setBounds(77, 247, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setBackground(new Color(51, 204, 204));
		button_6.setBorderPainted(false);
		button_6.setFocusable(false);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "6");
			}
		});
		button_6.setForeground(SystemColor.desktop);
		button_6.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_6.setBounds(144, 247, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_6);
		
		JButton btn_X = new JButton("X");
		btn_X.setForeground(new Color(220, 220, 220));
		btn_X.setBackground(new Color(51, 102, 102));
		btn_X.setBorderPainted(false);
		btn_X.setFocusable(false);
		btn_X.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText() != ""  && lbl_alt.getText() != "-") {
				if(lbl_ust.getText() == "") {
					lbl_ust.setText(""+Double.parseDouble(lbl_alt.getText())+" x");
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '+'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))+Double.parseDouble(lbl_alt.getText())+" x"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '-'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))-Double.parseDouble(lbl_alt.getText())+" x"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '/'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))/Double.parseDouble(lbl_alt.getText())+" x"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == 'x'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))*Double.parseDouble(lbl_alt.getText())+" x"));
					lbl_alt.setText("");
				}
			}
			}
		});
		btn_X.setFont(new Font("Open Sans", Font.BOLD, 35));
		btn_X.setBounds(211, 247, 65, 65);
		frmHesapMakinesi.getContentPane().add(btn_X);
		
		JButton button_1 = new JButton("1");
		button_1.setBackground(new Color(51, 204, 204));
		button_1.setBorderPainted(false);
		button_1.setFocusable(false);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(lbl_alt.getText().length()<18)	
					lbl_alt.setText(lbl_alt.getText() + "1");
			}
		});
		button_1.setForeground(SystemColor.desktop);
		button_1.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_1.setBounds(10, 314, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setBackground(new Color(51, 204, 204));
		button_2.setBorderPainted(false);
		button_2.setFocusable(false);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "2");
			}
		});
		button_2.setForeground(SystemColor.desktop);
		button_2.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_2.setBounds(77, 314, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setBackground(new Color(51, 204, 204));
		button_3.setBorderPainted(false);
		button_3.setFocusable(false);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "3");
			}
		});
		button_3.setForeground(SystemColor.desktop);
		button_3.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_3.setBounds(144, 314, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_3);
		
		JButton button_bolme = new JButton("/");
		button_bolme.setForeground(new Color(220, 220, 220));
		button_bolme.setBackground(new Color(51, 102, 102));
		button_bolme.setBorderPainted(false);
		button_bolme.setFocusable(false);
		button_bolme.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText() != ""  && lbl_alt.getText() != "-") {
				if(lbl_ust.getText() == "") {
					lbl_ust.setText(""+Double.parseDouble(lbl_alt.getText())+" /");
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '+'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))+Double.parseDouble(lbl_alt.getText())+" /"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '-'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))-Double.parseDouble(lbl_alt.getText())+" /"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == '/'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))/Double.parseDouble(lbl_alt.getText())+" /"));
					lbl_alt.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1) == 'x'){
					lbl_ust.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))*Double.parseDouble(lbl_alt.getText())+" /"));
					lbl_alt.setText("");
				}
				}
			}
		});
		button_bolme.setFont(new Font("Open Sans", Font.BOLD, 35));
		button_bolme.setBounds(211, 314, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_bolme);
		
		JButton button_00 = new JButton("00");
		button_00.setBackground(new Color(51, 204, 204));
		button_00.setBorderPainted(false);
		button_00.setFocusable(false);
		button_00.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<17)
					lbl_alt.setText(lbl_alt.getText() + "00");
			}
		});
		button_00.setForeground(SystemColor.desktop);
		button_00.setFont(new Font("Open Sans", Font.PLAIN, 15));
		button_00.setBounds(10, 381, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_00);
		
		JButton button_0 = new JButton("0");
		button_0.setBackground(new Color(51, 204, 204));
		button_0.setBorderPainted(false);
		button_0.setFocusable(false);
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + "0");
			}
		});
		button_0.setForeground(SystemColor.desktop);
		button_0.setFont(new Font("Open Sans", Font.PLAIN, 25));
		button_0.setBounds(144, 381, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_0);
		
		JButton button_nokta = new JButton(".");
		button_nokta.setBackground(new Color(51, 204, 204));
		button_nokta.setBorderPainted(false);
		button_nokta.setFocusable(false);
		button_nokta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(lbl_alt.getText().length()<18)
					lbl_alt.setText(lbl_alt.getText() + ".");
			}
		});
		button_nokta.setFont(new Font("Open Sans", Font.PLAIN, 30));
		button_nokta.setBounds(77, 381, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_nokta);
		
		JButton button_sonuc = new JButton("=");
		button_sonuc.setBorderPainted(false);
		button_sonuc.setFocusable(false);
		button_sonuc.setBackground(new Color(0, 204, 0));
		button_sonuc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				
				if(lbl_alt.getText() == "") {
					lbl_alt.setText(deleteLastChar(deleteLastChar(lbl_ust.getText())));
					lbl_ust.setText("");
				}
				else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1)=='+') {
					lbl_alt.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))+Double.parseDouble(lbl_alt.getText())));
					lbl_ust.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1)=='-') {
					lbl_alt.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))-Double.parseDouble(lbl_alt.getText())));
					lbl_ust.setText("");
				}
				else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1)=='/') {
					lbl_alt.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))/Double.parseDouble(lbl_alt.getText())));
					lbl_ust.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1)=='x') {
					lbl_alt.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))*Double.parseDouble(lbl_alt.getText())));
					lbl_ust.setText("");
				}else if(lbl_ust.getText().charAt(lbl_ust.getText().length()-1)=='-') {
					lbl_alt.setText(""+(Double.parseDouble(deleteLastChar(deleteLastChar(lbl_ust.getText())))-Double.parseDouble(lbl_alt.getText())));
					lbl_ust.setText("");
				}
			}
		});
		button_sonuc.setFont(new Font("Open Sans", Font.BOLD, 30));
		button_sonuc.setBounds(211, 381, 65, 65);
		frmHesapMakinesi.getContentPane().add(button_sonuc);
		
		
	}
}
