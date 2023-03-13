package panels;

import java.awt.*;
import javax.swing.*;



public class TextFieldsAndAreasScroll extends JFrame {		

	// constructor
	public TextFieldsAndAreasScroll(String name) {

		// constructor will create GUI layout
		super(name); 			// create parent sub-object
		this.setLayout(null);	// no layout manager used (placing all elements manually)
		
		// setup each component 
		
		// Text Field
		JLabel tfLabel = new JLabel("text entry:");
		tfLabel.setBounds(20, 50, 100, 50);
		
        JTextField textField = new JTextField(10);
        textField.setBounds(120, 50, 150, 50);	
        
        // Password Field
        JLabel pfLabel = new JLabel("pwd entry:");
        pfLabel.setBounds(20, 110, 100, 50);
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(120, 110, 150, 50);
 
        // TextArea
        JLabel taLabel = new JLabel("text area:");
        taLabel.setBounds(20, 170, 100, 50);
        
        JTextArea textArea = new JTextArea("some initial text here\nnew line here\n\netc.. etc");
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.YELLOW);
        textArea.setBounds(120, 170, 300, 100);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(120, 170, 300, 100);
        
		Container pane = this.getContentPane();		
		pane.add(tfLabel); 
		pane.add(textField);
		pane.add(pfLabel); 
		pane.add(passwordField);
		pane.add(taLabel); 
		pane.add(scrollPane);

		// set content pane back into this object
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400); 									
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 									
		
	}
	
	
	public static void main(String[] args) {
	
		// Create GUI layout 
		TextFieldsAndAreasScroll frame = new TextFieldsAndAreasScroll("Text Input");

	}

}
