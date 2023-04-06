package ru.job4j.repository;

import ru.job4j.model.AccidentType;

import java.util.List;

public interface AccidentTypeRepository {
    AccidentType findById(int id);
    List<AccidentType> findAll();
}
