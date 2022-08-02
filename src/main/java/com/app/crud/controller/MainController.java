package com.app.crud.controller;

//code resources: https://spring.io/guides/gs/handling-form-submission/
//  https://springframework.guru/processing-json-jackson/
//  https://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects/6349488#6349488

import com.app.crud.model.ApiPlayerInfo;
import com.app.crud.model.Users;
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
import java.util.Arrays;

@Controller
public class MainController {
    @Autowired
    UsersService userService;

    //  home - displays homepage
    @GetMapping("/")
    public String home() {
        return "index";
    }


    //  searchForm - displays basketball player search bar
    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    //  searchSubmit - displays json array search results from queried nba player name
    @PostMapping("/search")
    public String searchSubmit(@RequestParam(value="name", required = true) String playerName, Model model) throws IOException {
        String uri = "https://www.balldontlie.io/api/v1/players?search=" + playerName;

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String result = restTemplate.getForObject(uri, String.class);
        ApiPlayerInfo apiResponse = mapper.readValue(result, ApiPlayerInfo.class);

        model.addAttribute("jsonResults", Arrays.toString(apiResponse.getData()));

        return "results";
    }

    //  loginForm - displays login form
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    //  loginForm - displays login form
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

}
