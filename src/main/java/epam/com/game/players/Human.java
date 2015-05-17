package epam.com.game.players;

import java.util.Scanner;



public class Human extends Player {
	private String humanname;

	
	
	public Human(String humanname) {
		super();
		setHumanname(humanname);
	}

	public Human() {
		// TODO Auto-generated constructor stub
	}

	public String getHumanname() {
		return humanname;
	}

	public void setHumanname(String humanname) {
		this.humanname = humanname;
	}
	
	

	@Override
	public String toString() {
		return "Human [humanname=" + humanname + "]";
	}


	@Override
	public String giveAnAnswer() {	
		Scanner city = new Scanner(System.in);
		String answer = city.next();		
		if(checkTheWord(answer)) return answer;
		else {
			System.out.println("We don't know this city. Please try againe:");
			giveAnAnswer();
		}
		return answer;
		}
	
	
	public boolean checkTheWord(String citName) {
		if (lastWord==null) {
		
			if (cit.contains(citName)) {
				lastWord = citName;
				cit.remove(citName);
				return true;
			} else return false;
		} else {
			String lastLetter = lastWord.substring(lastWord.length()-1);
			String firstLetter = Character.toString(citName.charAt(0));
			if ((lastLetter.toUpperCase().equals(Character.toString(citName.charAt(0)).toUpperCase())) && (cit.contains(citName))) {
				lastWord = citName;
				cit.remove(citName);
				return true;
			} else 	return false;
		}
	 }
	
	
}
