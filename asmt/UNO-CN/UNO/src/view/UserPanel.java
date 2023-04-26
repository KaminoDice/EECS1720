package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interfaces.CardConstants;
import model.UNOCard;
import music.MusicPlayer;
import view.UserPanel.MyButton;

public class UserPanel extends JFrame implements CardConstants {
//	static UserPanel uno = new UserPanel();
	static UNOCard card1 = new UNOCard(YELLOW, "U");
	static UNOCard card2 = new UNOCard(RED, "N");
	static UNOCard card3 = new UNOCard(BLUE, "O");
	JFrame f = new JFrame("Login");
	JLabel label1 = new JLabel("Nickname: ");
	JLabel label2 = new JLabel("Password: ");
	JButton btlogin = new JButton("Login");
	JButton btenroll = new JButton("Sign up");
	JTextField text1 = new JTextField();
	JPasswordField text2 = new JPasswordField();
	Font font = new Font("Helvetica", Font.BOLD, 46);
	private MyButton handler;

	public UserPanel() {
//		MusicPlayer.musicplay();

		f.setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(1, 1));

		panel.add(card1);
		panel.add(card2);
		panel.add(card3);
		f.add(panel, BorderLayout.NORTH);

		
		JPanel panel1 = new JPanel(new GridLayout(2, 2));
		label1.setFont(font);
		label2.setFont(font);
		text1.setFont(font);
		text2.setFont(font);

		panel1.add(label1);
		panel1.add(text1);
		panel1.add(label2);
		panel1.add(text2);

		text1.setOpaque(false);
		text2.setOpaque(false);

		panel1.setBackground(null); 
		panel1.setOpaque(true); 
		f.add(panel1, BorderLayout.CENTER);

		
		JPanel panel2 = new JPanel(new GridLayout(1, 1));

		btlogin.setFont(font);
		btenroll.setFont(font);
		panel2.add(btlogin);
		panel2.add(btenroll);

		handler = new MyButton();
		btlogin.addActionListener(USERLISTRNER);
		btlogin.addActionListener(handler);

		btenroll.addActionListener(USERLISTRNER);
		btenroll.addActionListener(handler);

		panel2.setSize(200, 200);
		panel1.setOpaque(false);
		f.add(panel2, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setBounds(300, 300, 400, 400);
		f.setResizable(false);
		f.setLocation(550, 250);
		f.setVisible(true);
	}

	class MyButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// System.out.println(e.getSource());
			if (e.getSource() == btenroll)
				USERLISTRNER.enroll();
			else if (e.getSource() == btlogin)
				USERLISTRNER.login(text1,text2,f);
		}
	}

}
