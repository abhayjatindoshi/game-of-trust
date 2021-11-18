package io.github.encryptorcode.gameoftrust.game;

import io.github.encryptorcode.gameoftrust.players.Player;
import io.github.encryptorcode.gameoftrust.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private List<Pair<Integer, Integer>> scores;
    private Pair<Integer, Integer> totalScore;
    private Pair<String,String> playerNames;

    public ScoreBoard(Player leftPlayer, Player rightPlayer) {
        this.scores = new ArrayList<>();
        this.totalScore = new Pair<>(0, 0);
        this.playerNames = new Pair<>(leftPlayer.getName(),rightPlayer.getName());
    }

    void addScores(Pair<Integer, Integer> score) {
        this.scores.add(score);
        this.totalScore.setLeft(this.totalScore.getLeft() + score.getLeft());
        this.totalScore.setRight(this.totalScore.getRight() + score.getRight());
    }

    public Integer getLeftPlayerTotalScore(){
        return this.totalScore.getLeft();
    }

    public Integer getRightPlayerTotalScore(){
        return this.totalScore.getRight();
    }

    public void printScores(){
        String leftAlignFormat = "|  %16d  |  %16d  |%n";

        System.out.format("+--------------------+--------------------+%n");
        System.out.format("|  %16s  |  %16s  |%n",playerNames.getLeft(),playerNames.getRight());
        System.out.format("+--------------------+--------------------+%n");
        for (Pair<Integer, Integer> score : this.scores) {
            System.out.format(leftAlignFormat, score.getLeft(), score.getRight());
        }
        System.out.format("+--------------------+--------------------+%n");
        System.out.format(leftAlignFormat, this.totalScore.getLeft(), this.totalScore.getRight());
        System.out.format("+--------------------+--------------------+%n");
        System.out.println();
    }
}




