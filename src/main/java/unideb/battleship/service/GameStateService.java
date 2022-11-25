package unideb.battleship.service;

import org.springframework.stereotype.Service;
import unideb.battleship.game.GameState;

import java.util.ArrayList;

@Service
public class GameStateService {

    private ArrayList<GameState> gameStates = new ArrayList<>();
    private ArrayList<String> stringList = new ArrayList<>();

    public ArrayList<GameState> getAllGameStates(){
        gameStates.add(new GameState("player 1 jóska", "player 2 pista", "12345"));
        return gameStates;

    }

    public GameState getGameState(String id){
        return gameStates.stream().filter(gt -> gt.getId().equals(id)).findFirst().get();
    }

    public ArrayList<String> getStrings(){
        stringList.add("Ein");
        stringList.add("Zwei");
        stringList.add("Polizei");
        return stringList;
    }

    public GameState move

}
