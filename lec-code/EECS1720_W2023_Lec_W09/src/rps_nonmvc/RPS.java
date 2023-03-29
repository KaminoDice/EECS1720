package rps_nonmvc;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RPS extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JLabel playerLabel;
	private JLabel computerLabel;
	private JLabel winnerLabel;
	private JLabel statsLabel;

	private String playersHand;
	private String computersHand;
	private String winner;

	private int roundsPlayed;
	private int roundsWonByPlayer;
	private int roundsWonByComputer;
	private int roundsDrawn;


	/**
	 * Create the frame.
	 */
	public RPS() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		// make labels
		this.playerLabel = new JLabel("Player: ");
		this.playerLabel.setBounds(18, 6, 202, 53);
		contentPane.add(this.playerLabel);

		this.computerLabel = new JLabel("Computer:");
		this.computerLabel.setBounds(242, 6, 202, 53);
		contentPane.add(this.computerLabel);

		JPanel panel = new JPanel();
		panel.setBounds(6, 144, 438, 122);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton rockButton = new JButton("ROCK");
		rockButton.addActionListener(this);
		panel.add(rockButton);

		JButton paperButton = new JButton("PAPER");
		paperButton.addActionListener(this);
		panel.add(paperButton);

		JButton scissorsButton = new JButton("SCISSORS");
		scissorsButton.addActionListener(this);
		panel.add(scissorsButton);

		this.winnerLabel = new JLabel("Winner: ");
		this.winnerLabel.setBounds(18, 59, 426, 34);
		contentPane.add(this.winnerLabel);

		this.statsLabel = new JLabel("Stats:");
		this.statsLabel.setBounds(18, 98, 426, 34);
		contentPane.add(this.statsLabel);

		// make buttons
		this.setVisible(true);


	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPS frame = new RPS();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		System.out.println(e.getActionCommand());

		this.playersHand = e.getActionCommand();

		this.playerLabel.setText("Player : " + this.playersHand);


		Random rng = new Random();
		int randInt = rng.nextInt(3);

		switch (randInt) {

		case 0: 
			this.computersHand = "ROCK"; break;
		case 1:
			this.computersHand = "PAPER"; break;
		case 2:
			this.computersHand = "SCISSORS"; break;

		}

		this.computerLabel.setText("Computer: " + this.computersHand);


		// logic for winner
		String winner = "";

		// who won??  has the player won? did the computer win?  or was it a draw??
		
		boolean playerWins = 
				( this.playersHand.equals("ROCK") && this.computersHand.equals("SCISSORS") )  ||
				( this.playersHand.equals("SCISSORS") && this.computersHand.equals("PAPER") ) ||
				( this.playersHand.equals("PAPER") && this.computersHand.equals("ROCK") )  ;
		
	
		boolean computerWins =
				(this.computersHand.equals("ROCK") && this.playersHand.equals("SCISSORS") ) ||
				(this.computersHand.equals("SCISSORS") && this.playersHand.equals("PAPER") ) ||
				(this.computersHand.equals("PAPER") && this.playersHand.equals("ROCK") ) ;
				

		boolean draw = this.playersHand.equals(this.computersHand);
		
		
		if (playerWins) {
			this.winner = "PLAYER";
			this.roundsWonByPlayer++;
		}
		else if (computerWins) {
			this.winner = "COMPUTER";
			this.roundsWonByComputer++;
		}
		else if (draw) {
			this.winner = "DRAW";
			this.roundsDrawn++;
		}
		
		this.roundsPlayed++;
		
		// update winner on winnerLabel
		this.winnerLabel.setText("Winner : " + this.winner);

		
		// update the stats fields
		// update the stats fields in the stats label
		this.statsLabel.setText("Games won: " + this.roundsWonByPlayer + ", Games lost: " + 
								this.roundsWonByComputer + ", Games drawn: " + this.roundsDrawn);

		
		


	}
}
