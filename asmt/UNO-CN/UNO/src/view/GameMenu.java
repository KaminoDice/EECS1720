package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.CardConstants;

public class GameMenu extends JFrame implements CardConstants{
	public JFrame frame = new JFrame("Game Menu");
    private JButton btn1 = new JButton("vs PC");
    private JButton btn2 = new JButton("1V1(Not completed)");
    private MyButton3 handler;
    
    public GameMenu()
	{
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void showGameMenu ()
	{
		frame.setLayout(null);
        frame.setSize(900, 700);
        frame.setLocation(250, 25);

        Font font = new Font("Helvetica", Font.BOLD, 40);
        

        btn1.setContentAreaFilled(false);
        btn1.setFont(font);
        btn1.setForeground(Color.BLUE);
        btn1.setBorder(BorderFactory.createRaisedBevelBorder());
        btn1.setFocusable(false);
        btn2.setContentAreaFilled(false);
        btn2.setFont(font);
        btn2.setBorder(BorderFactory.createRaisedBevelBorder());
        btn2.setForeground(Color.BLUE);
        btn2.setFocusable(false);
        JPanel bj = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Image bg;
                try {
                    bg = ImageIO.read(new File("web/img/game.png"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        btn1.setBounds(275, 400, 300, 80);
        btn2.setBounds(275, 530, 300, 80);
        
        frame.setContentPane(bj);
        frame.setLayout(null);
       
        frame.add(btn1);
        frame.add(btn2);
        
        handler = new MyButton3();
		btn1.addActionListener(MODELISTENER);
		btn1.addActionListener(handler);
		btn2.addActionListener(MODELISTENER);
		btn2.addActionListener(handler);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		 
	}
	class MyButton3 implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btn1)
				MODELISTENER.vsPc(frame);
			//else if (e.getSource() == btn2)
				//MODELISTENER.internet(frame);

		}
	}
	
}
