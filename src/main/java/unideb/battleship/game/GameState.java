package unideb.battleship.game;


/**
 * Game manager class. Game instance.
 */
public class GameState {

    private GameGrid player1GameGrid;
    private GameGrid player2GameGrid;
    private final String id;

    public GameGrid getPlayer1GameGrid() {
        return player1GameGrid;
    }

    public GameGrid getPlayer2GameGrid() {
        return player2GameGrid;
    }

    public GameState(String p1, String p2, String id){
        this.player1GameGrid = new GameGrid(p1);
        this.player2GameGrid = new GameGrid(p2);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public GameState move(GameState gameState, String player, String actionPos){//feltételezzük hogy nem jön be nem-WATER actionPos
        GameGrid targetGrid;
        if (player.equals("p1")) {
            targetGrid = getPlayer2GameGrid();
        }
        else{
            targetGrid = getPlayer1GameGrid();
        }
        int rowNum = GameGrid.Letters.valueOf(actionPos.substring(0,1)).ordinal();
        int colNum = Integer.parseInt(actionPos.substring(1));
        Tile tileToChange = targetGrid.getGridPrivate().get(rowNum*10+colNum);
        switch (tileToChange.getTileType()){
            case WATER :
                tileToChange.setTileType(Tile.tileTypes.SHOT);
                targetGrid.getGridPublic().get(rowNum*10+colNum).setTileType(Tile.tileTypes.SHOT);
                break;
            case SHOT:
                break;
            case WRECK:
                break;
            case HIDDENSHIP:
                tileToChange.setTileType(Tile.tileTypes.WRECK);
                targetGrid.getGridPublic().get(rowNum*10+colNum).setTileType(Tile.tileTypes.WRECK);
                break;
        }
        if(targetGrid.numberOfWrecks() == GameGrid.armadaMax){
            //END OF GAME other player won
            //TODO
        }

        return gameState;
    }

}
