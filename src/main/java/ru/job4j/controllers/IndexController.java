package ru.job4j.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.repository.AccidentHibernate;

@Controller
public class IndexController {
    private final AccidentHibernate accidents;

    public IndexController(AccidentHibernate accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", accidents.getAll());
        return "index";
    }

    @GetMapping("/index")
    public String getIndex23(Model model) {
        model.addAttribute("user", "Petr Arsentev");
        return "index";
    }
}
