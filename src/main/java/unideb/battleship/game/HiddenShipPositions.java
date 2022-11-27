package unideb.battleship.game;

import java.util.Set;

/**
 * Contains information about one's ships
 */
public class HiddenShipPositions {
    private Set<Integer> positions;
    private final String gameId;
    private final String playerName;

    public Set<Integer> getPositions() {
        return positions;
    }

    public String getGameId() {
        return gameId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public HiddenShipPositions(Set<Integer> positions, String gameId, String playerName) {
        this.positions = positions;
        this.gameId = gameId;
        this.playerName = playerName;
    }

    public void deleteFromPositions(int n){
        this.positions.remove(Integer.valueOf(n));
    }
}
