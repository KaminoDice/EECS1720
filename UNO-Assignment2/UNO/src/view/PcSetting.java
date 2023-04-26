package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import interfaces.CardConstants;
import model.Game;
import model.UNOCard;


public class PcSetting extends JPanel implements CardConstants{
	private PcPanel player1;
	private PcPanel player2;
	private TablePanel table;	
	
	private Game game;
	
	public PcSetting(Game newGame, UNOCard firstCard){
		//setLocation(0, 0);
		setPreferredSize(new Dimension(1000,750));
		setBackground(RED);
		setLayout(new BorderLayout());
		
		game = newGame;
		
		setPlayers();
		table = new TablePanel(firstCard);
		player1.setOpaque(false);
		player2.setOpaque(false);
	//	table.setBackgroundColor();
		add(player1,BorderLayout.NORTH);
		add(table, BorderLayout.CENTER);
		add(player2, BorderLayout.SOUTH);		
	}
	
	private void setPlayers() {
		player1 = new PcPanel(game.getPlayers()[0]);
		player2 = new PcPanel(game.getPlayers()[1]);		
	}
	
	public void refreshPanel(){
		player1.setCards();
		player2.setCards();
		
		table.revalidate();		
		revalidate();
	}
	
	public void updatePanel(UNOCard playedCard){
		table.setPlayedCard(playedCard);
		this.setBackgroundColor(playedCard);
		refreshPanel();
	}	
	
	private void setBackgroundColor(UNOCard playedCard) {
		Color background;
		if(playedCard.getType()==WILD)
			background = playedCard.getWildColor();
		else
			background = playedCard.getCardColor();
		
		table.setBackground(background);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
