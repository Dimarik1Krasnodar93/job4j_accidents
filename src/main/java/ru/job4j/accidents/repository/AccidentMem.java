package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem implements AccidentRepository {
    private Map<AtomicInteger, Accident> map = new ConcurrentHashMap<>();

    public AccidentMem() {
        Accident accident1 = new Accident(new AtomicInteger(1), "DTP1", "2 cars",
                "Moscow", new AccidentType(1, "text"), new HashSet<>());
        Accident accident2 = new Accident(new AtomicInteger(2), "DTP2", "2 cars",
                "Rostov", new AccidentType(1, "text"), new HashSet<>());
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
                .max(Comparator.comparingInt(AtomicInteger::get)).
                orElse(new AtomicInteger(0)).incrementAndGet();
        AtomicInteger atomicInteger = new AtomicInteger(newId);
        accident.setId(atomicInteger);
        map.put(atomicInteger, accident);
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
