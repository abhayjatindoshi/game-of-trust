package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.game.ChoiceKeeper;
import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public class SimpletonPlayer extends Player {

    private Choice lastChoice;

    public SimpletonPlayer(PlayerPosition playerPosition) {
        super(playerPosition);
    }

    @Override
    public String getName() {
        return "Simpleton";
    }

    @Override
    public Choice getChoice() {
        ChoiceKeeper choiceKeeper = this.game.getChoiceKeeper();
        Choice opponentChoice = choiceKeeper.getLastChoicesOf(this.playerPosition.getOpponentPosition());
        if(opponentChoice != null){
            if(opponentChoice != Choice.COOPERATE){
                this.lastChoice = this.lastChoice == Choice.COOPERATE ? Choice.CHEAT : Choice.COOPERATE;
            }
        } else {
            this.lastChoice = Choice.COOPERATE;
        }
        return this.lastChoice;
    }
}
