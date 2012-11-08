package com.oivan.cashman.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	private static final Configuration configuration;
	private static final ServiceRegistry serviceRegistry;
	
	private HibernateUtil() {}
		
	static {
		configuration = new Configuration();
		configuration.configure().setProperty("hibernate.show_sql", "false");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}