package practest2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;


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
	private JTextField recipient;
	private JTextField message;
	private JButton sendButton;
	private JTextArea tweets;

	public Tweeter(String title) {
		
		super(title);
		
		// put items into a panel
		JPanel controls = new JPanel();
		controls.setLayout(null);
		controls.setPreferredSize(new Dimension(LABEL_WIDTH+FIELD_WIDTH+BUTTON_HEIGHT, BUTTON_HEIGHT*4 + 10));
		
		// create a Label and TextField for Recipient [6]
		JLabel rLabel = new JLabel("Recipient:");
		rLabel.setBounds(0, 0, LABEL_WIDTH, ROW_HEIGHT);
		controls.add(rLabel);
		
		this.recipient = new JTextField();
		this.recipient.setBounds(LABEL_WIDTH, 0, FIELD_WIDTH, ROW_HEIGHT);
		controls.add(this.recipient);
		
		// create a Label and TextField for the Tweet [6]
		JLabel tLabel = new JLabel("Tweet:");
		tLabel.setBounds(0, ROW_HEIGHT, LABEL_WIDTH, ROW_HEIGHT);
		controls.add(tLabel);
		
		this.message = new JTextField("type tweet here");
		this.message.setBounds(LABEL_WIDTH, ROW_HEIGHT, FIELD_WIDTH, ROW_HEIGHT);
		controls.add(this.message);
		
		// create an empty Label for displaying the feedback [8]
		// when sending a tweet
		this.tweets = new JTextArea();
		this.tweets.setEditable(false);
		this.tweets.setBackground(Color.BLACK);
		this.tweets.setForeground(Color.YELLOW);
		
		JScrollPane tweetHistory = new JScrollPane(this.tweets, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		tweetHistory.setBounds(0, BUTTON_HEIGHT + 10, LABEL_WIDTH + FIELD_WIDTH + BUTTON_HEIGHT, BUTTON_HEIGHT*3);
		controls.add(tweetHistory);

		// create an ImageIcon for the icon
		// set size of icon to 50x50 height/width 
		// getScaledInstance method from Image class creates a new scaled version of an image object
		// you may use 0 for the 3rd argument in getScaledInstance method. 
		ImageIcon birdIcon = new ImageIcon("src/practest2/TwitterIcon.png");
		Image birdImg = birdIcon.getImage().getScaledInstance(BUTTON_HEIGHT, BUTTON_HEIGHT, 0);
		birdIcon.setImage(birdImg);

		// create a button and attach the icon to it
		// set the action and event handler to the button [4]
		this.sendButton = new JButton(birdIcon);
		this.sendButton.setBounds(LABEL_WIDTH+FIELD_WIDTH, 0, BUTTON_HEIGHT, BUTTON_HEIGHT);
		this.sendButton.addActionListener(new TweetListener());
		controls.add(this.sendButton);


		// DO NOT NEED TO ADHERE EXACTLY TO LAYOUT IN QUESTION
		// however, the controls should remain roughly centred and in their relative positions
		// if the window was to be resized

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
	

	// create an inner class here to handle the ActionEvent(s) captured from the sendButton [6]
	private class TweetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String trecipient = recipient.getText();
			String tmessage = message.getText();

			
			if (!tmessage.isEmpty()) {
				if (!trecipient.isEmpty()) {
					tweets.append("Tweeting @ " + trecipient + ": ");
				}
				else {
					tweets.append("Tweeting @ the world: ");
				}
				tweets.append(tmessage + "\n");
				
			}
			else {
				tweets.append("You forgot to tweet!\n");
			
			}
			
	
		}

	
	}


}
