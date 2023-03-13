public class GamePlay {
    private Player player1;
    private Player player2;
    private int round; // Number of current rounds
    private boolean isPlayer1Turn; // Which player's turn is current

    public GamePlay(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.round = 1;
        this.isPlayer1Turn = true; // The dice determine who acts first
        if (rollDice() > rollDice()) {
            this.isPlayer1Turn = false;
        }
    }

    public void startGame() {
        while (!isGameOver()) {
            Player currentPlayer = isPlayer1Turn ? player1 : player2;
            Player opponent = isPlayer1Turn ? player2 : player1;
            System.out.println("Round " + round + " begins, " + currentPlayer.getName() + "'s turn.");
            System.out.println(currentPlayer.getName() + "'s HP: " + currentPlayer.getHp());
            System.out.println(opponent.getName() + "'s HP: " + opponent.getHp());
            System.out.println(currentPlayer.getName() + "'s AP: " + currentPlayer.getAp());
            currentPlayer.drawCard();
            currentPlayer.playCard(this, opponent);
            round++;
            isPlayer1Turn = !isPlayer1Turn;
        }
        System.out.println("Game over.");
        Player winner = player1.getHp() > 0 ? player1 : player2;
        System.out.println("The winner is " + winner.getName() + "!");
    }

    public boolean isGameOver() {
        return player1.getHp() <= 0 || player2.getHp() <= 0;
    }

    public int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
