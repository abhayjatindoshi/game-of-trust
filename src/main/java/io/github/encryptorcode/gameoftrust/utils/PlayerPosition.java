package io.github.encryptorcode.gameoftrust.utils;

public enum PlayerPosition {
    LEFT,
    RIGHT;

    public PlayerPosition getOpponentPosition(){
        if(this == LEFT){
            return RIGHT;
        } else {
            return LEFT;
        }
    }
}
