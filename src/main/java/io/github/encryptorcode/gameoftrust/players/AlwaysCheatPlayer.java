package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public class AlwaysCheatPlayer extends Player {

    public AlwaysCheatPlayer(PlayerPosition playerPosition) {
        super(playerPosition);
    }

    @Override
    public String getName() {
        return "Always Cheat";
    }

    @Override
    public Choice getChoice() {
        return Choice.CHEAT;
    }
}
