package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.AccidentTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentTypeService {
    public AccidentTypeRepository accidentTypeRepository;
    public List<AccidentType> getAllAccidentTypes() {
        return accidentTypeRepository.findAll();
    }
    public AccidentType getAccidentTypeById(int id) {
        return accidentTypeRepository.findById(id);
    }
}
