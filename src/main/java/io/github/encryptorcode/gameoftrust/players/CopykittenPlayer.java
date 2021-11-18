package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.game.ChoiceKeeper;
import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public class CopykittenPlayer extends Player {

    private Choice opponentsPreviousChoice;

    public CopykittenPlayer(PlayerPosition playerPosition) {
        super(playerPosition);
    }

    @Override
    public String getName() {
        return "Copy Kitten";
    }

    @Override
    public Choice getChoice() {
        ChoiceKeeper keeper = this.game.getChoiceKeeper();
        Choice opponentLastChoice = keeper.getLastChoicesOf(this.playerPosition.getOpponentPosition());
        if(this.opponentsPreviousChoice != null && this.opponentsPreviousChoice == Choice.CHEAT && opponentLastChoice == Choice.CHEAT){
            return Choice.CHEAT;
        }
        this.opponentsPreviousChoice = opponentLastChoice;
        return Choice.COOPERATE;
    }
}
