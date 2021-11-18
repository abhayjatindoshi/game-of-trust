package io.github.encryptorcode.gameoftrust.game;

import io.github.encryptorcode.gameoftrust.players.Player;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Tournament {

    private Class<? extends Player>[] playerClasses;

    public Tournament(Class<? extends Player>... playerClasses){
        this.playerClasses = playerClasses;
    }

    public void play() {
        Map<Class<? extends Player>, Integer> playerClassVsScores = new HashMap<>();

        for (int i = 0; i < playerClasses.length; i++) {
            for (int j = i + 1; j < playerClasses.length; j++) {
                Class<? extends Player> leftPlayerClass = playerClasses[i];
                Class<? extends Player> rightPlayerClass = playerClasses[j];

                Player leftPlayer = constructPlayer(leftPlayerClass, PlayerPosition.LEFT);
                Player rightPlayer = constructPlayer(rightPlayerClass, PlayerPosition.RIGHT);

                Game game = new Game(leftPlayer,rightPlayer);
                game.play();

                ScoreBoard scoreBoard = game.getScoreBoard();

                if(!playerClassVsScores.containsKey(leftPlayerClass)){
                    playerClassVsScores.put(leftPlayerClass,0);
                }

                if(!playerClassVsScores.containsKey(rightPlayerClass)){
                    playerClassVsScores.put(rightPlayerClass,0);
                }

                playerClassVsScores.put(leftPlayerClass,playerClassVsScores.get(leftPlayerClass) + scoreBoard.getLeftPlayerTotalScore());
                playerClassVsScores.put(rightPlayerClass,playerClassVsScores.get(rightPlayerClass) + scoreBoard.getRightPlayerTotalScore());
            }
        }

        System.out.println("Player scores...");
        for (Class<? extends Player> playerClass : playerClassVsScores.keySet()) {
            System.out.println(constructPlayer(playerClass,PlayerPosition.LEFT).getName()+": "+playerClassVsScores.get(playerClass));
        }
    }

    private Player constructPlayer(Class<? extends Player> playerClass, PlayerPosition playerPosition){
        try {
            return playerClass.getDeclaredConstructor(PlayerPosition.class).newInstance(playerPosition);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException("Cannot construct Player");
        }
    }
}
