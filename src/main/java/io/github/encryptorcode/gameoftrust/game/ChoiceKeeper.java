package io.github.encryptorcode.gameoftrust.game;

import io.github.encryptorcode.gameoftrust.utils.Choice;
import io.github.encryptorcode.gameoftrust.utils.Pair;
import io.github.encryptorcode.gameoftrust.utils.PlayerPosition;

import java.util.ArrayList;
import java.util.List;

public class ChoiceKeeper {

    private List<Pair<Choice, Choice>> choices;

    public ChoiceKeeper(){
        this.choices = new ArrayList<>();
    }

    void pushChoice(Choice player1Choice, Choice player2Choice){
        this.choices.add(new Pair<>(player1Choice, player2Choice));
    }

    private Pair<Choice,Choice> getLastChoices(){
        if(this.choices.size() == 0){
            return null;
        }
        return this.choices.get(this.choices.size()-1);
    }

    public Choice getLastChoicesOf(PlayerPosition position){
        Pair<Choice,Choice> lastChoices = getLastChoices();
        if(lastChoices == null){
            return null;
        }

        switch (position){
            case LEFT:
                return lastChoices.getLeft();
            case RIGHT:
                return lastChoices.getRight();
        }
        return null; // This case should never come
    }

    public List<Choice> getAllChoicesOf(PlayerPosition position){
        List<Choice> choiceList = new ArrayList<>();
        for (Pair<Choice, Choice> choice : this.choices) {
            switch (position){
                case LEFT:
                    choiceList.add(choice.getLeft());
                    break;
                case RIGHT:
                    choiceList.add(choice.getRight());
                    break;
            }
        }
        return choiceList;
    }

}
