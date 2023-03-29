package lectures.week09.actionevents2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUICheckBox extends JFrame {

	private static final int FONTSIZE = 30;

	private int DEFAULT_WIDTH = 300;
	private int DEFAULT_HEIGHT = 200;

	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;



	public GUICheckBox(String title) {

		super(title);

		this.label = new JLabel("The quick brown fox jumps over the lazy dog.");
		this.label.setFont(new Font("Serif",  Font.PLAIN, FONTSIZE));

		this.add(label, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();			// JPanel not class field
		this.bold = new JCheckBox("Bold");
		this.bold.addActionListener(new MyCheckBoxListener());
		buttonPanel.add(bold);

		this.italic = new JCheckBox("Italic");
		this.italic.addActionListener(new MyCheckBoxListener());
		buttonPanel.add(italic);
		this.add(buttonPanel, BorderLayout.SOUTH);
	
		
		// setup and show frame
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setResizable(true); 
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}


	// inner class to do listening
	
	private class MyCheckBoxListener implements ActionListener {

		public MyCheckBoxListener() {
			
			// NOT REALLY NECESSARY (would be included implicitly)
		}

		public void actionPerformed(ActionEvent event) {
			
			int mode = 0;
			
			if (bold.isSelected())			// can access fields in outer class
				mode += Font.BOLD;
			
			if (italic.isSelected())
				mode += Font.ITALIC;
			
			label.setFont(new Font("Serif", mode, FONTSIZE));
			
		}


	}
	
	
	public static void main(String[] args) {
		
		GUICheckBox frame = new GUICheckBox("GUICheckBox demo");

	}
	
	
}






