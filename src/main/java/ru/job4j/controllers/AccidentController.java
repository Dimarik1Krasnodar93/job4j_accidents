package ru.job4j.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.AccidentService;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccidentController {
    AccidentService accidentService;

    @GetMapping("/allAccidents")
    public String getAllAccidents(Model model) {
        List<Accident> accidents = accidentService.getAllAccidents();
        model.addAttribute("accidents", accidents);
        return "accidents";
    }
}
