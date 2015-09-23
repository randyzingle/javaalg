package com.bms.base.db;

import io.dropwizard.hibernate.AbstractDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bms.base.core.Pet;

public class PetDAO extends AbstractDAO<Pet> {

	public PetDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<Pet> findAll() {
		return this.list(this.namedQuery("Pet.findAll"));
	}
	
	public Pet findByName(String name) {
		Query q = this.namedQuery("Pet.findByName");
		q.setParameter("name", name);
		return this.uniqueResult(q);
	}

}
