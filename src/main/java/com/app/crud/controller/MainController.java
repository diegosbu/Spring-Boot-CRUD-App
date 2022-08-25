package com.app.crud.controller;

//code resources: https://spring.io/guides/gs/handling-form-submission/
//  https://springframework.guru/processing-json-jackson/
//  https://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects/6349488#6349488

import com.app.crud.model.ApiPlayerInfo;
import com.app.crud.model.players.Players;
import com.app.crud.model.users.Users;
import com.app.crud.service.PlayersService;
import com.app.crud.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UsersService userService;

    @Autowired
    PlayersService playersService;

    //  home - displays homepage
    @GetMapping("/")
    public String home() {
        return "index";
    }

    //  loginForm - displays login form
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    //  loginForm - displays logout button
    @GetMapping("/logout")
    public String logoutForm() {
        return "logout";
    }

    // registerForm - displays registration form
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("formInput", new Users());

        return "register";
    }

    // registerSubmit - submits registration form and calls userService
    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Users formInput, Model model) {
        if (userService.insert(formInput) != 0) {
            model.addAttribute("success", true);
        } else {
            model.addAttribute("success", false);
        }

        return "success";
    }

    //  searchForm - displays basketball player search bar
    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    //  searchSubmit - displays json search results from queried player name
    @PostMapping("/search")
    public String searchSubmit(@RequestParam(value="name") String playerName, Model model) throws IOException {
        String uri = "https://www.balldontlie.io/api/v1/players?search=" + playerName;

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String result = restTemplate.getForObject(uri, String.class);
        ApiPlayerInfo apiResponse = mapper.readValue(result, ApiPlayerInfo.class);

        model.addAttribute("jsonResults", apiResponse.getData());

        return "results";
    }

    //  addPlayer - adds player to user's favorites list
    @GetMapping("/add")
    public String addPlayer(@RequestParam(value="id") int playerID, @RequestParam(value="firstName")
                                String playerFirst, @RequestParam(value="lastName") String playerLast) {
        if (playersService.insert(playerID, playerFirst, playerLast)!= 0) {
            System.out.println("player added to favorites!");
        } else {
            System.out.println("player already favorited!");
        }

        return "index";
    }

    //  removePlayer - removes player from user's favorites list
    @PostMapping("/remove")
    public String removePlayer(@RequestParam(value="id") int playerID) {
        if (playersService.remove(playerID)!= 0) {
            System.out.println("player removed from favorites!");
        } else {
            System.out.println("player not removed!");
        }

        return "redirect:/favorites";
    }

    //  getFavorites - displays user's list of favorited players
    @GetMapping("/favorites")
    public String getFavorites(Model model) {
        List<Players> players = playersService.find();

        model.addAttribute("favorites", true);
        model.addAttribute("playersList", players);

        return "results";
    }
}
