package unideb.battleship.service;

import unideb.battleship.service.GameStateService;

import java.util.Random;

public class IdGen {
    private final static int min = 10000;
    private final static int max = 99999;
    public static String generateId(){
        Random random = new Random();
        String r = String.valueOf(random.nextInt(min,max+1));
        while(GameStateService.idExist(r)){
            r = String.valueOf(random.nextInt(min,max+1));
        }
        return r;
    }
}
