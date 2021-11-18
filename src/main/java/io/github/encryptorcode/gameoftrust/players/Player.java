package io.github.encryptorcode.gameoftrust.players;

import io.github.encryptorcode.gameoftrust.game.Game;
import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

public abstract class Player {

    PlayerPosition playerPosition;
    Game game;

    public Player(PlayerPosition playerPosition){
        this.playerPosition = playerPosition;
    }

    public void setGame(Game game){
        this.game = game;
    }

    public abstract String getName();
    public abstract Choice getChoice();
}
