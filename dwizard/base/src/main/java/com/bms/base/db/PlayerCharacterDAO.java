package com.bms.base.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;

import com.bms.base.core.*;

public class PlayerCharacterDAO extends AbstractDAO<PlayerCharacter> {

	public PlayerCharacterDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<PlayerCharacter> findAll() {
		return this.list(this.namedQuery("PlayerCharacter.findAll"));
	}
	
	public PlayerCharacter findByName(String name) {
		Query q = this.namedQuery("PlayerCharacter.findByName");
		q.setParameter("name", name);
		return this.uniqueResult(q);
	}

}
