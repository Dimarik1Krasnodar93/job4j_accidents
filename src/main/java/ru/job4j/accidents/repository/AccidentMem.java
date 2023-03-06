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
}
