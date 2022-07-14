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

@Controller
public class MainController {
    @Autowired
    UsersService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model, Model model2) {
        model.addAttribute("formInput", new Users());
        model2.addAttribute("loggingIn", false);
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Users formInput, Model model) {
        model.addAttribute("loggingIn", false);

        if (userService.insert(formInput) != 0) {
            model.addAttribute("success", true);
        } else {
            model.addAttribute("success", false);
        }

        return "success";
    }
}
