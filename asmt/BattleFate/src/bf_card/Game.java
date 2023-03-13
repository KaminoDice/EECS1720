package bf_card;
import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private ArrayList<Card> cardPool;

    private int roundCount;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.cardPool = new ArrayList<>();
        this.roundCount = 0;

        // Initialize the card pool
        initCardPool();
    }

 // Initialize the card pool
    private void initCardPool() {
        for (int i = 0; i < 30; i++) {
        	String exName = "Example Card";
            int rank = (int) (Math.random() * 5) + 1; // Randomly generate card levels
            int attack = (int) (Math.random() * 10) + rank * 2; // Randomly generated card attack power
            int hp = (int) (Math.random() * 10) + rank * 2; // Randomly generated card life
            Card.Element element = Card.Element.values()[(int) (Math.random() * 5)]; // Randomly generate card elements

            Card card = new Card(exName, rank, attack, hp, element);
            cardPool.add(card);
        }
    }

    // Each player draws 5 cards
    private void drawCards() {
        for (int i = 0; i < 5; i++) {
            player1.drawCard(cardPool);
            player2.drawCard(cardPool);
        }
    }

    // Determine if a player is winning
    private boolean isGameOver() {
        return player1.getHp() <= 0 || player2.getHp() <= 0;
    }

    // Output winner information at the end of the game
    private void showWinner() {
        if (player1.getHp() <= 0) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Player 1 wins!");
        }
    }

    // Play a round of the game
    public void playRound() {
        roundCount++;

        // Both players roll the dice to determine who acts first
        int p1Dice = (int) (Math.random() * 6) + 1;
        int p2Dice = (int) (Math.random() * 6) + 1;
        if (p1Dice > p2Dice) {
            player1.setAp(3);
            player2.setAp(2);
        } else if (p2Dice > p1Dice) {
            player1.setAp(2);
            player2.setAp(3);
        } else {
            player1.setAp(2);
            player2.setAp(2);
            System.out.println("Bonus action point awarded to both players!");
        }

        System.out.println("Round " + roundCount + " starts!");

        // Both players draw cards
        drawCards();

        // Player 1 takes action
        player1.takeTurn(player2);

        // Player 2 takes action
        if (!isGameOver()) {
            player2.takeTurn(player1);
        }

        // Output the status of both players
        System.out.println(player1);
        System.out.println(player2);

        System.out.println("Round " + roundCount + " ends!");

        // Recycle cards from the graveyard
        player1.cleanGraveyard();
        player2.cleanGraveyard();
        // Determine if a player is winning
        if (isGameOver()) {
            showWinner();
        }
    }

    // Play the entire game
    public void playGame() {
        while (!isGameOver()) {
            playRound();
        }
    }
}
