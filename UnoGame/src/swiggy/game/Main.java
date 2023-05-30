package swiggy.game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import swiggy.model.Game;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game= new Game();
		List<String> players= new ArrayList<>();
		int i=1;
		while(true) {
			System.out.println("Enter "+ i +" player name");
			players.add(sc.next());
			if(i>=2) {
				System.out.println("There have more player(s):- yes/no");
				String input= sc.next();
				if(input.equalsIgnoreCase("no")) {
					break;
				}
			}
			i++;
		}
		game.startTheGame(players);
		
		while(true) {
			if(game.playCard(game))
				break;
		}
		
	}
}
