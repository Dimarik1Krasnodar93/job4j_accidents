package ru.job4j.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.model.Rule;
import ru.job4j.service.AccidentService;
import ru.job4j.service.AccidentTypeService;
import ru.job4j.service.RuleService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@AllArgsConstructor
public class AccidentController {
    AccidentService accidentService;
    AccidentTypeService accidentTypeService;
    RuleService ruleService;


    @GetMapping("/accidents")
    public String getAllAccidents(Model model) {
        List<Accident> accidents = accidentService.getAllAccidents();
        model.addAttribute("accidents", accidents);
        return "accidents";
    }

    @GetMapping("/createAccident")
    public String viewCreateAccident(Model model) {
        List<AccidentType> types = accidentTypeService.getAllAccidentTypes();
        model.addAttribute("types", types);
        List<Rule> rules = List.of(
                new Rule(1, "Статья. 1"),
                new Rule(2, "Статья. 2"),
                new Rule(3, "Статья. 3")
        );
        model.addAttribute("rules", rules);
        return "createAccident";
    }

    @GetMapping("/formUpdateAccident")
    public String formUpdateAccident(Model model, @RequestParam("id") int id) {
        Accident accident = accidentService.getById(id);
        if (accident == null) {
            accident = new Accident();
        }
        model.addAttribute("accident", accident);
        return "updateAccident";
    }

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        Set<Rule> set = ruleService.getRulesByStringArray(ids);
        accident.setRules(set);
        AccidentType accidentType = accidentTypeService.getAccidentTypeById(accident.getType().getId());
        accident.setType(accidentType);
        accidentService.create(accident);
        return "redirect:/accidents";
    }

    @PostMapping("/updateAccident")
    public String update(@ModelAttribute Accident accident) {

        accidentService.update(accident);
        return "redirect:/accidents";
    }
}
