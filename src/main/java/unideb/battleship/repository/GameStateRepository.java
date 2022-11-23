package unideb.battleship.repository;

import org.springframework.data.repository.Repository;
import unideb.battleship.game.GameState;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public interface GameStateRepository<T, ID extends Serializable>
        extends CrudRepository<T, ID> {

}
