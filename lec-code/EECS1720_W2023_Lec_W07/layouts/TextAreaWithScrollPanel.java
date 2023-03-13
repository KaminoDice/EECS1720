package layouts;
import java.awt.*;
import javax.swing.*;



public class TextAreaWithScrollPanel extends JFrame {		

	// constructor
	public TextAreaWithScrollPanel(String name) {

		// constructor will create GUI layout
		super(name); 			
		this.setLayout(new BorderLayout()); 
		
		// setup components 
		JLabel heading = new JLabel("Hello Swing Fonts/Buttons/Icons!");
		heading.setFont(new Font("SansSerif", Font.BOLD, 18));
		heading.setForeground(Color.RED);
		heading.setAlignmentX(LEFT_ALIGNMENT);

		JLabel iconLabel = new JLabel( new ImageIcon("images/3d_file.png") );
		JButton textButton = new JButton("Button 1");
		JButton iconButton = new JButton(new ImageIcon("images/3d_trash_can.png")) ;
		JButton iconTextButton = new JButton("Button 3", new ImageIcon("images/3d_trash_can.png") );
		
		// create a new panel (sub container within content pane)
		JPanel jp = new JPanel();
		JButton iconButton2 = new JButton(new ImageIcon("images/Adele.jpg")) ;
		JButton iconButton3 = new JButton(new ImageIcon("images/Alexi.jpg")) ;
		JButton iconButton4 = new JButton(new ImageIcon("images/Laine.jpg")) ;
		JButton iconButton5 = new JButton(new ImageIcon("images/Maya.jpg")) ;
		JButton iconButton6 = new JButton(new ImageIcon("images/Cosmo.jpg")) ;
		
		
		jp.setLayout(new BoxLayout(jp,BoxLayout.X_AXIS));
		jp.add(iconButton2);
		jp.add(iconButton3);
		jp.add(iconButton4);
		jp.add(iconButton5);
		jp.add(iconButton6);
		
		
		JScrollPane scrollPane = new JScrollPane(jp);
		
		
		Container pane = this.getContentPane();		

		// add components to pane	
		pane.add(scrollPane, BorderLayout.CENTER);
		pane.add(iconLabel, BorderLayout.WEST);
		pane.add(textButton, BorderLayout.EAST);
		pane.add(iconButton, BorderLayout.NORTH);
		pane.add(iconTextButton, BorderLayout.SOUTH);

		// set content pane back into this HelloSwing object
		this.setContentPane(pane);

		// setup JFrame object for display
		this.setSize(480,400); 									
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		this.setVisible(true); 									
		
	}
	
	
	public static void main(String[] args) {

		// Create GUI layout 
		TextAreaWithScrollPanel frame = new TextAreaWithScrollPanel("Border with Panel in ScrollPane");

	}

}
