package unideb.battleship.game;


import unideb.battleship.service.GameStateService;
import unideb.battleship.service.IdGen;

/**
 * Game manager class. Game instance.
 */
public class GameState {

    public enum WhoWon{
        NONE, PLAYER1, PLAYER2
    }

    private GameGrid player1GameGrid;
    private GameGrid player2GameGrid;
    private int p1ShipsLeft;
    private int p2ShipsLeft;
    private String id;
    private WhoWon whoWon;
    private WhoWon nextPlayer;

    public int getP1ShipsLeft() {
        return p1ShipsLeft;
    }

    public void setP1ShipsLeft(int p1ShipsLeft) {
        this.p1ShipsLeft = p1ShipsLeft;
    }

    public int getP2ShipsLeft() {
        return p2ShipsLeft;
    }

    public void setP2ShipsLeft(int p2ShipsLeft) {
        this.p2ShipsLeft = p2ShipsLeft;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WhoWon getWhoWon() {
        return whoWon;
    }

    public void setWhoWon(WhoWon whoWon) {
        this.whoWon = whoWon;
    }

    public GameGrid getPlayer1GameGrid() {
        return player1GameGrid;
    }

    public GameGrid getPlayer2GameGrid() {
        return player2GameGrid;
    }

    public GameState(){
        this.player1GameGrid = new GameGrid();
        this.player2GameGrid = new GameGrid();
        this.whoWon = WhoWon.NONE;
        this.id = IdGen.generateId();
        p1ShipsLeft = GameGrid.armadaMax;
        p2ShipsLeft = GameGrid.armadaMax;
        nextPlayer = WhoWon.PLAYER1;
    }

    public String getId() {
        return id;
    }

    public GameState move(String player, String actionPos){
        if(getWhoWon().equals(WhoWon.NONE)){
            if(player.equals(player1GameGrid.getOwner()) && nextPlayer.equals(WhoWon.PLAYER1)){
                this.moveLogic(player,actionPos);
                nextPlayer = WhoWon.PLAYER2;
            }
            else if(player.equals(player2GameGrid.getOwner()) && nextPlayer.equals(WhoWon.PLAYER2)){
                this.moveLogic(player,actionPos);
                nextPlayer = WhoWon.PLAYER1;
            }
        }
        if(getP1ShipsLeft() <= 0){
            setWhoWon(WhoWon.PLAYER2);
        }
        else if(getP2ShipsLeft() <= 0){
            setWhoWon(WhoWon.PLAYER1);
        }
        return this;
    }

    private void moveLogic(String player, String actionPos){
        GameGrid targetGrid;
        if (player.equals(this.player1GameGrid.getOwner())) {
            targetGrid = getPlayer2GameGrid();
        }
        else{
            targetGrid = getPlayer1GameGrid();
        }
        int rowNum = GameGrid.Letters.valueOf(actionPos.substring(0,1)).ordinal();
        int colNum = Integer.parseInt(actionPos.substring(1));
        int targetNum = rowNum*10+colNum;
        Tile tileToChange = targetGrid.getGridPublic().get(targetNum);
        switch (tileToChange.getTileType()){
            case WATER :
                HiddenShipPositions hsp = GameStateService.getHSPIn(this.getId(), targetGrid.getOwner());
                if(hsp.getPositions().contains(Integer.valueOf(targetNum))){
                    //találat
                    tileToChange.setTileType(Tile.tileTypes.WRECK);
                    hsp.deleteFromPositions(targetNum);
                    if (player.equals(this.player1GameGrid.getOwner())) {
                        p2ShipsLeft = hsp.getPositions().size();
                    }
                    else{
                        p1ShipsLeft = hsp.getPositions().size();
                    }
                }
                else{
                    tileToChange.setTileType(Tile.tileTypes.SHOT);
                }
                break;
            case SHOT:
                break;
            case WRECK:
                break;
        }
    }

}
