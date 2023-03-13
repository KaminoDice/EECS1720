import java.util.ArrayList;

public class Player {
    private int hp;
    private int ap;
    private ArrayList<Card> handCards;
    private ArrayList<Card> battleFieldCards;

    public Player() {
        this.hp = 20;
        this.ap = 3;
        this.handCards = new ArrayList<Card>();
        this.battleFieldCards = new ArrayList<Card>();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(ArrayList<Card> handCards) {
        this.handCards = handCards;
    }

    public ArrayList<Card> getBattleFieldCards() {
        return battleFieldCards;
    }

    public void setBattleFieldCards(ArrayList<Card> battleFieldCards) {
        this.battleFieldCards = battleFieldCards;
    }

    public void drawCard(Card card) {
        handCards.add(card);
    }

    public void playCard(Card card) {
        handCards.remove(card);
        battleFieldCards.add(card);
    }

    public void attack(Player targetPlayer, Card attackingCard) {
        if (battleFieldCards.contains(attackingCard)) {
            if (targetPlayer.getBattleFieldCards().size() > 0) {
                ap -= 1;
                if (ap < 0) {
                    System.out.println("Not enough AP to attack.");
                    return;
                }
            }
            targetPlayer.defend(attackingCard.getAtk());
            if (attackingCard.getElement().beats(targetPlayer.getBattleFieldCards())) {
                targetPlayer.defend(attackingCard.getAtk());
                battleFieldCards.remove(attackingCard);
            }
        } else {
            System.out.println("The card is not in the battle field.");
        }
    }

    public void defend(int atk) {
        hp -= atk;
    }

    public boolean isDefeated() {
        return hp <= 0;
    }
}
