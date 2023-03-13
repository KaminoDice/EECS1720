package panels;
import java.awt.*;
import javax.swing.*;



public class BorderWithPanelDemo extends JFrame {		

	// constructor
	public BorderWithPanelDemo(String name) {

		// constructor will create GUI layout
		super(name); 			
		this.setLayout(new BorderLayout()); 
		
		// setup components 
		JLabel heading = new JLabel("Hello Swing Fonts/Buttons/Icons!");
		heading.setFont(new Font("SansSerif", Font.BOLD, 18));
		heading.setForeground(Color.RED);
		heading.setAlignmentX(LEFT_ALIGNMENT);

		JLabel iconLabel = new JLabel( new ImageIcon("src/images/3d_file.png") );
		JButton textButton = new JButton("Button 1");
		JButton iconButton = new JButton(new ImageIcon("src/images/3d_trash_can.png")) ;
		JButton iconTextButton = new JButton("Button 3", new ImageIcon("src/images/3d_trash_can.png") );
		
		// create a new panel (sub container within content pane)
		JPanel jp = new JPanel();
		JButton iconButton2 = new JButton(new ImageIcon("src/images/Adele.jpg")) ;
		JButton iconButton3 = new JButton(new ImageIcon("src/images/Alexi.jpg")) ;
		JButton iconButton4 = new JButton(new ImageIcon("src/images/Laine.jpg")) ;
		JButton iconButton5 = new JButton(new ImageIcon("src/images/Maya.jpg")) ;
		JButton iconButton6 = new JButton(new ImageIcon("src/images/Cosmo.jpg")) ;
		
		//jp.setLayout(new FlowLayout());
		//jp.setLayout(new GridLayout(3,3));
		//jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
		jp.setLayout(new BorderLayout());
		
		jp.add(iconButton2);
		jp.add(iconButton3);
		jp.add(iconButton4);
		jp.add(iconButton5);
		jp.add(iconButton6);
		
		jp.add(iconButton2,BorderLayout.NORTH);
		jp.add(iconButton3,BorderLayout.SOUTH);
		jp.add(iconButton4,BorderLayout.EAST);
		jp.add(iconButton5,BorderLayout.WEST);
		jp.add(iconButton6,BorderLayout.CENTER);

	
		Container pane = this.getContentPane();		

		// add components to pane	
		pane.add(jp, BorderLayout.CENTER);
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
		BorderWithPanelDemo frame = new BorderWithPanelDemo("Border with nested Panel");

	}

}
