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
		hands.add(card)
	}
	
	
	//playcard
	//received and apply special card
	//check player is valid or not
	
	
	
}
