package com.app.crud.controller;

//code partially used from: https://spring.io/guides/gs/handling-form-submission/

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

@Controller
public class MainController {
    @Autowired
    UsersService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(@RequestParam(value="name", required = true) String playerName, Model model) {
        String playerName2 = playerName.replace(" ", "_");
        String uri = "https://www.balldontlie.io/api/v1/players?search=" + playerName;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        model.addAttribute("playerStats", result);

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
