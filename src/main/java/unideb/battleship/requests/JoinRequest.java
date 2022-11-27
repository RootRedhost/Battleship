package unideb.battleship.requests;

public class JoinRequest {
    private final String name;
    private final String gameid;

    public String getName() {
        return name;
    }

    public String getGameid() {
        return gameid;
    }

    public JoinRequest(String name, String gameid) {
        this.name = name;
        this.gameid = gameid;
    }
}
