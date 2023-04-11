package ru.job4j.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentRepositoryDB {
    private final SessionFactory sessionFactory;
    private final CrudRepositoryMy crudRepository;

    public static final String FIND_ALL_ACCIDENTS = "SELECT a FROM Accident a";

    public AccidentRepositoryDB(SessionFactory sessionFactory, CrudRepositoryMy crudRepository) {
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
