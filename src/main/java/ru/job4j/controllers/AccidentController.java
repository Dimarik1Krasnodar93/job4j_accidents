package ru.job4j.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.service.AccidentService;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccidentController {
    AccidentService accidentService;

    @GetMapping("/accidents")
    public String getAllAccidents(Model model) {
        List<Accident> accidents = accidentService.getAllAccidents();
        model.addAttribute("accidents", accidents);
        return "accidents";
    }


    @GetMapping("/createAccident")
    public String viewCreateAccident(Model model) {
        List<AccidentType> types = accidentService.getAllAccidentTypes();
        model.addAttribute("types", types);
        return "createAccident";
    }

    @GetMapping("/formUpdateAccident")
    public String formUpdateAccident(Model model, @RequestParam("id") int id) {
        Accident accident = accidentService.getById(id);
        model.addAttribute("accident", accident);
        return "updateAccident";
    }

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident) {
        AccidentType accidentType = accidentService.getAccidentTypeById(accident.getType().getId());
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
