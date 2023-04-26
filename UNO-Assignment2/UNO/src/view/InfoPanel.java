package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	
	private String error;
	private String text;
	private int panelCenter;
	
	private int you = 0;
	private int pc = 0;
	private int rest = 0;
	Font font1 = new Font("Calibri", Font.BOLD,	25);	
	Font font2 = new Font("Calibri", Font.PLAIN,25);
	Font font3 = new Font("Calibri", Font.PLAIN,20);
	public InfoPanel(){
		setPreferredSize(new Dimension(300,200));
		setOpaque(true);
		error = "";
		text = "Game Started";
		
		updateText(text);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		panelCenter = getWidth()/2;
		
		printMessage(g);
		printError(g);
		printDetail(g);
	}

	
	private void printError(Graphics g) {
		if(!error.isEmpty()){
			
			
			//Determine the width of the word to position
			FontMetrics fm = this.getFontMetrics(font2);
			int xPos = panelCenter - fm.stringWidth(error) / 2;
			
			g.setFont(font2);
			g.setColor(Color.red);
			g.drawString(error, xPos, 35);
			
			error = "";
		}
	}

	private void printMessage(Graphics g) {
		
		
		//Determine the width of the word to position
		FontMetrics fm = this.getFontMetrics(font1);
		int xPos = panelCenter - fm.stringWidth(text) / 2;
		
		g.setFont(font1);
		
		g.setColor(new Color(228,108,10));
		g.drawString(text, xPos, 75);		
	}
	
	private void printDetail(Graphics g){
		
		FontMetrics fm = this.getFontMetrics(font1);
		g.setColor(new Color(127,127,127));
		
		//Determine the width of the word to position
		String text = "Played Cards";
		int xPos = panelCenter - fm.stringWidth(text) / 2;
		
		g.setFont(font1);
		g.drawString(text, xPos, 120);
		
		text = "Remaining: " + rest;
		xPos = panelCenter - fm.stringWidth(text) / 2;
		g.drawString(text, xPos, 180);
		
		//Details
		g.setFont(font3);
		fm = this.getFontMetrics(font3);
		
		text = "You : "+you + "  PC : " + pc;
		xPos = panelCenter - fm.stringWidth(text) / 2;
		g.drawString(text, xPos, 140);
		
		text = String.valueOf(rest);
		xPos = panelCenter - fm.stringWidth(text) / 2;
	}

	public void updateText(String newText) {
		text = newText;
	}
	
	public void setError(String errorMgs){
		error = errorMgs;
	}
	
	public void setDetail(int[] playedCards, int remaining){
		you = playedCards[1];
		pc = playedCards[0];
		rest = remaining;
	}
}
