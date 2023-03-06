package ru.job4j.accidents.service;

import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.repository.AccidentRepositoryDB;

import java.util.List;

@Service
public class AccidentService {
    public AccidentRepositoryDB accidentRepository;

    public List<Accident> getAllAccidents() {
        return accidentRepository.findAllAccidents();
    }

    public void create(Accident accident) {

    }
}
