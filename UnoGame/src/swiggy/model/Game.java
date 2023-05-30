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
	
	public Card getCurrentCard() {
		return this.currentCard;
	}
	
	public void setCurrentCard(Card card) {
		this.currentCard=card;
	}
	
	public Card drawCard() {
		return deck.drawCard();
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
		
		if(currentPlayerIndex==players.size()) {
			currentPlayerIndex=0;
		}
		return currentPlayerIndex;
	}
	
	
	public boolean playCard(Game game) {
		if(findCard()) {
			
			getCurrentPlayer().drawCard(getCurrentCard());
			System.out.println("Player: "+getCurrentPlayer());
			System.out.println("Current Card is: "+getCurrentCard());
			System.out.println("============================");
			if(declareWinner()!= null) {
				System.out.println("================**********================");
				System.out.println();
				System.out.println("Winner : "+getCurrentPlayer());
				System.out.println();
				System.out.println("================**********================");
				return true;
			}
			getCurrentPlayer().playCard(game);
			
		}
		else {
			getCurrentPlayer().addCard(deck.drawCard());
			
		}
		nextTurn();
		return false;
		
	}
	
	public boolean findCard() {
		List<Card> list= getCurrentPlayer().getHands();

		if(currentCard==null) {
			setCurrentCard(list.get(getCardIndex()));
			return true;
		}
		
		Card card =null;
		for(Card c: list) {
			if(isCardValid(c)) {
				card= c;
			}
		}
		if(card!=null) {
			setCurrentCard(card);
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
	
	public int getCardIndex() {
		return (int)Math.floor((Math.random()*getCurrentPlayer().getHands().size()));
	}
	
	public int determineDealer() {
		return (int) Math.floor((Math.random()*players.size()));
	}
	
	public boolean isCardValid(Card card) {
		if(currentCard==null || currentCard.getColor().equals(card.getColor()) || currentCard.getValue().equals(card.getValue())) {
			return true;
		}
		return false;
	}
	
	public List<Player> getPlayers() {
		return players;
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
	public void setCurrentPlayerIndex(int index) {
		this.currentPlayerIndex=index;
	}
}
