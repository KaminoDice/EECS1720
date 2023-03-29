package lectures.week09.actionevents2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;


public class ScrollingTextField extends JFrame {

	private final JTextField textField;
	private JScrollBar scrollBar;

	public ScrollingTextField(String title)  {

		super(title);

		this.textField = new JTextField();
		this.textField.addActionListener(new MyActionListener());
		
		this.scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
	
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		BoundedRangeModel brm = textField.getHorizontalVisibility();
		scrollBar.setModel(brm);
		
		
		panel.add(textField);
		panel.add(scrollBar);

		this.add(panel, BorderLayout.NORTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 100);
		this.setVisible(true);
		
	

	}


	
	private class MyActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Text: " + textField.getText());
		}
		
	}



	public static void main(String[] args) {
		
		ScrollingTextField frame  =  new ScrollingTextField("Scrolling TextEntry");

	}

	
}
