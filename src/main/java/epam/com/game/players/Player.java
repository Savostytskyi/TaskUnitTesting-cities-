package epam.com.game.players;

import java.util.ArrayList;

public abstract class Player {

	public static ArrayList<String> cit;
	public static String lastWord;

	public abstract String giveAnAnswer();

	public abstract boolean checkTheWord(String citName);

}
