package bf_card;

public class Card {
    private String name;
    private int rank;
    private int atk;
    private int hp;
	private Card.Element element;
    public enum Element {
        FIRE, // 火
        WATER, // 水
        WOOD, // 木
        METAL, // 金
        EARTH // 土
    }
    
    public Card(String name, int rank, int atk, int hp, Element element) {
        this.name = name;
        this.rank = rank;
        this.atk = atk;
        this.hp = hp;
        this.element = element;
    }
    


    
    public String getName() {
        return name;
    }
    
    public int getRank() {
        return rank;
    }
    
    public int getAtk() {
        return atk;
    }
    
    public void setAtk(int atk) {
        this.atk = atk;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public Card.Element getElement() {
        return element;
    }
    
    public void gotAtked(int opATK) {
    	this.setHp(this.hp - opATK);
    	/*
        if (target.getActiveCards().size() > 0) {
            // If the opponent has active cards, attack the card with the highest ATK
            Card targetCard = target.getActiveCards().get(0);
            for (int i = 1; i < target.getActiveCards().size(); i++) {
                if (target.getActiveCards().get(i).getAtk() > targetCard.getAtk()) {
                    targetCard = target.getActiveCards().get(i);
                }
            }
            targetCard.setHp(targetCard.getHp() - this.atk);
            if (targetCard.getHp() <= 0) {
                target.removeCard(targetCard);
            }
        } else {
            // If the opponent has no active cards, attack the player directly
            target.takeDamage(this.atk);
        }
        */
    }
}
