package main;

import java.util.Optional;

import org.hibernate.SessionFactory;

import main.java.util.HibernateUtil;

/**
 * 
 * 1 - configs
 * 2 - mapping (XML, annotations)
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
		Optional<SessionFactory> sessionFactory = HibernateUtil.getSessionFactory();
		
//		Session session = sessionFactory.openSession();
//		User user = new User("John");
//		Transaction transaction = session.beginTransaction();
//		session.save(user);
//		transaction.commit();
//		session.close();
	}

}














//Session session = sessionFactory.openSession();
//FirstTable firstTable = new FirstTable("column4");
//Transaction transaction = session.beginTransaction();
//session.save(firstTable);
//transaction.commit();
//session.close();

//Transaction transaction2 = session.beginTransaction();
//List<User> users;
//try {
//	users = session.createQuery("from worker").list();
//} finally {
//	transaction2.commit();
//	session.close();
//}		
//System.out.println(users);