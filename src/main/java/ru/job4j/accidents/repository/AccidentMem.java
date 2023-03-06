package ru.job4j.accidents.repository;

import ru.job4j.accidents.model.Accident;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccidentMem {
    private Map<Integer, Accident> map = new ConcurrentHashMap<>();
}
