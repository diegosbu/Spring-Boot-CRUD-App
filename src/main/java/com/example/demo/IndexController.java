package com.example.demo;

//code partially used from: https://spring.io/guides/gs/handling-form-submission/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("formInput", new RegisterFields());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute RegisterFields formInput, Model model) {
        model.addAttribute("formInput", formInput);
        return "success";
    }
}
