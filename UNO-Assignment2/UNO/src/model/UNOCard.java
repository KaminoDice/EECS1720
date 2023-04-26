package model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import interfaces.CardConstants;

public class UNOCard extends JPanel implements CardConstants{

	private Color cardColor = null;
	private String value = null;
	private int type = 0;
	private Border defaultBorder = BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.white, Color.gray);
	private Border focusedBorder = BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.black, Color.gray);
	private Color chosenColor;
	
	public void WildCard() {
	}
	
	
//	public void WildCard(String cardValue){
//		super(BLACK, WILD, cardValue);		
//	}
	
	public void useWildColor(Color wildColor){
		chosenColor = wildColor;
	}
	
	public Color getWildColor(){
		return chosenColor;
	}

	
	public Color getCardColor() {
		return cardColor;
	}
	public void setCardColor(Color cardColor) {
		this.cardColor = cardColor;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public UNOCard() {
		
	}
	public UNOCard(Color cardColor, String value, int type) {
		this.cardColor = cardColor;
		this.value = value;
		this.type = type;
	}
	public UNOCard(Color cardColor, String cardValue) {
		this.cardColor = cardColor;
		this.value = cardValue;

		this.setPreferredSize(CARDSIZE);
		this.setBorder(defaultBorder);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		int cardWidth = CARDSIZE.width;//100
		int cardHeight = CARDSIZE.height;//150

		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, cardWidth, cardHeight);

		int margin = 5;
		g2.setColor(cardColor);
		g2.fillRect(margin, margin, cardWidth - 2 * margin, cardHeight - 2 * margin);

		g2.setColor(Color.white);
		AffineTransform org = g2.getTransform();
		g2.rotate(45, cardWidth * 3 / 4, cardHeight * 3 / 4);

		g2.fillOval(0, cardHeight * 1 / 4, cardWidth * 3 / 5, cardHeight);
		g2.setTransform(org);

		// Value in the center
		Font defaultFont = new Font("Helvetica", Font.BOLD, cardWidth / 2 + 5);
		FontMetrics fm = this.getFontMetrics(defaultFont);
		int StringWidth = fm.stringWidth(value) / 2;
		int FontHeight = defaultFont.getSize() * 1 / 3;

		g2.setColor(cardColor);
		g2.setFont(defaultFont);
		g2.drawString(value, cardWidth / 2 - StringWidth, cardHeight / 2 + FontHeight);

		// Value in the corner
		defaultFont = new Font("Helvetica", Font.ITALIC, cardWidth / 5);
		fm = this.getFontMetrics(defaultFont);
		StringWidth = fm.stringWidth(value) / 2;
		FontHeight = defaultFont.getSize() * 1 / 3;

		g2.setColor(Color.white);
		g2.setFont(defaultFont);
		g2.drawString(value, 2 * margin, 5 * margin);
	}


}
