package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Player;
import model.User;
import model.UserInfo;
import view.UserMenu;

public class UserPanelListener implements ActionListener {

	String x = null;
	String y = null;

	public void enroll() {

		UserInfo info = new UserInfo();
		int flag = 0;
		String x = null;
		String y=null;
		while (x == null)
		{
			x = JOptionPane.showInputDialog("Set a Nickname:");
			if (x.equals( "") ) 
		     { 
		       JOptionPane.showMessageDialog(null, "Nikname:", "Error: ",JOptionPane.ERROR_MESSAGE); 
		       return ;
		      }
		}
			
		for (int i = 0; i < info.userList.size(); i++) {
			if (info.userList.get(i).getName().equals(x)) {
				flag = 1;
			}
		}
		if (flag == 1) {
			JOptionPane.showMessageDialog(null, "Exist name", "Warning: ", JOptionPane.INFORMATION_MESSAGE);
		} else {
			while (y == null)
			{
				 y = JOptionPane.showInputDialog("Set a Password:");
				if (y.equals( "") ) 
			     { 
			       JOptionPane.showMessageDialog(null, "Password:", "Error: ",JOptionPane.ERROR_MESSAGE); 
			       return ;
			      }
			}
			User user = new User(x, y, 0 );
			String s=x+" "+y+" 0";
			info.userList.add(user);
			info.method(s);
			JOptionPane.showMessageDialog(null, "Enroll Success");
		}

	}

	

	public void login(JTextField text1, JPasswordField text2, JFrame f) {
		UserInfo info = new UserInfo();
		int flag = 0;
		x = text1.getText().trim();
		y = text2.getText().trim();
		for (int i = 0; i < info.userList.size(); i++) {
			if (info.userList.get(i).getName().equals(x)) {
				if (info.userList.get(i).getPassword().equals(y)) {
					Player player=new Player(info.userList.get(i));
					JOptionPane.showMessageDialog(null, "Login Success", "Info:", JOptionPane.INFORMATION_MESSAGE);
					flag = 1;
					UserMenu menu = new UserMenu();
					f.setVisible(false);
					f.dispose();

				}
				flag = 1;
			}
		}
		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "User does't exsit", "Error: ", JOptionPane.PLAIN_MESSAGE);
			clearText(text1, text2);// ����ı��� ����������
		}

	}

	private void clearText(JTextField text1, JPasswordField text2) {
		text1.setText("");
		text2.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
