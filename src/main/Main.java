package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.java.models.FirstTable;
import main.java.util.HibernateUtil;

/**
 * 
 * 1 - configs
 * 2 - mapping
 * 3 - transactions
 * 4 - ORM
 * 5 - queries (SQL, HQL, criteria)
 *
 */
public class Main {
	
	public static void main(String[] args) {
		testHibernateConnection();
	}

	private static void testHibernateConnection() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		FirstTable firstTable = new FirstTable("column3");
		Transaction transaction = session.beginTransaction();
		session.save(firstTable);
		transaction.commit();
		session.close();
		
//		Transaction transaction = session.beginTransaction();
//		List<User> users;
//		try {
//			users = session.createQuery("from worker").list();
//		} finally {
//			transaction.commit();
//			session.close();
//		}
//		
//		System.out.println(users);
	}

	private static void getUsers() {
		
	}

}
