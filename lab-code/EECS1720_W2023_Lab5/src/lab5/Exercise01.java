package lab5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Exercise01 extends JFrame {

	public Exercise01(String title) {
		super(title);
		this.setLayout(null); 

	
		JLabel heading = new JLabel("Instructions");
		heading.setFont(new Font("Serif",Font.BOLD, 18));
		heading.setForeground(Color.gray);

		JLabel instructs = new JLabel("For each icon below, enter a text descriptor that best captures its meaning!");
		instructs.setForeground(new Color(0,150,180));

		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		header.setBounds(10,50,480,50);

		header.add(heading);
		header.add(instructs);

		JPanel middle = new JPanel();
		middle.setLayout(null);
		
		Icon ribbonIcon = new ImageIcon("src/icons/3d_ribbon.png");
		Icon umbrellaIcon = new ImageIcon("src/icons/umbrella.png");
		Icon bottleIcon = new ImageIcon("src/icons/plastic_bottle.png");

		JLabel ribbonLabel = new JLabel(ribbonIcon);
		ribbonLabel.setBounds(0,0,ribbonIcon.getIconWidth(), ribbonIcon.getIconHeight());
		JTextField ribbonText = new JTextField();
		ribbonText.setBounds(ribbonIcon.getIconWidth(),ribbonIcon.getIconHeight()/2-10, 300, 20);
		
		JLabel umbrellaLabel = new JLabel(umbrellaIcon);
		umbrellaLabel.setBounds(0,ribbonIcon.getIconWidth(),ribbonIcon.getIconWidth(), ribbonIcon.getIconHeight());
		JTextField umbrellaText = new JTextField();
		umbrellaText.setBounds(ribbonIcon.getIconWidth(),(ribbonIcon.getIconHeight()/2)*3-10, 300, 20);
		
		
		JLabel bottleLabel = new JLabel(bottleIcon);
		bottleLabel.setBounds(0,ribbonIcon.getIconWidth()*2,ribbonIcon.getIconWidth(), ribbonIcon.getIconHeight());
		JTextField bottleText = new JTextField();
		bottleText.setBounds(ribbonIcon.getIconWidth(),(ribbonIcon.getIconHeight()/2)*5-10, 300, 20);
		
		
		middle.add(header);
		middle.add(ribbonLabel);
		middle.add(ribbonText);
		middle.add(umbrellaLabel);
		middle.add(umbrellaText);
		middle.add(bottleLabel);
		middle.add(bottleText);
		middle.setBounds(30,100,400,400);

		Container pane = this.getContentPane();
		pane.add(header);
		pane.add(middle);
		this.setContentPane(pane);


		this.setSize(500,500); 									
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true); 
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise01 app = new Exercise01("Name that Icon!");
	}

}
