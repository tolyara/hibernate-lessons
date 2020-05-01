package main.java.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import main.java.util.HibernateUtil;

// pattern Template Method
public abstract class DAO {

	private static final Logger logger = LogManager.getLogger("DAO_Logger");

	abstract void createQuery(Session session);
	
	protected abstract void doSelect(Session session);
	
	protected abstract void doUpdate(Session session);

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
