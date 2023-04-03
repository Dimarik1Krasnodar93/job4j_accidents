package ru.job4j.accidents.repository;

import ru.job4j.accidents.model.AccidentType;

import java.util.List;

public interface AccidentTypeRepository {
    AccidentType findById(int id);
    List<AccidentType> findAll();
}
