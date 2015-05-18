package epam.com.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import epam.com.game.parsfactory.FactoryBuilder;
import epam.com.game.players.Player;

public class GameRunner {

	public static void main(String[] args) {
		int humannum;
		int compnum;
		
		Game runner = new Game();
		try {
		Player.cit = FactoryBuilder.createCitiesBuilder("DB");
		Scanner playernum = new Scanner(System.in);
		//System.out.println(Player.cit.size());

			System.out.println("Enter the number of players HUMANS:");
			humannum = playernum.nextInt();
			System.out.println("Enter the number of players COMPUTERS:");
			compnum = playernum.nextInt();
			if(runner.prepareGame(humannum, compnum)) runner.theGame();
			playernum.close();
			
			
		} catch (InputMismatchException e) {
			System.err.print("You must enter the number of players!");
		} catch (IllegalArgumentException ex) {
			System.err.print("Unknown parser!");
		}
	}

}
