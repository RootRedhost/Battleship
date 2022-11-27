package unideb.battleship.service;

import org.springframework.stereotype.Service;
import unideb.battleship.game.HiddenShipPositions;
import unideb.battleship.requests.JoinRequest;
import unideb.battleship.requests.ShotRequest;
import unideb.battleship.game.GameState;

import java.util.ArrayList;

/**
 * Service class that connects the REST APIs and the GameState class
 */
@Service
public class GameStateService {

    private static ArrayList<GameState> gameStates = new ArrayList<>();
    private ArrayList<String> stringList = new ArrayList<>();
    private static ArrayList<HiddenShipPositions> hiddenShipPositionsArrayList = new ArrayList<>();

    public static HiddenShipPositions getHSPIn(String gameId, String playerName){
        HiddenShipPositions hsp = null;
        for(HiddenShipPositions hiddenShipPositions : hiddenShipPositionsArrayList){
            if(hiddenShipPositions.getGameId().equals(gameId) && hiddenShipPositions.getPlayerName().equals(playerName)){
                hsp = hiddenShipPositions;
            }
        }
        return hsp;
    }

    public ArrayList<GameState> getAllGameStates(){
        return gameStates;

    }

    public GameState getGameState(String id){
        return gameStates.stream().filter(gt -> gt.getId().equals(id)).findFirst().get();
    }

    public GameState move(ShotRequest shotRequest){
        return getGameState(shotRequest.getGameId()).move(shotRequest.getActingPlayer(),shotRequest.getActionPos());
    }

    public void initGrid(HiddenShipPositions hiddenShipPositions){
        hiddenShipPositionsArrayList.add(hiddenShipPositions);
    }

    public String crateGame(String player1Name){
        GameState gameState = new GameState();
        gameStates.add(gameState);
        gameState.getPlayer1GameGrid().setOwner(player1Name);
        return gameState.getId();
    }

    public static boolean idExist(String s){
        boolean exists = false;
        for(GameState gameState : gameStates){
            if(gameState.getId().equals(s)){
                exists = true;
            }
        }
        return exists;
    }

    public void joinGame(JoinRequest joinRequest) {
        getGameState(joinRequest.getGameid()).getPlayer2GameGrid().setOwner(joinRequest.getName());
    }
}
