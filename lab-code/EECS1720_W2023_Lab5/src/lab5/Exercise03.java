package lab5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


public class Exercise03 extends JFrame {

	public Exercise03(String title) {
		super(title);
		
		Container pane = this.getContentPane();
		
		JPanel leftTitle = new JPanel();
		leftTitle.setLayout(new BoxLayout(leftTitle, BoxLayout.X_AXIS));		
		JLabel labelABC = new JLabel("Choose 1 from Group A,B,C");
		labelABC.setFont(new Font(labelABC.getFont().getName(), Font.BOLD, labelABC.getFont().getSize()));	
		leftTitle.add(labelABC);

		JPanel optionA = new JPanel();
		optionA.setLayout(new BoxLayout(optionA, BoxLayout.X_AXIS));
		JRadioButton buttonA = new JRadioButton();
		JLabel iconA = new JLabel(new ImageIcon("src/icons/stock_market.png"));
		JLabel labelA = new JLabel("Option A");		
		optionA.add(buttonA); 
		optionA.add(iconA); 
		optionA.add(labelA);
		

		JPanel optionB = new JPanel();
		optionB.setLayout(new BoxLayout(optionB, BoxLayout.X_AXIS));
		JRadioButton buttonB = new JRadioButton();
		JLabel iconB = new JLabel(new ImageIcon("src/icons/stats_pie_chart.png"));
		JLabel labelB = new JLabel("Option B");
		optionB.add(buttonB); 
		optionB.add(iconB); 
		optionB.add(labelB);
		

		JPanel optionC = new JPanel();
		optionC.setLayout(new BoxLayout(optionC, BoxLayout.X_AXIS));
		JRadioButton buttonC = new JRadioButton();	
		JLabel iconC = new JLabel(new ImageIcon("src/icons/stats_histogram.png"));
		JLabel labelC = new JLabel("Option C");
		optionC.add(buttonC); 
		optionC.add(iconC); 
		optionC.add(labelC);
		

		ButtonGroup group = new ButtonGroup();
		group.add(buttonA);
		group.add(buttonB);
		group.add(buttonC);
		buttonC.setSelected(true);
	

		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(300,400));
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setAlignmentX(SwingConstants.CENTER);
		leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		leftPanel.add(leftTitle);
		leftPanel.add(optionA);
		leftPanel.add(optionB);
		leftPanel.add(optionC);
		pane.add(leftPanel, BorderLayout.WEST);
		

		JPanel rightTitle = new JPanel();
		rightTitle.setLayout(new BoxLayout(rightTitle, BoxLayout.X_AXIS));
		JLabel labeliiiiii = new JLabel("Choose 1 from Group i,ii,iii");
		labeliiiiii.setFont(new Font(labeliiiiii.getFont().getName(), Font.BOLD, labeliiiiii.getFont().getSize()));
		rightTitle.add(labeliiiiii);
		

		JPanel optionI = new JPanel();
		optionI.setLayout(new BoxLayout(optionI, BoxLayout.X_AXIS));
		JRadioButton buttonI = new javax.swing.JRadioButton();
		JLabel iconI = new JLabel(new ImageIcon("src/icons/stats_area_chart.png"));
		JLabel labelI = new JLabel("Option (i)");
		optionI.add(buttonI);
		optionI.add(iconI);
		optionI.add(labelI);
		
		JPanel optionII = new JPanel();
		optionII.setLayout(new BoxLayout(optionII, BoxLayout.X_AXIS));
		JRadioButton buttonII = new JRadioButton();
		JLabel iconII = new JLabel(new ImageIcon("src/icons/solution2.png"));
		JLabel labelII = new JLabel("Option (ii)");
		optionII.add(buttonII);
		optionII.add(iconII);
		optionII.add(labelII);

		JPanel optionIII = new JPanel();
		optionIII.setLayout(new BoxLayout(optionIII, BoxLayout.X_AXIS));
		JRadioButton buttonIII = new JRadioButton();
		JLabel iconIII = new JLabel(new ImageIcon("src/icons/solution.png"), JLabel.LEFT);
		JLabel labelIII = new JLabel("Option (iii)");
		optionIII.add(buttonIII);
		optionIII.add(iconIII);
		optionIII.add(labelIII);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(buttonI);
		group2.add(buttonII);
		group2.add(buttonIII);
		buttonII.setSelected(true);
	

		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(300,400));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setAlignmentX(SwingConstants.CENTER);
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		rightPanel.add(rightTitle);
		rightPanel.add(optionI);
		rightPanel.add(optionII);
		rightPanel.add(optionIII);
		pane.add(rightPanel, BorderLayout.EAST);
		
		

		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(100,500));
		pane.add(spacer, BorderLayout.CENTER);

		pane.add(Box.createRigidArea(new Dimension(50,50)), BorderLayout.NORTH);
		
		this.setContentPane(pane);
		
		setSize(750,500);									 
		setResizable(true);									
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);									
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise03 frame = new Exercise03("");
	}

}
