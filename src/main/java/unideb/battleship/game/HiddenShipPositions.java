package unideb.battleship.game;

import java.util.ArrayList;
import java.util.Set;

public class HiddenShipPositions {
    //private ArrayList<Integer> positions;
    private Set<Integer> positions;
    private final String gameId;
    private final String playerName;

    public /*ArrayList<Integer>*/Set<Integer> getPositions() {
        return positions;
    }

    public String getGameId() {
        return gameId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public HiddenShipPositions(/*ArrayList<Integer> positions*/Set<Integer> positions, String gameId, String playerName) {
        this.positions = positions;
        this.gameId = gameId;
        this.playerName = playerName;
    }

    public void deleteFromPositions(int n){
        /*for(Integer position : this.positions){
            if(position.equals(n)){
                this.positions.remove(Integer.valueOf(n));
            }
        }*/
        this.positions.remove(Integer.valueOf(n));
    }
}
