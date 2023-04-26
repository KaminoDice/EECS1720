package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import model.User;
import model.UserInfo;
import view.GameMenu;

public class UserMenuListener implements ActionListener {
	static GameMenu g = new GameMenu();
	private String filePath;
	JTextArea text = new JTextArea();
	UserInfo use = new UserInfo();
	JFrame jf = new JFrame("Rank");
	JPanel p = new JPanel();
	Font font = new Font("Serif", 0, 56);
	Object[][] rowData = new Object[10][10];
	
	public void begin(JFrame f) {
		g.showGameMenu();
		f.dispose();
	}

	public void range() {
		
		JPanel panel = new JPanel(new BorderLayout());
		jf.setLayout(new BorderLayout());

		Object[] columnNames = { "Nickname", "Score" };

		use.userList.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				int result = 0;
				try {
					result =o2.getScore()-o1.getScore();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
			}

		});
		for (int i = 0; i < use.userList.size(); i++) {
			System.out.println(use.userList.get(i).toString());
			rowData[i][0] = use.userList.get(i).getName();
			rowData[i][1] = use.userList.get(i).getScore();

		}

		JTable table = new JTable(rowData, columnNames);

		table.getTableHeader().setFont(font);
		table.getTableHeader().setBackground(Color.YELLOW);

		panel.add(table.getTableHeader(), BorderLayout.NORTH);

		panel.add(table, BorderLayout.CENTER);
		JLabel label1 = new JLabel("Rank");
		label1.setFont(font);

		p.add(label1);
		jf.add(p, BorderLayout.NORTH);
		jf.add(panel, BorderLayout.CENTER);
		jf.pack();
		jf.setBounds(0, 150, 600, 600);
		jf.setLocation(275, 50);
		jf.setVisible(true);

	}

	public void rule() {
		JFrame j = new JFrame();
		getFilePath();
		readFile(filePath);
		j.add(text);
		Font x = new Font("Serif", 0, 25);
		text.setFont(x);
		
		JScrollPane jsp = new JScrollPane(text);
		jsp.setBounds(13, 10, 350, 340);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		j.add(jsp);

		j.setTitle("Rules");
		j.setSize(1100, 700);
		j.setLocation(275, 25);
		j.setLocationRelativeTo(null);
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		j.setVisible(true);

	}

	private void getFilePath() {
		filePath = "src/unoRule.txt";
	}

	private void readFile(String fp) {
		FileReader fr = null;
		BufferedReader in = null;

		try {
			fr = new FileReader(fp);
			in = new BufferedReader(new InputStreamReader(new FileInputStream(fp), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				text.append(str + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
