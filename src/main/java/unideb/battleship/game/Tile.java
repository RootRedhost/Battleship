package unideb.battleship.game;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Class representing the tiles of the grid
 */
public class Tile {
    public enum tileTypes {
        WATER, SHOT, WRECK, HIDDENSHIP
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


//TODO annotations and constuctors for the Tile class
}
