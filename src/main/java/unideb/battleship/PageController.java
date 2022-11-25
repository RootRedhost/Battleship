package unideb.battleship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unideb.battleship.game.GameState;
import unideb.battleship.service.GameStateService;

import java.util.ArrayList;

@RestController
public class PageController {

    @Autowired
    private GameStateService gameStateService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello";
    }

    @RequestMapping(value = "/showMaps", method = RequestMethod.GET)
    public ArrayList<GameState> showMapAll(){
        return gameStateService.getAllGameStates();
    }

    @RequestMapping(value = "/showMaps/{id}", method = RequestMethod.GET)
    public GameState showMap(@PathVariable String id){
        return gameStateService.getGameState(id);
    }

    /*@RequestMapping(value = "/makeAMove", method = RequestMethod.POST){
        public ArrayList<GameState> makeAMove(){

            return
        }
    }*/

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ArrayList<String> test(){
        return gameStateService.getStrings();
    }
}