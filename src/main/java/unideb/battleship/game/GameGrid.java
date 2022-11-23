package unideb.battleship.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing one player's grid
 */
public class GameGrid {

    private ArrayList<Tile> grid = new ArrayList<>();
    private String owner;

    public ArrayList<Tile> getGrid() {
        return grid;
    }

    public String getOwner() {
        return owner;
    }

    public GameGrid(String owner) {
        this.owner = owner;
        for(int i = 0; i < 100;i++){
            this.grid.add(new Tile());
        }
    }
}
