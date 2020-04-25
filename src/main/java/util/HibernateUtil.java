package main.java.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private HibernateUtil() {

	}

	public static void createSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
