package unideb.battleship.game;

/**
 * Class representing the tiles of the grid
 */
public class Tile {
    public enum tileTypes {
        WATER, SHOT, WRECK
    }
    private tileTypes tileType;

    public tileTypes getTileType() {
        return tileType;
    }

    public void setTileType(tileTypes tileType) {
        this.tileType = tileType;
    }

    public Tile() {
        this.tileType = tileTypes.WATER;
    }

}
