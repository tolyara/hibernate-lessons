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
		
//		ProductM product1 = new ProductM("Laptop", new ProductCategoryM("Technical products"), new BigDecimal(10_000));
//		ProductM product2 = new ProductM("Cheese", new ProductCategoryM("Gastronomic products"), new BigDecimal(500));
//		session.save(product1);
//		session.save(product2);
	}
	
}
