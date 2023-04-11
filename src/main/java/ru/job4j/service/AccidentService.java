package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepositoryMy;
import ru.job4j.repository.AccidentJdbcTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {
    public AccidentRepositoryMy accidentRepository;
    private final AccidentJdbcTemplate accidentJdbcTemplate;

    public List<Accident> getAllAccidents() {
        return accidentRepository.findAllAccidents();
    }



    public void create(Accident accident) {
        accidentJdbcTemplate.save(accident);
    }


    public void update(Accident accident) {
        accidentRepository.update(accident);
    }

    public Accident getById(int id) {
        return accidentRepository.getById(id);
    }
}
