package ru.job4j.accidents.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentRepositoryDB {
    private final SessionFactory sessionFactory;
    private final CrudRepository crudRepository;

    public static final String FIND_ALL_ACCIDENTS = "SELECT a FROM Accident a";

    public AccidentRepositoryDB(SessionFactory sessionFactory, CrudRepository crudRepository) {
        this.sessionFactory = sessionFactory;
        this.crudRepository = crudRepository;
    }

    public List<Accident> findAllAccidents() {
        return crudRepository.query(FIND_ALL_ACCIDENTS, Accident.class, new HashMap<>());
    }

    public void create(Accident accident) {
        crudRepository.run(session -> session.save(accident));
    }
}
