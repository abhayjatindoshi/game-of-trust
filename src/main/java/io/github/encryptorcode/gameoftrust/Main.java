package io.github.encryptorcode.gameoftrust;

import io.github.encryptorcode.gameoftrust.game.Tournament;
import io.github.encryptorcode.gameoftrust.players.*;

public class Main {
    public static void main(String[] args) {
//        Player leftPlayer = new AlwaysCheatPlayer(PlayerPosition.LEFT);
//        Player rightPlayer = new CopykittenPlayer(PlayerPosition.RIGHT);
//        Game game = new Game(leftPlayer,rightPlayer);
//        game.play();
        Tournament tournament = new Tournament(DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,DetectivePlayer.class,CopykittenPlayer.class);
        tournament.play();
    }
}
