import java.util.List;
import java.util.ArrayList;

public class CardList {
    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();
        
        Card card1 = new Card(1, 1, 1, Element.FIRE);
        Card card2 = new Card(2, 2, 2, Element.WATER);
        Card card3 = new Card(3, 3, 3, Element.WOOD);
        
        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);
        
        System.out.println(cardList);
    }
}
