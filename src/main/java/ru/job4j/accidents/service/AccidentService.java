package ru.job4j.accidents.service;

import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.repository.AccidentRepository;

import java.util.List;

@Service
public class AccidentService {
    public AccidentRepository accidentRepository;

    public List<Accident> getAllAccidents() {
        return accidentRepository.findAllAccidents();
    }
}
