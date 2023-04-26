package music;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("removal")
public class MusicPlayer{
	 static  AudioClip ac=null;
	 public static void musicplay() {
		  URL url = null;
		  File f1 = new File("src/bgm1.wav");
		//  File f1 = new File("music/bgm_track5_loop.wav");
		     try {
		      url= f1.toURL();
		   } catch (MalformedURLException e) {      
		   e.printStackTrace();
		   } 
		     ac= Applet.newAudioClip(url);
		     ac.loop();
	 }
	 public MusicPlayer(){
		 run();
	 }
	public static void run(){
	     JFrame frame = new JFrame();
	     frame.setSize(300,300);
	     frame.setLocation(700,100);
	     Font t=new Font("Helvetica",Font.BOLD,30);
			JButton bt1 = new JButton("Play");
			bt1.setFont(t);
			bt1.setForeground(Color.black);
			bt1.setBackground(Color.white);
			bt1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ac.loop();
				}
			});
			JButton bt2 = new JButton("Pause");
			bt2.setFont(t);
			bt2.setForeground(Color.black);
			bt2.setBackground(Color.white);
			bt2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ac.stop();
				}
			});
			JPanel panel = new JPanel();
			panel.add(bt1);
			panel.add(bt2);
			frame.add(panel, BorderLayout.CENTER);
			frame.setSize(300, 300);
			frame.setVisible(true);
	    }  
}