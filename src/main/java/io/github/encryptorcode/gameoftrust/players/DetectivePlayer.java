package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.game.ChoiceKeeper;
import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

import java.util.List;

public class DetectivePlayer extends Player{

    private static final Choice[] INITIAL_CHOICES = new Choice[]{Choice.COOPERATE,Choice.CHEAT,Choice.COOPERATE,Choice.COOPERATE};
    private int currentRound;
    private Player actingPlayer;

    public DetectivePlayer(PlayerPosition playerPosition) {
        super(playerPosition);
        this.currentRound = 0;
    }

    @Override
    public String getName() {
        return "Detective";
    }

    @Override
    public Choice getChoice() {
        currentRound++;
        if(this.currentRound == INITIAL_CHOICES.length){
            ChoiceKeeper choiceKeeper = this.game.getChoiceKeeper();
            List<Choice> choiceList = choiceKeeper.getAllChoicesOf(this.playerPosition.getOpponentPosition());
            if(choiceList.contains(Choice.CHEAT)){
                this.actingPlayer = new CopyCatPlayer(this.playerPosition);
            } else {
                this.actingPlayer = new AlwaysCheatPlayer(this.playerPosition);
            }
            this.actingPlayer.setGame(this.game);
        }
        if (this.currentRound <= INITIAL_CHOICES.length) {
            return INITIAL_CHOICES[currentRound - 1];
        } else {
            return this.actingPlayer.getChoice();
        }
    }
}
