package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.CardConstants;
import view.InfoPanel;
import view.PcSetting;

public class GameModeListener implements ActionListener, CardConstants {
	
	private PcSetting mainPanel;
	private JudgeController server;
	private JFrame frame1 = new JFrame();
	private static final Color BLACK = null;
	private JFrame frame = new JFrame("1V1");
	private JButton startGame = new JButton("Start");
	private JButton exitGame = new JButton("Exit");
	private JLabel user1 = new JLabel("Player");
	private JLabel user2 = new JLabel("Enemy");
	private InfoPanel infoArea = new InfoPanel();
	private String gameState;
	private String enemyGameState;
	private Logger logger = Logger.getLogger("Game:");
	private PcSetting ps;
	public void vsPc(JFrame f) {
		server = new JudgeController();
		CARDLISTENER.setServer(server);
		BUTTONLISTENER.setServer(server);
		mainPanel = server.getSession();
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(50, 50);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.dispose();
	}
	

	private void init() {
		frame.setLayout(null);
        frame.setSize(1200, 700);
        frame.setLocation(100, 25);
		Font font = new Font("Serif", Font.BOLD, 25);
		Font font1 = new Font("Serif", Font.BOLD, 15);
		
		
		startGame.setFont(font);
		startGame.setBounds(900,200,220,30);
		startGame.setBorder(BorderFactory.createRaisedBevelBorder());
		exitGame.setFont(font);
		exitGame.setBounds(900,240,220,30);
		exitGame.setBorder(BorderFactory.createRaisedBevelBorder());
		infoArea.setBounds(900, 280, 220, 220);
		infoArea.setBackground(new Color(240,255,240));
		infoArea.setFont(font1);
		user1.setOpaque(true); 
		user1.setFont(font);
		user1.setBounds(900,530,220,30);
		user2.setOpaque(true); 
		user2.setFont(font);
		user2.setBounds(900,30,220,30);
		
		server = new JudgeController();
		CARDLISTENER.setServer(server);
		BUTTONLISTENER.setServer(server);
		ps = server.getSession();
		ps.setBounds(0, 0, 900, 700);
		

		frame.add(infoArea);
		frame.add(startGame);
		frame.add(exitGame);
		frame.add(user1);
		frame.add(user2);
		frame.add(ps);
		
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	

}
