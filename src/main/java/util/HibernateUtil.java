package main.java.util;

import java.util.Optional;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Optional<SessionFactory> sessionFactory = Optional.empty();

	private HibernateUtil() {

	}

	private static Optional<SessionFactory> createSessionFactory() {		
		
		Configuration configuration = new Configuration().configure();		
		
//		configuration.addClass(User.class);
		
//		configuration.addResource("first_table.hbm.xml");
//		configuration.addResource("user.hbm.xml");
//		configuration.addResource("role.hbm.xml");
//		configuration.addResource("status.hbm.xml");
//		configuration.addResource("course.hbm.xml");
		
		Properties properties = configuration.getProperties();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(properties);
		StandardServiceRegistry serviceRegistry = builder.configure().build();
				
		Optional<SessionFactory> sessionFactory = Optional.of(configuration.buildSessionFactory(serviceRegistry));
		return sessionFactory;
	}

	public static Optional<SessionFactory> getSessionFactory() {		
		return Optional.of(sessionFactory).orElse(createSessionFactory());
	}

}
