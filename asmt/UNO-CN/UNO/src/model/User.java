package model;

import javax.swing.JOptionPane;

public class User{
	private String name;
	private String password;
	private int score;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", score=" + score + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String password, int userScore) {
		super();
		this.name = name;
		this.password = password;
		this.score = userScore;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
