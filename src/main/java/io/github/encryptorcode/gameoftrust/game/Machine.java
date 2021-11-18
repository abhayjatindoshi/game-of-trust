package io.github.encryptorcode.gameoftrust.game;

import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.players.Player;
import io.github.encryptorcode.gameoftrust.utils.Pair;

public class Machine {

    private ScoreBoard scoreBoard;
    private ChoiceKeeper choiceKeeper;
    private Player leftPlayer;
    private Player rightPlayer;

    public Machine(ScoreBoard scoreBoard, ChoiceKeeper choiceKeeper, Player leftPlayer, Player rightPlayer) {
        this.scoreBoard = scoreBoard;
        this.choiceKeeper = choiceKeeper;
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
    }

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            Choice leftChoice = leftPlayer.getChoice();
            Choice rightChoice = rightPlayer.getChoice();
            Pair<Integer, Integer> roundScore = calculateScore(leftChoice, rightChoice);

            scoreBoard.addScores(roundScore);
            choiceKeeper.pushChoice(leftChoice, rightChoice);
        }
    }

    private Pair<Integer, Integer> calculateScore(Choice leftChoice, Choice rightChoice) {
        if (leftChoice == rightChoice) {
            if (leftChoice == Choice.COOPERATE) {
                return new Pair<>(2, 2);
            } else {
                return new Pair<>(0, 0);
            }
        } else {
            if (leftChoice == Choice.CHEAT) {
                return new Pair<>(3, 0);
            } else {
                return new Pair<>(0, 3);
            }
        }
    }
}
