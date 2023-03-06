package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.repository.AccidentRepository;
import ru.job4j.accidents.repository.AccidentRepositoryDB;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {
    public AccidentRepository accidentRepository;

    public List<Accident> getAllAccidents() {
        return accidentRepository.findAllAccidents();
    }

    public void create(Accident accident) {

    }
}
