package practest2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;

// COMPLETE THE MISSING PIECES OF THE FOLLOWING CLASS (see comments for guidance)

public class Tweeter extends JFrame {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	// setup any other width constants
	private static final int LABEL_WIDTH = 70;
	private static final int FIELD_WIDTH = 150;
	private static final int ROW_HEIGHT = 30;
	private static final int BUTTON_HEIGHT = 60;
	private static final int BORDER_WIDTH = 20;

	// setup any class fields
	private JTextField 	recipient;
	private JTextField 	message;
	private JButton 	sendButton;
	private JTextArea 	tweets;

	
	public Tweeter(String title) {
		
		super(title);
		
		// put all GUI items into the controls panel
		JPanel controls = new JPanel();
		controls.setLayout(null);
		controls.setPreferredSize(new Dimension(LABEL_WIDTH+FIELD_WIDTH+BUTTON_HEIGHT, BUTTON_HEIGHT*4 + 10));
		
		// create a JLabel and JTextField for Recipient [6 MARKS]
		
		
		
		
		// create a JLabel and JTextField for the Tweet [6 MARKS]
		
		
		
		
		// ALREADY DONE FOR YOU:
		// create a non-editable JTextArea for displaying the sent tweets
		this.tweets = new JTextArea();
		this.tweets.setEditable(false);
		this.tweets.setBackground(Color.BLACK);
		this.tweets.setForeground(Color.YELLOW);
		
		
		// make text area scrollable (according to instructions in question URL) [4 MARKS]
		
		
		
		
		
		
		
		// ALREADY DONE FOR YOU:
		// creates an ImageIcon with a scaled version of the bird image to use on the send button
		ImageIcon birdIcon = new ImageIcon("src/practest2/TwitterIcon.png");
		Image birdImg = birdIcon.getImage().getScaledInstance(BUTTON_HEIGHT, BUTTON_HEIGHT, 0);
		birdIcon.setImage(birdImg);

		
		// create a send button for posting the tweets (this should use the above BirdIcon) [4 MARKS]
		
		
		
		
		


		// ALREADY DONE FOR YOU:
		// setup the content pane (add UI controls)
		Container pane = this.getContentPane();
		JPanel centerPane = new JPanel();
		centerPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		centerPane.add(controls);
		pane.add(centerPane, BorderLayout.CENTER);
		this.setContentPane(pane);


		// setup the app and show it	
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	
		
	}


	public static void main(String[] args) {
		
		Tweeter frame = new Tweeter("Tweet Me!");

	}
	

	// create an inner class here to handle the event(s) from the sendButton [10 MARKS]
	
	
	
	

	



}
