package studentCode;

import javafx.stage.Stage;
import professorCode.*;

/**
 * This class is your application's brain. It will be used by the GhostSkeleton class to get letter
 * and location of the letter for each game turn. 
 * 
 * 
 * @author Student
 *
 */
public class GameManager extends AbstractGameManager {

	/**
	 * This constructor is called once at the start of the game you are given The java fx stage, your IO Manager
	 * object you initialized in the Game Manager class, your team name (The file name of you jar file), the
	 * minimum word length of the game (This will not change during the game), and the dictionary you created
	 * in the Game Manager class.
	 *
	 * Use this function to setup all your GUI widgets and draw them on the stage. Additionally initialize any
	 * classes or variables needed so that your application may effectively play the ghost game.
	 *
	 * Its recommended that assign the primaryStage, minWordLength and dictionary to local class variables
	 * so you may access them in the onTurn function which will be called during the game.
	 *
	 * @param primaryStage
	 * @param ioManager
	 * @param teamName
	 * @param minWordLength
	 * @param dictionary
	 */
	public GameManager(Stage primaryStage, IOManager ioManager, String teamName, int minWordLength, AbstractDictionary dictionary) {
		super(teamName, ioManager);


	}

	/**
	 * This method is called every time it is your turn. You are given the current word fragment
	 * of the game. In this method you will figure out the next letter and the location of the
	 * letter to be played.
	 *
	 * This function is NOT executed on the GUI thread, do not make any changes to your GUI in this
	 * function.
	 *
	 * @param fragment The current ordered collection of letters that have been played in the game.
	 */
	@Override
	public void onTurn(String fragment) {

		/*
		 * The user has to press the button to submit a turn data it would be illegal to do this in the actual game.
		 * this is only here for example proposes.
		 */
		TurnData turnData = TurnData.create(getTeamName(), null, null);
		submitTurn(turnData);
	}

	/**
	 * This method is invoked immediately after your onTurn function has successfully completed. This is
	 * where you should update your GUI with the necessary graphical changes.
	 *
	 * This function is executed on the GUI thread.
	 *
	 * @param fragment The current ordered collection of letters that have been played in the game.
	 */
	public void updateGUI(String fragment){

	}


}
