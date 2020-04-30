package main.java;

import org.hibernate.SessionFactory;

import main.java.dao.CriteriaQuerySender;
import main.java.util.HibernateUtil;

/**
 * 
 * 1 - configs 2 - mapping (XML, annotations) 3 - transactions 4 - ORM 5 -
 * queries (SQL, HQL, criteria)
 *
 */
public class Main {

	public static void main(String[] args) {
		testQueries();
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

}



//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
