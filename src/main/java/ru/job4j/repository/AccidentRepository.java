package ru.job4j.repository;

import ru.job4j.model.Accident;

import java.util.List;

public interface AccidentRepository {
     List<Accident> findAllAccidents();
     void save(Accident accident);
     void update(Accident accident);
     Accident getById(int id);
}
