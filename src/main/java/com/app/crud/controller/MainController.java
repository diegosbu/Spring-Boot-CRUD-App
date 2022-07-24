package com.app.crud.controller;

//code partially used from: https://spring.io/guides/gs/handling-form-submission/

import com.app.crud.model.Users;
import com.app.crud.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    UsersService userService;

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("authenticated", true);
        } else {
            model.addAttribute("authenticated", false);
        }

        return "index";
    }

    //  loginForm - displays login form
    @GetMapping("/login")
    public String loginForm() {
        return "login";
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
