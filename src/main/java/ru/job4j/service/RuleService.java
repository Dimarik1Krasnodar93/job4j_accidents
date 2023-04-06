package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Rule;
import ru.job4j.repository.RuleRepository;

import java.util.Set;

@Service
@AllArgsConstructor
public class RuleService {
    public RuleRepository ruleRepository;

    public Set<Rule> getRulesByStringArray(String[] array) {
        return ruleRepository.findByStringArray(array);
    }

}
