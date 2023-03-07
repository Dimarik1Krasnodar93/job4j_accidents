package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMem implements AccidentRepository {
    private Map<Integer, Accident> map = new ConcurrentHashMap<>();

    public AccidentMem() {
        Accident accident1 = new Accident(1, "DTP1", "2 cars", "Moscow");
        Accident accident2 = new Accident(2, "DTP2", "2 cars", "Rostov");
        map.put(accident1.getId(), accident1);
        map.put(accident2.getId(), accident2);
    }

    @Override
    public List<Accident> findAllAccidents() {
        return map.values().stream().toList();
    }

    @Override
    public void save(Accident accident) {
        int newId = map.keySet().stream()
                .max(Comparator.naturalOrder()).orElse(0) + 1;
        accident.setId(newId);
        map.put(newId, accident);
    }

    @Override
    public void update(Accident accident) {
        map.put(accident.getId(), accident);
    }

    @Override
    public Accident getById(int id) {
        return map.get(id);
    }


}
