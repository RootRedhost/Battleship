package unideb.battleship;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PageController {

    public List<Player> playerList = List.of();

    /*@RequestMapping("/allPlayers")
    private String allPlayers(Model model){
        model.addAttribute("player_result", playerService.listAllPlayers());
        return "player_result";
    }*/

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "greeting_result";
    }

    @GetMapping("/createPlayer")
    public String newPlayerForm(Model model) {
        model.addAttribute("player", new Player());//FONTOS
        return "player";
    }

    @PostMapping("/createPlayer")
    public String createPlayer(@ModelAttribute Player player, Model model){
        model.addAttribute("player", player);
        playerList.add(player);
        for(Player p : playerList)
            System.out.println(p);
        return "player_result";
    }
}