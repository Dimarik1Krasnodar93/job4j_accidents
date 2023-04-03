package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.AccidentType;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccidentTypeMem implements AccidentTypeRepository {
    @Override
    public AccidentType findById(int id) {
        List<AccidentType> types = findAll();
        return types.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<AccidentType> findAll() {
        List<AccidentType> types = new ArrayList<>();
        types.add(new AccidentType(1, "Две машины"));
        types.add(new AccidentType(2, "Машина и человек"));
        types.add(new AccidentType(3, "Машина и велосипед"));

        return types;
    }
}
