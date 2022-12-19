package sharedCode;

import java.io.Serializable;
import java.util.Objects;

public class GameAction implements Serializable {

	private static final long serialVersionUID = 2047788977792815347L;

	private final AddLocation ADD_LOCATION;
	
	private final char LETTER;
	
	private final String TEAM_NAME;
	
	public GameAction(GameAction gameAction) {
		this(gameAction.ADD_LOCATION, gameAction.LETTER, gameAction.TEAM_NAME);
	}

	public GameAction(AddLocation addLocation, char letter, String teamName) {
		Objects.requireNonNull(addLocation);
		Objects.requireNonNull(letter);
		Objects.requireNonNull(teamName);
		
		ADD_LOCATION = addLocation;
		LETTER = letter;
		TEAM_NAME = teamName;
	}
	
	public char getLetter() {
		return LETTER;
	}
	
	public AddLocation getAddLocation() {
		return ADD_LOCATION;
	}
	
	public String getOwner() {
		return TEAM_NAME;
	}
	
	@Override
	public String toString() {
		return "GAME ACTION: {Owner:"+TEAM_NAME+", Location:"+ADD_LOCATION+", Letter:"+LETTER+"}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GameAction) {
			
			GameAction other = (GameAction) obj;
			
			return Objects.equals(this.TEAM_NAME, other.TEAM_NAME) && Objects.equals(this.ADD_LOCATION, other.ADD_LOCATION) && Objects.equals(this.LETTER, other.LETTER);

		}
		
		return false;
	}
}
