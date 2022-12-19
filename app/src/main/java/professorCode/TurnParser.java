package professorCode;


import professorCode.TurnParserV2;
import sharedCode.SharedGameData;

import java.util.Objects;

public class TurnParser implements TurnParserV2 {
    @Override
    public boolean isGameOver(SharedGameData shareGameData) {
        return isGameStarted(shareGameData) && shareGameData.getGameState().isOver();
    }

    @Override
    public boolean isGameStarted(SharedGameData shareGameData) {
        return Objects.nonNull(shareGameData);
    }

    private boolean isTurn(SharedGameData shareGameData) {
        return isGameStarted(shareGameData) && shareGameData.getGameState().isTurn();
    }

    @Override
    public boolean isMyTurn(String myTeamName, SharedGameData shareGameData) {
        return
                //Its someone's turn
                isTurn(shareGameData) &&
                        //The reciever of the state == my team name
                        shareGameData.getGameState().getReceiver().equalsIgnoreCase(myTeamName) &&
                        //Check to make sure the current game action is empty
                        (shareGameData.gameActions().isEmpty() ||
                                //Check to make sure the last game action is not me (Make sure I haven't already played)
                                !shareGameData.gameActions().get(shareGameData.gameActions().size() - 1).getOwner().equalsIgnoreCase(myTeamName));
    }

    @Override
    public boolean isOtherPlayersTurn(String myTeamName, SharedGameData shareGameData) {
        return isTurn(shareGameData) && !shareGameData.getGameState().getReceiver().equalsIgnoreCase(myTeamName);
    }

    @Override
    public boolean isOtherPlayersTurnFinished(String myTeamName, SharedGameData shareGameData) {
        return
                //Its someone's turn
                isTurn(shareGameData) &&
                        //The receiver of the state != my team name
                        !shareGameData.getGameState().getReceiver().equalsIgnoreCase(myTeamName) &&
                        //Check to make sure the current game action is not empty
                        !shareGameData.gameActions().isEmpty() &&
                        //Check to make sure the last game action is not me (Make sure they played)
                        !shareGameData.gameActions().get(shareGameData.gameActions().size() - 1).getOwner().equalsIgnoreCase(myTeamName);
    }
}
