package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import interfaces.CardConstants;

public class Dealer implements CardConstants {
	
//	private CardDeck cardDeck;
	private CardCollect card=new CardCollect();
	private Stack<UNOCard> CardStack;	
	
	
	
	//Shuffle cards
	public Stack<UNOCard> shuffle(){
		
		ArrayList<UNOCard> DeckOfCards = card.getUnoCards();
		ArrayList<UNOCard> shuffledCards = new ArrayList<UNOCard>();
		
		while(!DeckOfCards.isEmpty()){
			int totalCards = DeckOfCards.size();
			System.out.println(totalCards);
			Random random = new Random();
			int pos = (Math.abs(random.nextInt()))% totalCards;
			
			UNOCard randomCard = DeckOfCards.get(pos);
			DeckOfCards.remove(pos);
			shuffledCards.add(randomCard);
		}
		
		CardStack = new Stack<UNOCard>();
		for(UNOCard card : shuffledCards){
			CardStack.add(card);
		}
		
		return CardStack;
	}
	
	//Spread cards to players -- 7 each
	public void spreadOut(Player[] players){		
		
		for(int i=1;i<=FIRDTHSND;i++){
			for(Player p : players){
				p.obtainCard(CardStack.pop());
			}
		}		
	}
	
	public UNOCard getCard(){
		return CardStack.pop();
	}
}