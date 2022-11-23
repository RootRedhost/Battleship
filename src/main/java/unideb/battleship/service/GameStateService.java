package unideb.battleship.service;

import org.springframework.stereotype.Service;
import unideb.battleship.game.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameStateService {
    private ArrayList<GameState> gameStates = new ArrayList<>();
    private ArrayList<String> stringList = new ArrayList<>();

    public ArrayList<GameState> getGameStates(){
        gameStates.add(new GameState("player 1 jóska", "player 2 pista"));
        return gameStates;

    }

    public ArrayList<String> getStrings(){
        stringList.add("Ein");
        stringList.add("Zwei");
        stringList.add("Polizei");
        return stringList;
    }


}
