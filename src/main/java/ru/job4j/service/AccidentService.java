package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.model.Rule;
import ru.job4j.repository.AccidentJdbcTemplate;
import ru.job4j.repository.AccidentRepository;
import ru.job4j.repository.AccidentTypeRepository;
import ru.job4j.repository.RuleRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccidentService {
    public AccidentRepository accidentRepository;
    private final AccidentJdbcTemplate accidentJdbcTemplate;
    public AccidentTypeRepository accidentTypeRepository;
    public RuleRepository ruleRepository;

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
        accidentJdbcTemplate.save(accident);
    }

    public Set<Rule> getRulesByStringArray(String[] array) {
        return ruleRepository.findByStringArray(array);
    }

    public void update(Accident accident) {
        accidentRepository.update(accident);
    }

    public Accident getById(int id) {
        return accidentRepository.getById(id);
    }
}
