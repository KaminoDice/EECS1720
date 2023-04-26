package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.CardConstants;

public class Game extends JPanel implements CardConstants {

	private Player[] players;
	private boolean isOver;
	private int GAMEMODE;

	private Pc pc;
	private Dealer dealer;
	private Stack<UNOCard> cardStack;
	UserInfo info=new UserInfo();
	
	public Game(int mode) {

		GAMEMODE = mode;
		if (GAMEMODE == VS_PC)
			pc = new Pc();

		Player player = null;
		player = new Player();
		player.toggleTurn(); 

		players = new Player[] { pc, player };

		// Create Dealer
		dealer = new Dealer();
		cardStack = dealer.shuffle();
		dealer.spreadOut(players);

		isOver = false;
	}

	public Player[] getPlayers() {
		return players;
	}

	public UNOCard getCard() {
		return dealer.getCard();
	}

	public void removePlayedCard(UNOCard playedCard) {

		for (Player p : players) {
			if (p.hasCard(playedCard)) {
				p.removeCard(playedCard);

				if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
					INFO_PANEL.setError(p.getName() + " Forgot to say UNO");
					p.obtainCard(getCard());
				} else if (p.getTotalCards() > 2) {
					p.setSaidUNOFalse();
				}
			}
		}
	}

	// give player a card
	public void drawCard(UNOCard topCard) {

		boolean canPlay = false;

		for (Player p : players) {
			if (p.isMyTurn()) {
				UNOCard newCard = getCard();
				p.obtainCard(newCard);
				canPlay = canPlay(topCard, newCard);
				break;
			}
		}

		if (!canPlay)
			switchTurn();
	}

	public void switchTurn() {
		for (Player p : players) {
			p.toggleTurn();
		}
		whoseTurn();
	}

	// Draw cards x times
	public void drawPlus(int times) {
		for (Player p : players) {
			if (!p.isMyTurn()) {
				for (int i = 1; i <= times; i++)
					p.obtainCard(getCard());
			}
		}
	}

	// response whose turn it is
	public void whoseTurn() {

		for (Player p : players) {
			if (p.isMyTurn()) {
				INFO_PANEL.updateText(p.getName() + "'s Turn");
			}
		}
		INFO_PANEL.setDetail(playedCardsSize(), remainingCards());
		INFO_PANEL.repaint();
	}

	// return if the game is over
	public boolean isOver() {

		if (cardStack.isEmpty()) {
			isOver=true;
			players[1].setScore(players[1].getScore() + 1);
			String s=players[1].getName()+" "+players[1].getPassword()+" "+players[1].getScore();
			UserInfo.method(s);
			return isOver;
		}

		for (int i = 0; i < 2; i++) {
			if (!players[i].hasCards() && i == 1) {
				isOver = true;
				players[i].setScore(players[i].getScore() + 1);
				String s=players[i].getName()+" "+players[i].getPassword()+" "+players[i].getScore();
				UserInfo.method(s);
				break;
			} else if (!players[i].hasCards()) {
				isOver = true;
				break;
			}
		}

		return isOver;
	}

	public int remainingCards() {
		return cardStack.size();
	}

	public int[] playedCardsSize() {
		int[] nr = new int[2];
		int i = 0;
		for (Player p : players) {
			nr[i] = p.totalPlayedCards();
			i++;
		}
		return nr;
	}

	// Check if this card can be played
	private boolean canPlay(UNOCard topCard, UNOCard newCard) {

		// Color or value matches
		if (topCard.getCardColor().equals(newCard.getCardColor()) || topCard.getValue().equals(newCard.getValue()))
			return true;
		// if chosen wild card color matches
		else if (topCard.getType() == WILD)
			return topCard.getWildColor().equals(newCard.getCardColor());

		// suppose the new card is a wild card
		else if (newCard.getType() == WILD)
			return true;

		// else
		return false;
	}

	// Check whether the player said or forgot to say UNO
	public void checkUNO() {
		for (Player p : players) {
			if (p.isMyTurn()) {
				if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
					INFO_PANEL.setError(p.getName() + " Forgot to say UNO");
					p.obtainCard(getCard());
					// p.obtainCard(getCard());
				}
			}
		}
	}

	public void setSaidUNO() {
		for (Player p : players) {
			if (p.isMyTurn()) {
				if (p.getTotalCards() == 2) {
					p.saysUNO();
					INFO_PANEL.setError(p.getName() + " said UNO");
				}
			}
		}
	}

	public boolean isPCsTurn() {
		if (pc.isMyTurn()) {
			return true;
		}
		return false;
	}

	// if it's PC's turn, play it for pc
	public void playPC(UNOCard topCard) {

		if (pc.isMyTurn()) {
			boolean done = pc.play(topCard);

			if (!done)
				drawCard(topCard);
		}
	}
}
	
