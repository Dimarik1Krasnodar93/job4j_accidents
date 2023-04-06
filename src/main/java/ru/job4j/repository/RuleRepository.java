package ru.job4j.repository;

import ru.job4j.model.Rule;

import java.util.List;
import java.util.Set;

public interface RuleRepository {
    List<Rule> findAll();
    Set<Rule> findByStringArray(String[] array);
}
