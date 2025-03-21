package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import interfaces.CardConstants;
import model.Player;
import model.UNOCard;


public class PcPanel extends JPanel implements CardConstants{
	
	private Player player;
	private String name;

	private Box myLayout;
	private JLayeredPane cardHolder;
	private Box controlPanel;

	private JButton draw;
	private JButton sayUNO;
	private JLabel nameLbl;
	private MyButtonHandler handler;

	// Constructor
	public PcPanel(Player newPlayer) {
		setPlayer(newPlayer);

		myLayout = Box.createHorizontalBox();
		cardHolder = new JLayeredPane();
		cardHolder.setPreferredSize(new Dimension(650, 200));

		// Set
		setCards();
		setControlPanel();

		myLayout.add(cardHolder);
		myLayout.add(Box.createHorizontalStrut(0));
		myLayout.add(controlPanel);
		add(myLayout);

		// Register Listeners
		handler = new MyButtonHandler();
		draw.addActionListener(BUTTONLISTENER);
		draw.addActionListener(handler);
		
		sayUNO.addActionListener(BUTTONLISTENER);
		sayUNO.addActionListener(handler);
	}

	public void setCards() {
		cardHolder.removeAll();

		// Origin point at the center
		Point origin = getPoint(cardHolder.getWidth(), player.getTotalCards());
		int offset = calculateOffset(cardHolder.getWidth(),player.getTotalCards());

		int i = 0;
		for (UNOCard card : player.getAllCards()) {
			card.setBounds(origin.x, origin.y, card.CARDSIZE.width,card.CARDSIZE.height);
			cardHolder.add(card, i++);
			cardHolder.moveToFront(card);
			origin.x += offset;
		}
		repaint();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
		setPlayerName(player.getName());
	}

	public void setPlayerName(String playername) {
		this.name = playername;
	}

	private void setControlPanel() {
		draw = new JButton("Draw");
		sayUNO = new JButton("Say UNO");
		nameLbl = new JLabel(name);

		// style
		draw.setBackground(new Color(79, 129, 189));
		draw.setFont(new Font("Arial", Font.BOLD, 20));
		draw.setFocusable(false);

		sayUNO.setBackground(new Color(149, 55, 53));
		sayUNO.setFont(new Font("Arial", Font.BOLD, 20));
		sayUNO.setFocusable(false);

		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("Arial", Font.BOLD, 15));

		controlPanel = Box.createVerticalBox();
		controlPanel.add(nameLbl);
		controlPanel.add(draw);
		controlPanel.add(Box.createVerticalStrut(15));
		controlPanel.add(sayUNO);
	}


	private int calculateOffset(int width, int totalCards) {
		int offset = 81;
		if (totalCards <= 7) {
			return offset;
		} else {
			double o = (width - 50) / (totalCards - 1);
			return (int) o;
		}
	}

	private Point getPoint(int width, int totalCards) {
		Point p = new Point(0, 20);
		if (totalCards >= 7) {
			return p;
		} else {
			p.x = (width - calculateOffset(width, totalCards) * totalCards) / 2;
			return p;
		}
	}
	
	class MyButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(player.isMyTurn()){
				
				if(e.getSource()==draw)
					BUTTONLISTENER.drawCard();
				else if(e.getSource()==sayUNO)
					BUTTONLISTENER.sayUno();
			}
		}
	}
}
