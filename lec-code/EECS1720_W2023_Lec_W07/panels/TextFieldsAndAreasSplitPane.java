package panels;

import java.awt.*;
import javax.swing.*;



public class TextFieldsAndAreasSplitPane extends JFrame {		

	// constructor
	public TextFieldsAndAreasSplitPane(String name) {

		// constructor will create GUI layout
		super(name); 			// create parent sub-object
		
		// setup each component 
		
		// Text Field
		JLabel tfLabel = new JLabel("text entry:");
		//tfLabel.setBounds(20, 50, 100, 50);
		
        JTextField textField = new JTextField(10);
        //textField.setBounds(120, 50, 150, 50);	
        
        // Password Field
        JLabel pfLabel = new JLabel("pwd entry:");
       // pfLabel.setBounds(20, 110, 100, 50);
        
        JPasswordField passwordField = new JPasswordField(10);
        //passwordField.setBounds(120, 110, 150, 50);
 
        // TextArea
        JLabel taLabel = new JLabel("text area:");
        //taLabel.setBounds(20, 170, 100, 50);
        
        JTextArea textArea = new JTextArea("some initial text here\nnew line here\n\netc.. etc");
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.YELLOW);
        //textArea.setBounds(120, 170, 300, 100);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(tfLabel);
        leftPanel.add(pfLabel);
        leftPanel.add(taLabel);
        JScrollPane scrollPaneLeft = new JScrollPane(leftPanel);
       
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(textField);
        rightPanel.add(passwordField);
        rightPanel.add(textArea);
        JScrollPane scrollPaneRight = new JScrollPane(rightPanel);
        
        //JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
        	//								scrollPaneLeft, scrollPaneRight);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("tab1", scrollPaneLeft);
        tabbedPane.add("tab2", scrollPaneRight);
        
		Container pane = this.getContentPane();		
		pane.add(tabbedPane,BorderLayout.CENTER); 
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400); 									
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 									
		
	}
	
	
	public static void main(String[] args) {
	
		// Create GUI layout 
		TextFieldsAndAreasSplitPane frame = new TextFieldsAndAreasSplitPane("Text Input");

	}

}
