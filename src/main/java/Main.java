package main.java;

import org.hibernate.SessionFactory;

import main.java.dao.CriteriaQuerySender;
import main.java.util.HibernateUtil;
import main.java.util.ValidationUtil;

/**
 * 
 * 1 - configs 2 - mapping (XML, annotations) 3 - transactions 4 - ORM 5 -
 * queries (SQL, HQL, criteria)
 *
 */
public class Main {

	public static void main(String[] args) {
		testValidation();
	}

	private static void testHibernateConnection() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	}

	private static void testQueries() {
//		new TestQuerySender().createTransaction();
//		new SqlQuerySender().createTransaction();
//		new HqlQuerySender().createTransaction();

		new CriteriaQuerySender().createTransaction();
	}

	private static void testValidation() {
		try {
			ValidationUtil.checkValidation();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}

