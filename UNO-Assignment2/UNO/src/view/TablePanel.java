package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import interfaces.CardConstants;
import model.UNOCard;

public class TablePanel extends JPanel implements CardConstants {
	
	private UNOCard topCard;	
	private JPanel table;
	
	public TablePanel(UNOCard firstCard){
		setOpaque(true);
	
		
		topCard = firstCard;
		table = new JPanel();
		table.setBackground(new Color(64,64,64));

		setTable();
		setComponents();
	}
	
	private void setTable(){
		
		table.setPreferredSize(new Dimension(150,195));
		table.setLayout(new GridLayout());
		table.add(topCard);
		
	}
	
	private void setComponents() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 50, 0, 50);
		add(table,c);
		
//		c = new GridBagConstraints();
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 1;
//		c.gridy = 0;
//		c.insets = new Insets(0, 0, 0, 0);
//		add(topCard,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(0, 1, 0, 1);
		add(INFO_PANEL, c);	
	}

	public void setPlayedCard(UNOCard playedCard){
		table.removeAll();
		topCard = playedCard;
		setTable();
		
		setBackgroundColor(playedCard);
	}
	
	public void setBackgroundColor(UNOCard playedCard){
		Color background;
		if(playedCard.getType()==WILD)
			background = playedCard.getWildColor();
		else
			background = playedCard.getCardColor();
		
		table.setBackground(background);
	}
}
