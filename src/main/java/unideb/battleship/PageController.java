package unideb.battleship;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import unideb.battleship.game.GameState;
import unideb.battleship.game.HiddenShipPositions;
import unideb.battleship.requests.JoinRequest;
import unideb.battleship.requests.ShotRequest;
import unideb.battleship.service.GameStateService;

import java.util.ArrayList;

@RestController
public class PageController {

    @Autowired
    private GameStateService gameStateService;

    @RequestMapping(value = "/showMaps", method = RequestMethod.GET)
    public ArrayList<GameState> showMapAll(){
        return gameStateService.getAllGameStates();
    }

    @RequestMapping(value = "/showMaps/{id}", method = RequestMethod.GET)
    public GameState showMap(@PathVariable String id){
        return gameStateService.getGameState(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ArrayList<String> test(){
        return gameStateService.getStrings();
    }

    //@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/createGame", method = RequestMethod.POST)
    public String createGame(@RequestBody String player1Name){
        return gameStateService.crateGame(player1Name);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/joinGame", method = RequestMethod.POST)
    public void joinGame(@RequestBody JoinRequest joinRequest){
        gameStateService.joinGame(joinRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/initGrid", method = RequestMethod.POST)//initialize the grid with ships in it
    public void initGrid(@RequestBody HiddenShipPositions hiddenShipPositions){
        gameStateService.initGrid(hiddenShipPositions);
    }

    @RequestMapping(value = "/makeAMove", method = RequestMethod.POST)
    public GameState makeAMove(@RequestBody ShotRequest shotRequest){

        //return shotRequest.getActingPlayer() + " " + shotRequest.getActionPos();
        return gameStateService.move(shotRequest);
    }
}