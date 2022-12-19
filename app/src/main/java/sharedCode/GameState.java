package sharedCode;

import java.io.Serializable;
import java.util.Objects;

public class GameState implements Serializable{

	private static final long serialVersionUID = 3331061479141462297L;
	private final boolean IS_TURN, IS_OVER;
	private final String RECEIVER; //Either team name or both
	public final static String BOTH = "BOTH";
	
	public GameState(GameState gameState) {
		this(gameState.IS_OVER, gameState.IS_TURN, gameState.RECEIVER);
	}

	public GameState(boolean isOver, boolean isTurn, String receiver) {
		IS_TURN = isTurn;

		IS_OVER = isOver;

		RECEIVER = receiver;
	}

	public boolean isOver() {
		return IS_OVER;
	}

	public boolean isTurn() {
		return IS_TURN;
	}

	public String getReceiver() {
		return RECEIVER;
	}

	@Override
	public String toString() {
		return "GameState: {isOver:"+IS_OVER+", isTurn:"+IS_TURN+", Receiver:"+RECEIVER+"}";
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof GameState) {
			GameState other = (GameState) obj;
			
			return Objects.equals(this.IS_OVER, other.IS_OVER) && Objects.equals(this.IS_TURN, other.IS_TURN) && Objects.equals(this.RECEIVER, other.RECEIVER);
		}
		
		return false;
	}
}
