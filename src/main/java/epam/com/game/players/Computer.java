package epam.com.game.players;

public class Computer extends Player {
	private String compname;
	static int count;
	
	public Computer(String compname) {
		super();
		count++;
		setCompname(compname);
		
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname+count;
	}


	@Override
	public String toString() {
		return "Computer [compname=" + compname + "]";
	}

	@Override
	public String giveAnAnswer() {
		checkTheWord(lastWord);
		return lastWord;

	}

	@Override
	public boolean checkTheWord(String citName) {
		if (lastWord==null) {
			lastWord = cit.get(0 + (int)(Math.random() * (((cit.size()-1) - 0) + 1)));
			cit.remove(lastWord);	
		} else {
			String lastLetter = lastWord.substring(lastWord.length()-1);
			for (String cits : cit) {
				if (lastLetter.toUpperCase().equals(Character.toString(cits.charAt(0)).toUpperCase())) {
					lastWord = cits;
					cit.remove(cits);
					break;
				}
		}
		
	}
		return true;
	}
	
}
