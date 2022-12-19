package professorCode;

import javafx.application.Platform;
import sharedCode.AddLocation;
import sharedCode.GameAction;
import sharedCode.SharedGameData;

import java.util.Objects;

public abstract class AbstractGameManager <D extends  AbstractDictionary, T extends TurnParserV2> {

    private String teamName;
    private SharedGameData currentGameData;
    private IOManager ioManager;


    public AbstractGameManager(String teamName, IOManager ioManager) {

        if(Objects.isNull(teamName) || teamName.trim().isEmpty()){
            throw new IllegalArgumentException("The team name may not be null nor blank");
        }
        Objects.requireNonNull(ioManager, "The IO Manager must not be null");

        this.teamName = teamName;
        this.ioManager = ioManager;

    }

    public String getTeamName(){
        return teamName;
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
    public abstract void onTurn(String fragment);

    /**
     * This method is invoked immediately after your onTurn function has successfully completed. This is
     * where you should update your GUI with the necessary graphical changes.
     *
     * This function is executed on the GUI thread.
     *
     * @param fragment The current ordered collection of letters that have been played in the game.
     */
    public abstract void updateGUI(String fragment);

    /**
     * Invoke this method when ever you want to submit a letter to be played in the game. By passing it a turn
     * data object it will write that information to the shared game file. Make sure you only call this
     * function when it is your turn or else your application will be writing information when it is not your
     * turn. Call this function in your button listener.
     *
     * @param TurnData An object that contains information about letter and location you would like to play.
     */
    public void submitTurn(TurnData turnData){
        try{

            Objects.requireNonNull(turnData, "onTurn() is returning a null value");

            AddLocation location = turnData.isAddFront() ? AddLocation.Front : AddLocation.Back;

            GameAction action = new GameAction(location, turnData.getLetter(), this.teamName);

            currentGameData.addAction(action);

            ioManager.write(currentGameData);

        } catch (Throwable e) {
            System.err.println("_______["+this.teamName+"] Error submitTurn()_______");
            e.printStackTrace();
        }

    }

    public void makeTurn(SharedGameData currentGameData, String fragment) {
        this.currentGameData = currentGameData;

        try {

            onTurn(fragment);
            internalUpdateGUI(fragment);

        } catch (Throwable e) {
            System.err.println("_______[" + teamName + "] Error onTurn()_______");
            e.printStackTrace();
        }
    }

    private void internalUpdateGUI(String fragment){
        Platform.runLater(() ->{
            try {
                updateGUI(fragment);
            }catch (Throwable e) {
                System.err.println("_______[" + teamName + "] Error updateGUI()_______");
                e.printStackTrace();
            }
        });
    }

}
