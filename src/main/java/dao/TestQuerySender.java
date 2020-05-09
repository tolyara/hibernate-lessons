package main.java.dao;

import org.hibernate.Session;

import main.java.models.magazine.UserM;

public class TestQuerySender extends DAO {

	@Override
	void createQuery(Session session) {
		UserM user1 = new UserM("John", 30);
		UserM user2 = new UserM("Mary", 24);
		session.save(user1);
		session.save(user2);
	}

	@Override
	protected void doSelect(Session session) {
		
	}

	@Override
	protected void doUpdate(Session session) {
		
	}
	
}
