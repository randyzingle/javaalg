package com.bms.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBUtils {
	
	private static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	private static StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
			applySettings(configuration.getProperties());
	public static SessionFactory factory = configuration.buildSessionFactory(builder.build());

}
