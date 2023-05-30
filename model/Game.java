package swiggy.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Player> players;
	private Deck deck;
	private int currentPlayerIndex;
	private Card currentCard;
	
	public Game() {
		deck= new Deck();
		currentPlayerIndex=0;
		currentCard=null;
		players=new ArrayList<>();
				
	}
	
	public void startTheGame(List<String> playerNames) {
		
		int i=0;
		
		for(String name: playerNames) {
			players.add(new Player(i++, name));
		}
		
		int cardDistribute= numberOfCardDistribute();
		
		for(Player player: players) {
			for(int j=0; j<cardDistribute; j++) {
				Card card= deck.drawCard();
				player.addCard(card);
			}
		}
		
		currentPlayerIndex= determineDealer();
	}
	
	public int nextTurn() {
		currentPlayerIndex++;
		if(currentPlayerIndex==players.size())
			return 0;
		return currentPlayerIndex;
	}
	
	
	public boolean playCard(Card card) {
		if(currentCard==null || isCardValid(card)) {
			currentCard=card;
			getCurrentPlayer().drawCard(card);
			return true;
		}
		return false;
		
	}
	
	public int numberOfCardDistribute() {
		if(players.size()<=2) {
			return 7;
		}
		return 5;
	}
	
	public int determineDealer() {
		return (int) (Math.random()*players.size());
	}
	
	public boolean isCardValid(Card card) {
		if(currentCard==null || currentCard.getColor().equals(card.getColor()) || currentCard.getValue().equals(card.getValue())) {
			return true;
		}
		return false;
	}
	
	public Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}
	
	public boolean checkWinCondition() {
		return getCurrentPlayer().getHands().isEmpty();
	}
	
	public Player declareWinner() {
		if(checkWinCondition()) return getCurrentPlayer();
		return null;
	}
	
}