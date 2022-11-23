package unideb.battleship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unideb.battleship.game.GameState;
import unideb.battleship.service.GameStateService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PageController {

    @Autowired
    private GameStateService gameStateService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello";
    }

    @RequestMapping(value = "/showMap", method = RequestMethod.GET)
    public ArrayList<GameState> showMap(){
        return gameStateService.getGameStates();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ArrayList<String> test(){
        return gameStateService.getStrings();
    }
}