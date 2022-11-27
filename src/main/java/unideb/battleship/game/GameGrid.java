package unideb.battleship.game;

import unideb.battleship.service.GameStateService;

import java.util.ArrayList;

/**
 * Class representing one player's grid
 */
public class GameGrid {

    public enum Letters{
        A, B, C, D, E, F, G, H, I, J
    }

    private ArrayList<Tile> gridPublic = new ArrayList<>();
    //private ArrayList<Tile> gridPrivate = new ArrayList<>();
    private String owner;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    final static public int armadaMax = 16;

    /*public ArrayList<Tile> getGridPrivate() {
        return gridPrivate;
    }*/

    public ArrayList<Tile> getGridPublic() {
        return gridPublic;
    }

    public String getOwner() {
        return owner;
    }

    public GameGrid() {
        for(int i = 0; i < 100;i++){
            this.gridPublic.add(new Tile());
            //this.gridPrivate.add(new Tile());
        }
    }

    /*public Integer numberOfWrecks(){
        int n = 0;
        for(int i = 0; i < 100; i++){
            if(getGridPrivate().get(i).getTileType().equals(Tile.tileTypes.WRECK)){
                n++;
            }
        }
        return n;
        return GameStateService
    }*/

    public void initPrivateGrid(){
        for(int i = 0; i < 100; i++){
            //TODO initPrivateGrid
        }
    }
}
