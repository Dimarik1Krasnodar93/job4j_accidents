package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.repository.AccidentRepository;
import ru.job4j.accidents.repository.AccidentTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {
    public AccidentRepository accidentRepository;
    public AccidentTypeRepository accidentTypeRepository;
    public List<Accident> getAllAccidents() {
        return accidentRepository.findAllAccidents();
    }

    public List<AccidentType> getAllAccidentTypes() {
        return accidentTypeRepository.findAll();
    }

    public AccidentType getAccidentTypeById(int id) {
        return accidentTypeRepository.findById(id);
    }

    public void create(Accident accident) {
        accidentRepository.save(accident);
    }

    public void update(Accident accident) {
        accidentRepository.update(accident);
    }

    public Accident getById(int id) {
        return accidentRepository.getById(id);
    }
}
