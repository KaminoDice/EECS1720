package lab5;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class Exercise02 extends JFrame {

	public Exercise02(String title) {
		super(title);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(3,2));
		buttons.setBackground(Color.BLACK);
		JButton b00 = new JButton(new ImageIcon("src/icons/focus_group.png"));
		JButton b01 = new JButton(new ImageIcon("src/icons/client_user.png"));
		JButton b10 = new JButton(new ImageIcon("src/icons/front_desk.png"));
		JButton b11 = new JButton(new ImageIcon("src/icons/alliance.png"));
		JButton b20 = new JButton(new ImageIcon("src/icons/oil.png"));
		JButton b21 = new JButton(new ImageIcon("src/icons/checkered_flag.png"));
		buttons.add(b00);
		buttons.add(b01);
		buttons.add(b10);
		buttons.add(b11);
		buttons.add(b20);
		buttons.add(b21);
		

		JPanel spacerTop = new JPanel();		
		JPanel spacerBottom = new JPanel();		
		JPanel spacerLeft = new JPanel();		
		JPanel spacerRight = new JPanel();		
		spacerTop.setBackground(Color.BLACK);
		spacerBottom.setBackground(Color.BLACK);
		spacerLeft.setBackground(Color.BLACK);
		spacerRight.setBackground(Color.BLACK);
		spacerTop.setPreferredSize(new Dimension(100,50));	
		spacerBottom.setPreferredSize(new Dimension(100,50));
		spacerLeft.setPreferredSize(new Dimension(100,100));
		spacerRight.setPreferredSize(new Dimension(100,100));
		


		Container pane = this.getContentPane();		
		pane.setBackground(Color.BLACK);		
		pane.add(spacerTop, BorderLayout.NORTH);
		pane.add(spacerBottom, BorderLayout.SOUTH);
		pane.add(spacerLeft, BorderLayout.WEST);
		pane.add(spacerRight, BorderLayout.EAST);
		pane.add(buttons, BorderLayout.CENTER);

		this.setContentPane(pane);	
		this.setSize(500,500); 									
		this.setResizable(true); 								
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise02 app = new Exercise02("Iconic Buttons!");
	}

}
