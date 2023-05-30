package swiggy.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Card {
	
	@Override
	public int hashCode() {
		return Objects.hash(color, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(color, other.color) && Objects.equals(value, other.value);
	}

	private String color;
	private String value;
	private Scanner sc;
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isSpecialCard() {
		return value.equals("skip") || value.equals("reverse") || value.equals("draw two") || value.equals("wild") || value.equals("wild draw four");
	}
	
	public void performAction(Game game) {
		switch(game.getCurrentCard().value) {
			case "skip":{
				game.nextTurn();
				break;
			}
			case "reverse" :{
				int id= game.getCurrentPlayer().getId();
				Collections.reverse(game.getPlayers());
				int i=0;
				for(Player p: game.getPlayers()) {
					if(p.getId()==id) {
						break;
					}
					i++;
				}
				game.setCurrentPlayerIndex(i);
				break;
			}
			case "draw two":{
				game.nextTurn();
				game.getCurrentPlayer().addCard(game.drawCard());
				game.getCurrentPlayer().addCard(game.drawCard());
				break;
			}
			case "wild draw four" :{
				game.nextTurn();
				game.getCurrentPlayer().addCard(game.drawCard());
				game.getCurrentPlayer().addCard(game.drawCard());
				game.getCurrentPlayer().addCard(game.drawCard());
				game.getCurrentPlayer().addCard(game.drawCard());
				System.out.println("For wild draw four card, please choose following color");
				String color=null;
				
				while(true) {
					System.out.println("1. Blue");
					System.out.println("2. Red");
					System.out.println("3. Green");
					System.out.println("4. Yellow");
					String input= sc.next();
					switch(input) {
						case "1":{
							color="Blue";
							break;
						}
						case "2":{
							color="Red";
							break;
						}
						case "3":{
							color="Green";
							break;
						}
						case "4":{
							color="Yellow";
							break;
						}
						
					}
					if(color!=null) {
						break;
					}
					else {
						System.out.println("You are choosen wrong color option, please try again");
					}
				}
				game.getCurrentCard().setColor(color);
				break;
			}
			case "wild" :{
				game.nextTurn();
				game.getCurrentPlayer().addCard(game.drawCard());
				game.getCurrentPlayer().addCard(game.drawCard());
				System.out.println("For wild card, please choose following color");
				String color=null;
				
				while(true) {
					System.out.println("1. Blue");
					System.out.println("2. Red");
					System.out.println("3. Green");
					System.out.println("4. Yellow");
					String input= sc.next();
					switch(input) {
						case "1":{
							color="Blue";
							break;
						}
						case "2":{
							color="Red";
							break;
						}
						case "3":{
							color="Green";
							break;
						}
						case "4":{
							color="Yellow";
							break;
						}
						
					}
					if(color!=null) {
						break;
					}
					else {
						System.out.println("You are choosen wrong color option, please try again");
					}
				}
				game.getCurrentCard().setColor(color);
				break;
			}
		}
	}

	public Card(String color, String value) {
		super();
		this.color = color;
		this.value = value;
		sc = new Scanner(System.in);
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", value=" + value + "]";
	}
	
	
	
}
