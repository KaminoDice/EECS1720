package model;

import java.awt.Color;
import java.awt.event.MouseEvent;

import interfaces.CardConstants;

public class Pc extends Player implements CardConstants {

	public Pc() {
		setName("PC");
		super.setCards();
	}

	public Pc(Player player) {
	}
	
	//PC plays a card
	public boolean play(UNOCard topCard) {

		boolean done = false;

		Color color = topCard.getCardColor();
		String value = topCard.getValue();
		
		if(topCard.getType()==WILD){
			color = topCard.getWildColor();			
		}

		for (UNOCard card : getAllCards()) {

			if (card.getCardColor().equals(color) || card.getValue().equals(value)) {
				
				MouseEvent doPress = new MouseEvent(card, MouseEvent.MOUSE_PRESSED,
						System.currentTimeMillis(),
						(int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);				
				card.dispatchEvent(doPress);
				
				MouseEvent doRelease = new MouseEvent(card, MouseEvent.MOUSE_RELEASED,
						System.currentTimeMillis(),
						(int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);
				card.dispatchEvent(doRelease);
				
				done = true;
				break;
			}
		}

		// if no card was found, play wild card
		if (!done) {
			for (UNOCard card : getAllCards()) {
				if (card.getType() == WILD) {
					MouseEvent doPress = new MouseEvent(card,
							MouseEvent.MOUSE_PRESSED,
							System.currentTimeMillis(),
							(int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);
					card.dispatchEvent(doPress);
					
					MouseEvent doRelease = new MouseEvent(card, MouseEvent.MOUSE_RELEASED,
							System.currentTimeMillis(),
							(int) MouseEvent.MOUSE_EVENT_MASK, 5, 5, 1, true);
					card.dispatchEvent(doRelease);
					
					done = true;
					break;
				}
			}
		}
		
		if(getTotalCards()==1 || getTotalCards()==2)
			saysUNO();
		if(!done)
			this.obtainCard(topCard);
		return done;
	}

}