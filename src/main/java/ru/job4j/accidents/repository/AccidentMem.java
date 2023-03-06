package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMem implements AccidentRepository {
    private Map<Integer, Accident> map = new ConcurrentHashMap<>();

    @Override
    public List<Accident> findAllAccidents() {
        return map.values().stream().toList();
    }
}
