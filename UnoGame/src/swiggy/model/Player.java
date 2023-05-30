package swiggy.model;

import java.util.List;
import java.util.ArrayList;

public class Player {
	private int id;
	private String name;
	private List<Card> hands;
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.hands = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Card> getHands() {
		return hands;
	}
	
	public void drawCard(Card card) {
		hands.remove(card);
		
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}
	
	public void addCard(Card card) {
		hands.add(card);
	}
	
	public boolean playCard(Game game) {
		
		if(game.getCurrentCard().isSpecialCard()) {
			game.getCurrentCard().performAction(game);;
			return true;
		}
			
			
		
		return false;
	}
	
	public boolean hasCardValid(Card currentCard, Card card) {
		return currentCard.getColor().equals(card.getColor()) || currentCard.getValue().equals(card.getValue()); 
	}
}
