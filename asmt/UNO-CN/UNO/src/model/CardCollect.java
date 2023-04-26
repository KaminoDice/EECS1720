package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import controller.MyCardListener;
import interfaces.CardConstants;

public class CardCollect implements CardConstants{
	
	private ArrayList<UNOCard> unoCards;
	
	public CardCollect(){
		unoCards = new ArrayList<UNOCard>();
		
		addCard();
		addCardListener(CARDLISTENER);
		//System.out.println(unoCards.get(2).getCardColor()+" "+unoCards.get(2).getType()+" "+unoCards.get(2).getValue());
	}
	
	public ArrayList<UNOCard> getUnoCards() {
		return unoCards;
	}
	
	

	//Create 108 cards for this CardCollect
	private void addCard() {
		
		for(Color color :UNOCOLORS) {
			//Create 76 NumberCards
			for(int num:UNONUMBERS) {
				if(num==0)
				{
					unoCards.add(new UNOCard(color,Integer.toString(num),NUMBER));
				}
				else
				{
					for(int i=0;i<2;i++)
						unoCards.add(new UNOCard(color,Integer.toString(num),NUMBER));
				}
				
			}
			//Create 24 FunctionCards
			for(String type: FUNCTIONTYPES) {
				for(int i=0;i<2;i++)
					unoCards.add(new UNOCard(color,type,FUNCTION));
			}
		}
		
		//Create 8 wildCards
		for(String type : WILDTYPES) {
			for(int i=0;i<4;i++)
				unoCards.add(new UNOCard(WILDCARDCOLOR,type,WILD));
		}
	}
	//Cards have MouseListener
			public void addCardListener(MyCardListener listener){
				for(UNOCard card: unoCards)
				card.addMouseListener(listener);
			}
			
			public ArrayList<UNOCard> getCards(){
				return unoCards;
			}

			
}
