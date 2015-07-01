package com.bms.main;

import com.bms.db.*;

import org.hibernate.Transaction;
import org.hibernate.Session;

public class RunHibernateTest {

	public static void main(String[] args) {

		try {
			Session session = DBUtils.factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				CharacterEntity ce = new CharacterEntity();
				ce.setAge(22);
				ce.setJob("Software Engineer");
				ce.setName("Baldur Zingle");
				session.persist(ce);
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
