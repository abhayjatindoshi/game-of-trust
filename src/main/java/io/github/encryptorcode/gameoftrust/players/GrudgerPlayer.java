package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.game.ChoiceKeeper;
import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public class GrudgerPlayer extends Player {

    private boolean hasOpponentCheated = false;

    public GrudgerPlayer(PlayerPosition playerPosition) {
        super(playerPosition);
    }

    @Override
    public String getName() {
        return "Grudger";
    }

    @Override
    public Choice getChoice() {
        ChoiceKeeper choiceKeeper = this.game.getChoiceKeeper();
        Choice opponentsPreviousChoice = choiceKeeper.getLastChoicesOf(this.playerPosition.getOpponentPosition());
        if(opponentsPreviousChoice == Choice.CHEAT){
            this.hasOpponentCheated = true;
        }

        return this.hasOpponentCheated ? Choice.CHEAT : Choice.COOPERATE;
    }
}
