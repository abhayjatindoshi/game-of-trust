package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.game.ChoiceKeeper;
import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public class CopyCatPlayer extends Player {

    public CopyCatPlayer(PlayerPosition playerPosition) {
        super(playerPosition);
    }

    @Override
    public String getName() {
        return "Copy Cat";
    }

    @Override
    public Choice getChoice() {
        ChoiceKeeper choiceKeeper = this.game.getChoiceKeeper();
        Choice opponentsPreviousChoice = choiceKeeper.getLastChoicesOf(this.playerPosition.getOpponentPosition());
        if(opponentsPreviousChoice == null){
            return Choice.COOPERATE;
        } else {
            return opponentsPreviousChoice;
        }
    }
}
