package lectures.week09.actionevents2;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUICheckBoxRadio extends JFrame {

	private static final int FONTSIZE = 18;
	private static final String DEFAULTFONT = "";

	private int DEFAULT_WIDTH = 300;
	private int DEFAULT_HEIGHT = 200;

	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	
	private ButtonGroup group;
    private JRadioButton buttonA;
    private JRadioButton buttonB;



	public GUICheckBoxRadio(String title) {

		super(title);

		this.label = new JLabel("The quick brown fox jumps over the lazy dog.");
		this.label.setFont(new Font("Serif", Font.PLAIN, FONTSIZE));
		this.label.setAlignmentX(CENTER_ALIGNMENT);

		this.add(label, BorderLayout.CENTER);

		JPanel stylePanel = new JPanel();			// JPanel not class field
		this.bold = new JCheckBox("Bold");
		this.bold.addActionListener(new MyCheckBoxListener());
		stylePanel.add(this.bold);

		this.italic = new JCheckBox("Italic");
		this.italic.addActionListener(new MyCheckBoxListener());
		stylePanel.add(this.italic);
		
		this.add(stylePanel, BorderLayout.NORTH);
		
		// ADD A RADIO BUTTON GROUP
		this.group = new ButtonGroup();
		
	    this.buttonA = new JRadioButton("Font A");
	    this.buttonA.addActionListener(new MyRadioButtonListener());
	    this.buttonB = new JRadioButton("Font B");
	    this.buttonB.addActionListener(new MyRadioButtonListener());
	    
	    group.add(this.buttonA);
	    group.add(this.buttonB);
	    
	    JPanel fontPanel = new JPanel();
	    fontPanel.add(this.buttonA);
	    fontPanel.add(this.buttonB);
	    
	    this.add(fontPanel, BorderLayout.SOUTH);
		
		// setup and show frame
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setResizable(true); 
//		this.pack();
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
			
			// ensure only mode is changed, other properties of the current font are retained
			label.setFont(new Font(label.getFont().getName(), mode, label.getFont().getSize()));
			
		}
		
		GridBagConstraints c = new GridBagConstraints();
		
		
	}
	
	// inner class to do listening
	private class MyRadioButtonListener implements ActionListener {

		public MyRadioButtonListener() {
			// NOT REALLY NECESSARY (would be included implicitly)
		}

		public void actionPerformed(ActionEvent actionEvent) {
		
			
			JRadioButton aButton = (JRadioButton) actionEvent.getSource();
	        
	        System.out.println("Selected: " + aButton.getText());
			
	        if (aButton==buttonA) {
	        	System.out.println("Setting to MonoSpaced");
	        	// ensure only font type is changed, other properties of the current font are retained
	        	label.setFont(new Font("MonoSpaced", label.getFont().getStyle(), label.getFont().getSize()));
	        }
	        else if (aButton==buttonB) {
	        	System.out.println("Setting to SansSerif");
	        	// ensure only font type is changed, other properties of the current font are retained
	        	label.setFont(new Font("SansSerif", label.getFont().getStyle(), label.getFont().getSize()));
	        }
	        
	        
	        
	      }
	}
	
	
	public static void main(String[] args) {
		
		GUICheckBoxRadio frame = new GUICheckBoxRadio("GUICheckBox demo");
		


	}
	
	
}






