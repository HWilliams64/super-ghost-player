package sharedCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SharedGameData implements Serializable {

	private static final long serialVersionUID = 2268785397428687506L;

	private final List<GameAction> ACTION_RECORD;
	
	private GameState gameState; 
	
	public SharedGameData(SharedGameData shareGameData) {
		this();
		
		shareGameData.ACTION_RECORD.forEach(a -> {
			ACTION_RECORD.add(new GameAction(a));
		});
		
		this.gameState = new GameState(shareGameData.gameState);
	}
	
	public SharedGameData() {
		ACTION_RECORD = new ArrayList<>();
	}
	
	public void addAction(GameAction gameAction) {
		ACTION_RECORD.add(gameAction);
	}
	
	public List<GameAction> gameActions(){
		return new ArrayList<>(ACTION_RECORD);
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public String toString() {
		
		String toRet = "";
		
		toRet = getClass().getSimpleName()+":{\n"+
		"\tGame State:"+gameState+"\n"+
		"\tGame Actions:"+ACTION_RECORD+"\n"+
		"}";
		
		return toRet;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof SharedGameData) {
			
			SharedGameData other = (SharedGameData) obj;
			
			return Objects.equals(other.ACTION_RECORD, this.ACTION_RECORD) && Objects.equals(other.gameState, this.gameState);
			
		}
		
		return false;
	}
}
