package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.java.models.User;
import main.java.util.HibernateUtil;

/**
 * 
 * 1 - configs
 * 2 - mapping
 * 3 - transactions
 * 4 - ORM
 * 6 - queries (SQL, HQL, criteria)
 *
 */
public class Main {
	
	public static void main(String[] args) {
		testHibernateConnection();
	}

	private static void testHibernateConnection() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println(sessionFactory);
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<User> users;
		try {
			users = session.createQuery("from usr").list();
		} finally {
			transaction.commit();
			session.close();
		}
		
		System.out.println(users);
	}

	private static void getUsers() {
		
	}

}
