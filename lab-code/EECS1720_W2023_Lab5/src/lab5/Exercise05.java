package lab5;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Exercise05 extends JFrame {

	private int counter;
	private int clicks;

	private JLabel counterLabel;
	private JLabel clicksLabel;

	private JCheckBox countUp;

	private JButton doCount;
	private JButton doReset;
	private JTextField resetToValue;
	// BUILD THIS FROM SCRATCH (more info in week 8 lectures for events/event handling and action events)
	
	public Exercise05(String title) {
		super(title);

		this.counter = 0;
		this.clicks = 0;
		this.counterLabel = new JLabel("Counter = 0");
		this.clicksLabel = new JLabel("Clicks = 0");
		this.countUp = new JCheckBox("Count Up?");
		this.countUp.setSelected(true);
		this.resetToValue = new JTextField("0");
		this.doCount = new JButton("Do Count");
		this.doCount.setActionCommand("COUNT");
		this.doCount.addActionListener(this);
		this.doReset = new JButton("Reset Counter");
		this.doReset.setActionCommand("RESET");
		this.doReset.addActionListener(this);


		Container pane = this.getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(this.counterLabel);
		pane.add(this.clicksLabel);
		pane.add(this.countUp);
		pane.add(this.doCount);
		pane.add(this.resetToValue);
		pane.add(this.doReset);
		this.setContentPane(pane);

		setSize(300,100);									 
		setResizable(true);									
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
		
		
		
	}
	
	
	public static void main(String[] args) {
		

		Exercise05 app = new Exercise05("MultiClick");

	}
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("ACTION = " + e.getActionCommand());

		switch (e.getActionCommand()) {

		case "COUNT":

			if (this.countUp.isSelected()) {
				this.clicks++;
				this.counter++;
				
				/ystem.out.printf("UP - Counter:%d, Clicks:%d\n", this.counter, this.clicks );
			}
			else {
				
				this.clicks++;
				this.counter--;
				
				System.out.printf("DOWN - Counter:%d, Clicks:%d\n", this.counter, this.clicks );
			}

			this.counterLabel.setText("Counter = " + this.counter);
			this.clicksLabel.setText("Clicks = " + this.clicks);

			break;

		case "RESET":

			System.out.printf("RESET - Counter:%d, Clicks:%d\n", this.counter, this.clicks );
			
			this.clicks++;
			this.counter = Integer.parseInt(this.resetToValue.getText());

			this.counterLabel.setText("Counter = " + this.counter);
			this.clicksLabel.setText("Clicks = " + this.clicks);

			break;
		}

		


	}
}
