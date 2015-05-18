package epam.com.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import epam.com.game.players.Computer;
import epam.com.game.players.Human;
import epam.com.game.players.Player;

public class Game {

	public ArrayList<Player> players;

	public boolean prepareGame(int hum, int com) {
		if ((hum > 0) && (hum + com >= 2) && (hum + com <= 20)) {
			players = new ArrayList<Player>();
			Scanner name = new Scanner(System.in);
			for (int i = 0; i < hum; i++) {
				System.out.println("Enter the name of the " + (int) (i + 1)
						+ " player :");
				players.add(new Human(name.next()));
			}
			for (int j = 0; j < com; j++) {

				players.add(new Computer("Computer"));
			}
			System.out.println("Let's start !");
			Collections.shuffle(players);
			return true;
			
		} else {
			System.out
					.println("Not enough players (or too many) to start the game!");
			return false;
		}
	}

	public void theGame() {
		int i = 0;
		while (i < Player.cit.size()) {
			for (Player player : players) {

				if (player instanceof Human) {
					System.out.println("The player "
							+ ((Human) player).getHumanname() + " answers: ");
					((Human) player).giveAnAnswer();

				} else {
					System.out.println("The player "
							+ ((Computer) player).getCompname() + " answers: ");
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(((Computer) player).giveAnAnswer());
				}

			}
		}
		i++;
	}

	public void endGame() {

	}
}
