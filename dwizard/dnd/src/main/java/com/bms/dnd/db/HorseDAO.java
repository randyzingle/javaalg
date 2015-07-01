package com.bms.dnd.db;

import com.bms.dnd.core.Horse;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import com.google.common.base.Optional;

import java.util.List;


public class HorseDAO extends AbstractDAO<Horse> {

    public HorseDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Horse> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Horse create(Horse c) {
        return persist(c);
    }

    public void delete(Horse c) {
        this.currentSession().delete(c);
    }

    public List<Horse> findAll() {
        return list(namedQuery("Horse.findAll"));
    }
}
