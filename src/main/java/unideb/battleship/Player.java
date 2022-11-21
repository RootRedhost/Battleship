package unideb.battleship;

import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    //@NonNull
    public String name;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int serial;
    /*public int gamesWon;
    public int gamesLost;*/

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    /*public Player(String name) {
        this.name = name;
        this.serial = //TODO RANDOM
        this.gamesWon = 0;
        this.gamesLost = 0;
    }*/

    /*@Override
    public String toString(){
        return String.format("Player {\n\tname : %s,\n\tgames won : %d,\n\tgames lost : %d\n}",
                this.name,this.gamesWon,this.gamesLost);
    }*/

    /*@Override
    public boolean equals(){

    }*/
}
