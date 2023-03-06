package ru.job4j.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("user", "Petr Arsentev");
        return "index";
    }

    @GetMapping("/index")
    public String getIndex23(Model model) {
        model.addAttribute("user", "Petr Arsentev");
        return "index";
    }
}
