package model;

import java.util.LinkedList;

import model.UNOCard;

public class Player {
	
	private User user=new User();
	static String playername;
	static int playerscore;
	static String playpassword;
	
	private String name = null;
	private String password=null;
	private int score=0;
	private boolean isMyTurn = false;
	private boolean saidUNO = false;
	private LinkedList<model.UNOCard> myCards;
	
	private int playedCards = 0;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public Player(User user) {
		playername=user.getName();
		playerscore=user.getScore();
		playpassword=user.getPassword();
	}
	
	public Player(){
		setName(playername);
		setScore(playerscore);
		setPassword(playpassword);
		myCards = new LinkedList<UNOCard>();
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getName(){
		return this.name;
	}
	public void obtainCard(UNOCard card){
		myCards.add(card);
	}
	
	public LinkedList<UNOCard> getAllCards(){
		return myCards;
	}
	
	public int getTotalCards(){
		return myCards.size();
	}
	
	public boolean hasCard(UNOCard thisCard){
		return myCards.contains(thisCard);		
	}
	
	public void removeCard(UNOCard thisCard){
		myCards.remove(thisCard);
		playedCards++;
	}
	
	public int totalPlayedCards(){
		return playedCards;
	}
	
	public void toggleTurn(){
		isMyTurn = (isMyTurn) ? false : true;
	}
	
	public boolean isMyTurn(){
		return isMyTurn;
	}
	
	public boolean hasCards(){
		return (myCards.isEmpty()) ? false : true;
	}
	
	public boolean getSaidUNO(){
		return saidUNO;
	}
	
	public void saysUNO(){
		saidUNO = true;
	}
	
	public void setSaidUNOFalse(){
		saidUNO = false;
	}
	
	public void setCards(){
		myCards = new LinkedList<UNOCard>();
	}
}