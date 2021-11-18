package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public class AlwaysCooperatePlayer extends Player {
    public AlwaysCooperatePlayer(PlayerPosition playerPosition) {
        super(playerPosition);
    }

    @Override
    public String getName() {
        return "Always Cooperate";
    }

    @Override
    public Choice getChoice() {
        return Choice.COOPERATE;
    }
}
