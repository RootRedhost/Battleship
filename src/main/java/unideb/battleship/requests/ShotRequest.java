package unideb.battleship.requests;

public class ShotRequest {
    private final String gameId;
    private final String actingPlayer;
    private final String actionPos;

    public ShotRequest(String gameId, String actingPlayer, String actionPos) {
        this.gameId = gameId;
        this.actingPlayer = actingPlayer;
        this.actionPos = actionPos;
    }

    public String getGameId() {
        return gameId;
    }

    public String getActingPlayer() {
        return actingPlayer;
    }

    public String getActionPos() {
        return actionPos;
    }
}
