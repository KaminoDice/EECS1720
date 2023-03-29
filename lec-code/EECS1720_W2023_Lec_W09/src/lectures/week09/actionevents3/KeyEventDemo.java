package lectures.week09.actionevents3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
 
public class KeyEventDemo extends JFrame implements KeyListener, ActionListener {
	
	JTextField typingArea;		// where the key events will be captured (must have focus)
    JTextArea displayArea;		// where the key events will be displayed
    
    
    static final String newline = System.getProperty("line.separator");
     
    public KeyEventDemo(String name) {
    	
        super(name);
        Container pane = this.getContentPane();
        
        JButton button = new JButton("Clear");
        button.addActionListener(this);				// clear the display area
        											// normal action listener
         
        this.typingArea = new JTextField(20);
        this.typingArea.requestFocusInWindow();		// set this component to get input focus
        this.typingArea.addKeyListener(this);		// key listener 
         
        
        this.displayArea = new JTextArea();
        this.displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(375, 125));
        scrollPane.setAutoscrolls(true);
         
        pane.add(typingArea, BorderLayout.PAGE_START);
        
        pane.add(scrollPane, BorderLayout.CENTER);
        pane.add(button, BorderLayout.PAGE_END);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    
    public static void main(String[] args) {
    	KeyEventDemo frame = new KeyEventDemo("KeyEventDemo");
    	
    }
    
    /** Handle the button click to clear typing and display Area */
    public void actionPerformed(ActionEvent e) {
    	
        //Clear the text components.
        displayArea.setText("");
        typingArea.setText("");
         
        //Return the focus to the typing area.
        typingArea.requestFocusInWindow();
    }
     
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        displayInfo(e, "KEY PRESSED: ");
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        displayInfo(e, "KEY RELEASED: ");
        
        if (e.getKeyCode() == KeyEvent.VK_Q)
        	System.exit(0);
    }
     

     
    /*
     * We have to jump through some hoops to avoid
     * trying to print non-printing characters
     * such as Shift.  (Not only do they not print,
     * but if you put them in a String, the characters
     * afterward won't show up in the text area.)
     */
    private void displayInfo(KeyEvent e, String keyStatus){
         
        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
       
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } 
        else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }
         
        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }
         
        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }
         
        String locationString = "key location: ";
        int location = e.getKeyLocation();
        
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }
         
        displayArea.append(keyStatus + newline
                + "    " + keyString + newline
                + "    " + modString + newline
                + "    " + actionString + newline
                + "    " + locationString + newline);
        
        displayArea.setCaretPosition(displayArea.getDocument().getLength());
    }
}