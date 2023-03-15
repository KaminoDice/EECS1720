package week8.actionevents2;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Hashtable;

public class ComboBoxExample extends JFrame {

	private JComboBox mainComboBox;
	private JComboBox subComboBox;
	
	private String[] colourItems = { "Select Color", "Red", "Blue", "Green" };
	private String[] shapeItems = { "Select Shape", "Circle", "Square", "Triangle" };
	private String[] fruitItems = { "Select Fruit", "Apple", "Orange", "Banana" };

	public ComboBoxExample(String title) {

		super(title);
		Container pane = this.getContentPane();

		String[] items = { "Select Item", "Color", "Shape", "Fruit" };
		mainComboBox = new JComboBox(items);
		
		
		mainComboBox.addActionListener(new MyEventHandler());

		pane.add(mainComboBox, BorderLayout.WEST);

		subComboBox = new JComboBox();				// initialized with empty string
		pane.add(subComboBox, BorderLayout.EAST);

		
		
		// setup and show frame
		this.setSize(300, 100);
		this.setResizable(true); 
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private class MyEventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String item = (String) mainComboBox.getSelectedItem();
	
			// SIMPLE APPROACH
			switch (item) {
			case "Color":
				subComboBox.setModel(new DefaultComboBoxModel(colourItems)); break;
			case "Shape":
				subComboBox.setModel(new DefaultComboBoxModel(shapeItems)); break;
			case "Fruit":
				subComboBox.setModel(new DefaultComboBoxModel(fruitItems)); break;
			default:
				subComboBox.setModel(new DefaultComboBoxModel());
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {

		ComboBoxExample frame = new ComboBoxExample("Combo example");

	}

}
