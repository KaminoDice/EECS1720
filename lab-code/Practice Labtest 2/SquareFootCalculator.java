import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SquareFootCalculator extends JFrame {

	private int WIDTH = 400;
	private int HEIGHT = 200;
	private final double FT_PER_M = 3.28084;
	
	private JTextField heightTF, widthTF;
	private JRadioButton metresRB, feetRB;
	private JButton calculateB;
	
	// Create Class Fields here

	public SquareFootCalculator(String title) {
		
		Dimension d = new Dimension(150,20);
		
		// create Labels and Textfields for Height and Width
		JLabel heightL = new JLabel("Height:"); heightL.setHorizontalAlignment(SwingConstants.RIGHT); 
		JLabel widthL = new JLabel("Width:"); widthL.setHorizontalAlignment(SwingConstants.RIGHT);
		
		heightTF = new JTextField(""); heightTF.setPreferredSize(d);
		widthTF = new JTextField(""); widthTF.setPreferredSize(d);


		// create radio buttons for m and ft
		// select m
		metresRB = new JRadioButton("m"); metresRB.setPreferredSize(d);
		metresRB.setSelected(true);
		
		
		feetRB = new JRadioButton("ft"); feetRB.setPreferredSize(d);
		feetRB.setSelected(false);
		

		// link your radio buttons into a  group
		ButtonGroup radios = new ButtonGroup();
		radios.add(metresRB);
		radios.add(feetRB);


		// create a calculate area button
		// create and link an event handler to it
		calculateB = new JButton("calculate area (sq ft)"); calculateB.setPreferredSize(d);
		calculateB.addActionListener(new SquareFootListener());

		
		
		// create a layout 	(GridPane if using JavaFX, otherwise GridLayout)
		JPanel gridPane = new JPanel();
		gridPane.setLayout(new GridLayout(3,3));
		
		gridPane.add(heightL); 
		gridPane.add(heightTF);
		gridPane.add(metresRB);
		
		gridPane.add(widthL);
		gridPane.add(widthTF);
		gridPane.add(feetRB);
		
		gridPane.add(new JLabel());
		gridPane.add(calculateB);
		
		gridPane.setPreferredSize(new Dimension(450,120));
										
		Container contentPane = this.getContentPane();
		contentPane.add(gridPane, BorderLayout.CENTER);

		
		// setup the scene and show it	
		this.setContentPane(contentPane);
		this.setSize(600,400);
		this.pack();
		this.setVisible(true);
		


	}

	public static void main(String[] args) {


		SquareFootCalculator frame = new SquareFootCalculator("practice labtest 2");

	}





	// create an inner class here (or an external class) to handle the event according to the instructions in Question 2

	private class SquareFootListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			if (e.getSource() == calculateB) {
				
				String result = "One or more dimensions is empty";

				if (!heightTF.getText().isBlank() && !widthTF.getText().isBlank()) {
				
					// only do calculation if both text fields have values (assume correct input)
					double height = Double.parseDouble(heightTF.getText());		// in feet
					double width = Double.parseDouble(widthTF.getText());
					
					if (metresRB.isSelected()) {
						// convert to feet
						height = height*FT_PER_M;		
						width = width*FT_PER_M;
					}

					double area = height*width;
					result = "Total Area = " + area + " sq. ft";
				}
				System.out.println(result);
				
			}
			
			

		}

	}
}
