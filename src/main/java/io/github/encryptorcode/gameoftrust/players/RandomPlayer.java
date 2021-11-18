package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public class RandomPlayer extends Player{

    public RandomPlayer(PlayerPosition playerPosition) {
        super(playerPosition);
    }

    @Override
    public String getName() {
        return "Random";
    }

    @Override
    public Choice getChoice() {
        return Math.random() < 0.5 ? Choice.CHEAT : Choice.COOPERATE;
    }
}
