package ru.job4j.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.repository.AccidentHibernate;
import ru.job4j.service.AccidentService;

@Controller
@AllArgsConstructor
public class IndexController {
    private final AccidentHibernate accidents;

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
