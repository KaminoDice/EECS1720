package bf_card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {
    private String name;
    private int hp;
    private int ap;
    private List<Card> handCards;
    private List<Card> battlefield;
    private List<Card> graveyard;

    public Player(String name) {
        this.name = name;
        this.hp = 20;
        this.ap = 3;
        this.handCards = new ArrayList<>();
        this.battlefield = new ArrayList<>();
        this.graveyard = new ArrayList<>();
    }
    
    
    public void setAp(int ap) {
        this.ap = ap;
    }
    
    // Card Draw
    public void drawCard(List<Card> cardPool) {
        if (!cardPool.isEmpty()) {
            int index = (int) (Math.random() * cardPool.size());
            Card card = cardPool.remove(index);
            handCards.add(card);
        }
    }

    // Print the hand
    public void printHandCards() {
        System.out.println(name + "'s hand cards:");
        for (int i = 0; i < handCards.size(); i++) {
            System.out.println((i + 1) + ". " + handCards.get(i));
        }
    }

    // Put a hand on the field
    public void playCard(int index) {
        if (index >= 0 && index < handCards.size()) {
            Card card = handCards.remove(index);
            battlefield.add(card);
            System.out.println(name + " plays " + card);
        }
    }
    
    public List<Card> getActiveCards() {
        
        return battlefield;
    }

    public void removeCard(Card card) {
        if (handCards.contains(card)) {
            handCards.remove(card);
        } else if (battlefield.contains(card)) {
            battlefield.remove(card);
            graveyard.add(card);
        }
    }

    
    // Attack the opposing player Randomly
    public void attack(Player opponent) {
        if (!battlefield.isEmpty()) {
            int index = (int) (Math.random() * battlefield.size());
            Card card = battlefield.get(index);
            if (opponent.battlefield.isEmpty()) {
            	opponent.takeDamage(card.getAtk());
            	System.out.println(name + " attacks " + opponent.getName() + " with " + card);
            }else {
            	int idxOPcard = (int) (Math.random() * opponent.battlefield.size());
            	opponent.battlefield.get(idxOPcard).gotAtked(card.getAtk());
            }                        
        }
    }

    // Take damage
    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " takes " + damage + " damage!");
    }

    // Act once
    public void takeTurn(Player opponent) {
        ap = 3;
        while (ap > 0) {
            System.out.println(name + "'s turn (AP: " + ap + ")");

            // Print field state
            System.out.println(name + "'s battlefield:");
            for (int i = 0; i < battlefield.size(); i++) {
                System.out.println((i + 1) + ". " + battlefield.get(i));
            }
            System.out.println(opponent.getName() + "'s HP: " + opponent.getHp());

            // Print the hand
            printHandCards();

            // Player actions
            System.out.println("Enter command (play [cardIndex], attack, end):");
            String[] command = System.console().readLine().split(" ");
            switch (command[0]) {
                case "play":
                    playCard(Integer.parseInt(command[1]) - 1);
                    ap--;
                    break;
                case "attack":
                    attack(opponent);
                    ap--;
                    break;
                case "end":
                    ap = 0;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }

            // Determine if a card needs to be removed
            Iterator<Card> iter = battlefield.iterator();
            while (iter.hasNext()) {
                Card card = iter.next();
                if (card.getHp() <= 0) {
                    iter.remove();
                    graveyard.add(card);
                    System.out.println(card + " is destroyed and sent to graveyard.");
                }
            }
            // Clear the graveyard
        cleanGraveyard();
        }

        System.out.println(name + "'s turn ends.");
    }

    // Clear the graveyard
    public void cleanGraveyard() {
        Iterator<Card> iter = graveyard.iterator();
        while (iter.hasNext()) {
            Card card = iter.next();
            if (card instanceof Card) {
                iter.remove();
            System.out.println(card + " is removed from graveyard.");
            }
        }
    }

    // Determine if a card is alive or not
    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }
    
    public int getAP() {
    	return this.ap;
    }
}
