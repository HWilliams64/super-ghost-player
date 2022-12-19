package professorCode;

import sharedCode.SharedGameData;

public interface TurnParserV2 {

	/**
	 * True iff the current GameState of the specified ShareGameData is equal to IS_OVER
	 * @param shareGameData the data to be tested
	 * @return True means the specified ShareGameData indicates the game is over
	 */
	public boolean isGameOver(SharedGameData shareGameData);
	
	/**
	 * True iff the specified ShareGameData is not null
	 * @param shareGameData the data to be tested
	 * @return True means the game has begun
	 */
	public boolean isGameStarted(SharedGameData shareGameData);
	
	/**
	 * True iff the current GameState of the specified ShareGameData is equal to IS_TURN, the 
	 * receiver of the state is equal to myTeamName and the last GameAction's owner is not 
	 * equal to myTeamName (or there are no game actions) 
	 * @param shareGameData the data to be tested
	 * @return True means it my time to play
	 */
	public boolean isMyTurn(String myTeamName, SharedGameData shareGameData);
	
	/**
	 * True iff the current GameState of the specified ShareGameData is equal to IS_TURN, the 
	 * receiver of the state is not equal to myTeamName 
	 * @param shareGameData the data to be tested
	 * @return True means its the other team's turn
	 */
	public boolean isOtherPlayersTurn(String myTeamName, SharedGameData shareGameData);
	
	/**
	 * True iff the current GameState of the specified ShareGameData is equal to IS_TURN, the 
	 * receiver of the state is not equal to myTeamName and the last GameAction's owner is not 
	 * equal to myTeamName (or there are no game actions) 
	 * @param shareGameData the data to be tested
	 * @return True means its the other team's turn
	 */
	public boolean isOtherPlayersTurnFinished(String myTeamName, SharedGameData shareGameData);
}
