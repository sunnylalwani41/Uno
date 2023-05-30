package swiggy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards=new ArrayList<>();
		initializeCard();
		shuffleCard();
	}
	public void initializeCard() {
		for(String color: CardColor.COLORS) {
			cards.add(new Card(color, "0"));
			cards.add(new Card(color, "0"));
			for(int i=1; i<=9; i++) {
				cards.add(new Card(color, String.valueOf(i)));
				cards.add(new Card(color, String.valueOf(i)));
			}
			cards.add(new Card(color, "1"));
			cards.add(new Card(color, "2"));
			cards.add(new Card(color, "3"));
			cards.add(new Card(color, "skip"));
			cards.add(new Card(color, "reverse"));
			cards.add(new Card(color, "draw two"));
			cards.add(new Card(color, "wild draw four"));
			cards.add(new Card(color, "wild"));
			
		}
	}
	public void shuffleCard() {
		Collections.shuffle(cards);
	}
	public Card drawCard() {
		if(cards.isEmpty()) {
			replanish();
		}
		return cards.remove(0);
	}
	public void replanish() {
		initializeCard();
		shuffleCard();
	}
}
