package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.CardConstants;
import music.MusicPlayer;


public class UserMenu extends JFrame implements CardConstants {
	public JFrame frame = new JFrame("Game View");
	private JButton btn1 = new JButton("Start");
	private JButton btn2 = new JButton("Help");
	private JButton btn3 = new JButton("Rank");
	private JButton btn4 = new JButton("BGM");
	private MyButton2 handler;

	public UserMenu() {
		frame.setLayout(null);
		frame.setSize(900, 700);
		frame.setLocation(250, 25);

		Font font = new Font("Helvetica", Font.BOLD, 20);

		btn1.setContentAreaFilled(false);
		btn1.setFont(font);
		btn1.setForeground(Color.yellow);
		btn1.setBorder(BorderFactory.createRaisedBevelBorder());

		btn2.setContentAreaFilled(false);
		btn2.setFont(font);
		btn2.setBorder(BorderFactory.createRaisedBevelBorder());
		btn2.setForeground(Color.yellow);

		btn3.setContentAreaFilled(false);
		btn3.setFont(font);
		btn3.setBorder(BorderFactory.createRaisedBevelBorder());
		btn3.setForeground(Color.yellow);
		
		btn4.setContentAreaFilled(false);
		btn4.setFont(font);
		btn4.setBorder(BorderFactory.createRaisedBevelBorder());
		btn4.setForeground(Color.BLACK);

		JPanel bj = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image bg;
				try {
					bg = ImageIO.read(new File("web/img/timg.jpg"));
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		btn1.setBounds(590, 600, 80, 30);
		btn2.setBounds(680, 600, 80, 30);
		btn3.setBounds(770, 600, 80, 30);
		btn4.setBounds(700, 20, 120, 30);

		frame.setContentPane(bj);
		frame.setLayout(null);

		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);

		handler = new MyButton2();
		btn1.addActionListener(MENULISTRNER);
		btn1.addActionListener(handler);
		btn2.addActionListener(MENULISTRNER);
		btn2.addActionListener(handler);
		btn3.addActionListener(MENULISTRNER);
		btn3.addActionListener(handler);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MusicPlayer aau = new MusicPlayer();
				aau.run();
			}
		});
		
		btn1.setFocusable(false);
		btn2.setFocusable(false);
		btn3.setFocusable(false);
		btn4.setFocusable(false);
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class MyButton2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1)
				MENULISTRNER.begin(frame);
			else if (e.getSource() == btn2)
				MENULISTRNER.rule();
			else if (e.getSource() == btn3)
				MENULISTRNER.range();

		}
	}

}
