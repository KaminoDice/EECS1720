package rps_mvc;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class RPSView extends JFrame {

	private JPanel contentPane;
	
	// DO NOT MAKE THESE FIELDS PRIVATE; THE TESTER NEEDS DIRECT
    // DIRECT ACCESS TO THEM
    JLabel player;      // a label describing the hand played by the player
    JLabel computer;    // a label describing the hand played by the computer
    JLabel winner;      // a label describing who won the last round played
    JLabel stats;      // a label describing the won-lost-draw record of the rounds played
    
    JButton rock;       // a button that allows the player to play the hand rock
    JButton paper;      // a button that allows the player to play the hand paper
    JButton scissors;   // a button that allows the player to play the hand scissors
    
    


    // CONSTRUCTOR(S)


	/**
	 * Create the frame.
	 */
	public RPSView(ActionListener listener) {
		
		super("rock, paper, scissors!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		// MAKE THE LABELS
		
		this.player = new JLabel("Player:");
		this.player.setToolTipText("Player (you) picked:");
		this.player.setBounds(16, 16, 202, 46);
		
		this.player.setBorder(BorderFactory.createEtchedBorder());
		contentPane.add(this.player);
		
		this.computer = new JLabel("Computer:");
		this.computer.setToolTipText("Computer picked:");
		this.computer.setBounds(230, 16, 205, 46);
		this.computer.setBorder(BorderFactory.createEtchedBorder());
		
		contentPane.add(this.computer);
		

		this.winner = new JLabel("No Winner yet!");
		winner.setBackground(Color.GRAY);
		this.winner.setBounds(16, 74, 419, 37);
		this.winner.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(this.winner);
		
		this.stats = new JLabel("(Games) won: 0, lost: 0, drawn: 0");
		this.stats.setBounds(16, 123, 419, 37);
		this.stats.setBorder(BorderFactory.createLoweredBevelBorder());
		contentPane.add(this.stats);
		
		
		// MAKE THE BUTTONS
		
		Panel panel = new Panel();
		panel.setBounds(16, 172, 419, 90);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.rock = new JButton("ROCK");
		this.rock.setBackground(Color.LIGHT_GRAY);
		this.rock.addActionListener(listener);
		panel.add(this.rock);
		
		this.paper = new JButton("PAPER");
		this.paper.addActionListener(listener);
		panel.add(this.paper );
		
		this.scissors = new JButton("SCISSORS");
		this.scissors.addActionListener(listener);
		panel.add(this.scissors);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setVisible(true);
		
		
	}
	
	
	
	// METHODS
	
	/**
     * Sets the text of the player label. The text is the string:
     * 
     * <p>
     * <code>"You picked: "</code>
     * 
     * <p>
     * followed by the hand played by the player.
     * 
     * @param player
     *            the hand played by the player; assumed to be equal to one of
     *            RPSGame.ROCK, RPSGame.PAPER, or RPSGame.SCISSORS
     */
	public void setPlayerLabel(String player) {
		
		this.player.setText("Player : " + player);
		
	}
	
	/**
     * Sets the text of the computer label. The text is the string:
     * 
     * <p>
     * <code>"Computer: "</code>
     * 
     * <p>
     * followed by the hand played by the computer.
     * 
     * @param computer
     *            the hand played by the computer; assumed to be equal to one of
     *            RPSGame.ROCK, RPSGame.PAPER, or RPSGame.SCISSORS
     */
	public void setComputerLabel(String computer) {
		
		this.computer.setText("Computer: " + computer);
	}
	
	/**
     * Sets the text of the label describing who won the hand. The text is the
     * string:
     * 
     * <p>
     * <code>"Winner: COMPUTER"</code>
     * 
     * <p>
     * if the computer won the hand.
     * 
     * <p>
     * The text is the string:
     * 
     * <p>
     * <code>"Winner: PLAYER"</code>
     * 
     * <p>
     * if the player won the hand.
     * 
     * <p>
     * The text is the string:
     * 
     * <p>
     * <code>"Winner: DRAW"</code>
     * 
     * <p>
     * if the computer and player played the same hand.
     * 
     * @param winner
     *            the winner of the hand; assumed to be one of
     *            RPSGame.COMPUTER, RPSGame.PLAYER, or RPSGame.DRAW
     */
	public void setWinner(String winner) {
		
		this.winner.setText("Winner : " + winner);
		
	}
	
	/**
     * Sets the text of the label describing the record of hands won, lost,
     * and drawn by the player. Examples of the text are shown below:
     * 
     * <pre>
     * "Games won: 1, Games lost: 0, Games drawn: 0"
     * "Games won: 0, Games lost: 1, Games drawn: 0"
     * "Games won: 0, Games lost: 0, Games drawn: 1"
     * "Games won: 12, Games lost: 11, Games drawn: 2"
     * </pre>
     * 
     * @param gamesWon the number of games won by the player
     * @param gamesLost the number of games lost by the player
     * @param gamesDrawn the number of games that resulted in a draw
     */
	public void setStats(int gamesWon, int gamesLost, int gamesDrawn) {
		
		this.stats.setText("Games won: " + gamesWon + ", Games lost: " + gamesLost + ", Games drawn: " + gamesDrawn);
		
		
	}
	
	
	
	

}
