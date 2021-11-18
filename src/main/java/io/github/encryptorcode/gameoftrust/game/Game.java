package io.github.encryptorcode.gameoftrust.game;

import io.github.encryptorcode.gameoftrust.players.Player;

public class Game {

    private Player leftPlayer;
    private Player rightPlayer;
    private ScoreBoard scoreBoard;
    private ChoiceKeeper choiceKeeper;
    private Machine machine;

    public Game(Player leftPlayer, Player rightPlayer){
        leftPlayer.setGame(this);
        rightPlayer.setGame(this);
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
        this.scoreBoard = new ScoreBoard(leftPlayer,rightPlayer);
        this.choiceKeeper = new ChoiceKeeper();
        this.machine = new Machine(scoreBoard, choiceKeeper, leftPlayer, rightPlayer);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public ChoiceKeeper getChoiceKeeper() {
        return choiceKeeper;
    }

    public void play(){
        machine.play(10);
//        System.out.println(this.leftPlayer.getName()+" vs "+this.rightPlayer.getName()+" --> "+this.scoreBoard.getLeftPlayerTotalScore()+"|"+this.scoreBoard.getRightPlayerTotalScore());
        scoreBoard.printScores();
    }
}
