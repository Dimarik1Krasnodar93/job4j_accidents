package ru.job4j.accidents.repository;

import ru.job4j.accidents.model.Accident;

import java.util.List;

public interface AccidentRepository {
     List<Accident> findAllAccidents();
     void save(Accident accident);
     void update(Accident accident);
     Accident getById(int id);
}
