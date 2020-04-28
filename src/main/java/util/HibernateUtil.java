package main.java.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private HibernateUtil() {

	}

	private static void createSessionFactory() {
		Configuration configuration = new Configuration().configure();		
		configuration.addResource("first_table.hbm.xml");
		configuration.addResource("user.hbm.xml");
		configuration.addResource("role.hbm.xml");
		configuration.addResource("status.hbm.xml");
		
		Properties properties = configuration.getProperties();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(properties);
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			createSessionFactory();
		}
		return sessionFactory;
	}

}
