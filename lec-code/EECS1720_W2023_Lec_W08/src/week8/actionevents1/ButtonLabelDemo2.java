package week8.actionevents1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ButtonLabelDemo2 extends JFrame {

	private JLabel statusLabel;


	public ButtonLabelDemo2(){

		super("Button Label Demo");
		this.setSize(400,400);
		this.setLayout(new GridLayout(3, 1));

		JLabel headerLabel = new JLabel();
		headerLabel.setText("Click on a Button"); 
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		this.statusLabel = new JLabel();        
		this.statusLabel.setSize(350,100);
		this.statusLabel.setHorizontalAlignment(JLabel.CENTER);

		Panel controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		Button okButton 	= new Button("OK");
		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");

		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancel");

		okButton.addActionListener(new ButtonClickListener()); 
		submitButton.addActionListener(new ButtonClickListener()); 
		cancelButton.addActionListener(new ButtonClickListener()); 

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);  

		this.add(headerLabel);
		this.add(controlPanel);
		this.add(statusLabel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  

	}




	public static void main(String[] args){
		ButtonLabelDemo2  demo = new ButtonLabelDemo2();

	}



	private class ButtonClickListener implements ActionListener{


		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();  

			if( command.equals( "OK" ))  {
				statusLabel.setText("Ok Button clicked.");
				// open a dialog window
				JOptionPane.showMessageDialog((Component) e.getSource(),
						"OK OK OK ... I got it!");
			}
			else if( command.equals( "Submit" ) )  {
				statusLabel.setText("Submit Button clicked."); 
			}
			else  {
				statusLabel.setText("Cancel Button clicked.");
			}  	
		}		
	}


}


