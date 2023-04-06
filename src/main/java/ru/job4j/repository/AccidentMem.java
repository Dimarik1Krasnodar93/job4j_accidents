package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem implements AccidentRepository {
    private Map<AtomicInteger, Accident> map = new ConcurrentHashMap<>();

    public AccidentMem() {
        Accident accident1 = new Accident(1, "DTP1", "2 cars",
                "Moscow", new AccidentType(1, "text"), new HashSet<>());
        Accident accident2 = new Accident(2, "DTP2", "2 cars",
                "Rostov", new AccidentType(1, "text"), new HashSet<>());
        map.put(new AtomicInteger(accident1.getId()), accident1);
        map.put(new AtomicInteger(accident2.getId()), accident2);
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
        accident.setId(newId);
        map.put(new AtomicInteger(newId), accident);
    }

    @Override
    public void update(Accident accident) {
        map.put(new AtomicInteger(accident.getId()), accident);
    }

    @Override
    public Accident getById(int id) {
        return map.get(id);
    }


}
