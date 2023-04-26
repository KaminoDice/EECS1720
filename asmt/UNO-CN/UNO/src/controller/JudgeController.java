package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import interfaces.CardConstants;
import model.Game;
import model.Player;
import model.UNOCard;
import view.PcSetting;


public class JudgeController implements CardConstants {
	private Game game;
	private PcSetting session;
	private Stack<UNOCard> playedCards;
	public boolean canPlay;
	private int mode;

	public JudgeController() {

		mode = requestMode();
		game = new Game(mode);
		playedCards = new Stack<UNOCard>();


		UNOCard firstCard = game.getCard();
		modifyFirstCard(firstCard);

		playedCards.add(firstCard);
		session = new PcSetting(game, firstCard);
		game.whoseTurn();
		canPlay = true;
	}


	private int requestMode() {



		return GAMEMODES[0];
	}

	
	private void modifyFirstCard(UNOCard firstCard) {
		firstCard.removeMouseListener(CARDLISTENER);
		if (firstCard.getType() == WILD) {
			int random = new Random().nextInt() % 4;
			try {
				firstCard.useWildColor(UNOCOLORS[Math.abs(random)]);
			} catch (Exception ex) {
				System.out.println("something wrong with modifyFirstcard");
			}
		}
	}

	
	public PcSetting getSession() {
		return this.session;
	}


	public void playThisCard(UNOCard clickedCard) {

		
		if (!isHisTurn(clickedCard)) {
			INFO_PANEL.setError("It's not your turn");
			INFO_PANEL.repaint();
		} else {

			// Card validation
			if (isValidMove(clickedCard)) {

				clickedCard.removeMouseListener(CARDLISTENER);
				playedCards.add(clickedCard);
				game.removePlayedCard(clickedCard);

				// function cards
				switch (clickedCard.getType()) {
				case FUNCTION:
					performAction(clickedCard);
					break;
				case WILD:
					performWild(clickedCard);
					break;
				default:
					break;
				}

				game.switchTurn();
				session.updatePanel(clickedCard);
				checkResults();
			} else {
				INFO_PANEL.setError("invalid move");
				INFO_PANEL.repaint();
			}

		}

		if (mode == VS_PC && canPlay) {
			if (game.isPCsTurn()) {
				game.playPC(peekTopCard());
			}
		}
	}

	
	private void checkResults() {

		if (game.isOver()) {
			canPlay = false;
			INFO_PANEL.updateText("GAME OVER");
		}
	}


	public boolean isHisTurn(UNOCard clickedCard) {

		for (Player p : game.getPlayers()) {
			if (p.hasCard(clickedCard) && p.isMyTurn()) {
				return true;
			}
		}
		return false;
	}


	public boolean isValidMove(UNOCard playedCard) {
		UNOCard topCard = peekTopCard();

		if (playedCard.getCardColor().equals(topCard.getCardColor())
				|| playedCard.getValue().equals(topCard.getValue())) {
			return true;
		}

		else if (playedCard.getType() == WILD) {
			return true;
		} else if (topCard.getType() == WILD) {
			Color color = topCard.getWildColor();
			if (color.equals(playedCard.getCardColor())) {
				return true;
			}
		}
		return false;
	}


	private void performAction(UNOCard actionCard) {

	
		if (actionCard.getValue().equals(DRAW2PLUS)) {
			game.drawPlus(2);
		} else if (actionCard.getValue().equals(REVERSE)) {
			game.switchTurn();
		} else if (actionCard.getValue().equals(SKIP)) {
			game.switchTurn();
		}
	}

	private void performWild(UNOCard functionCard) {

	
		if (mode == 1 && game.isPCsTurn()) {
			int random = new Random().nextInt() % 4;
			functionCard.useWildColor(UNOCOLORS[Math.abs(random)]);
		} else {

			ArrayList<String> colors = new ArrayList<String>();
			colors.add("RED");
			colors.add("BLUE");
			colors.add("GREEN");
			colors.add("YELLOW");

			String chosenColor = (String) JOptionPane.showInputDialog(null, "Choose a color", "Wild Card Color",
					JOptionPane.DEFAULT_OPTION, null, colors.toArray(), null);

			functionCard.useWildColor(UNOCOLORS[colors.indexOf(chosenColor)]);
		}

		if (functionCard.getValue().equals(W_DRAW4PLUS)) {
			game.drawPlus(4);
		}
	}

	public void requestCard() {
		game.drawCard(peekTopCard());

		if (mode == VS_PC && canPlay) {
			if (game.isPCsTurn()) {
				game.playPC(peekTopCard());
			}
		}

		session.refreshPanel();
	}

	public UNOCard peekTopCard() {
		return playedCards.peek();
	}

	public void submitSaidUno() {
		game.setSaidUNO();
	}
}
