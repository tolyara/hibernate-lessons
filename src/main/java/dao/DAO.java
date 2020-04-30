package main.java.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.java.util.HibernateUtil;

public abstract class DAO {

	private final Logger logger = Logger.getLogger(this.getClass());

	abstract void createQuery(Session session);

	public void createTransaction() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			createQuery(session);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace(System.out);
			logger.error("Transaction failed...");
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
