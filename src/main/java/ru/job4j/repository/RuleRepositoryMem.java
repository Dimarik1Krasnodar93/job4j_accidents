package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RuleRepositoryMem implements RuleRepository {
    @Override
    public List<Rule> findAll() {
        List<Rule> rules = List.of(
                new Rule(1, "Статья. 1"),
                new Rule(2, "Статья. 2"),
                new Rule(3, "Статья. 3")
        );
        return rules;
    }

    @Override
    public Set<Rule> findByStringArray(String[] array) {
        Set<Rule> set = new HashSet<>();
        List<Rule> rules = findAll();
        for (String temp : array) {
            set.add(rules.stream().filter(j -> j.getId() == Integer.parseInt(temp)).findFirst().get());
        }
        return set;
    }
}
