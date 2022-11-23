package unideb.battleship.game;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Game manager class. Game instance.
 */
public class GameState {

    private GameGrid player1GameGrid;
    private GameGrid player2GameGrid;

    public GameGrid getPlayer1GameGrid() {
        return player1GameGrid;
    }

    public GameGrid getPlayer2GameGrid() {
        return player2GameGrid;
    }

    public GameState(String p1, String p2){
        this.player1GameGrid = new GameGrid(p1);
        this.player2GameGrid = new GameGrid(p2);
    }

}
