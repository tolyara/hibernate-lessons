package main.java.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.models.magazine.ProductCategoryM;
import main.java.models.magazine.ProductM;

public class HqlQuerySender extends DAO {

	/**
	 * from ProductM as p where p.id = 1
	 * from product p inner join p.productCategory pc
	 * from ProductM p inner join fetch p.productCategory pc with pc.id = 1
	 */
	@Override
	void createQuery(Session session) {
		doUpdate(session);
	}
	
	@Override
	protected void doSelect(Session session) {
//		Query query = session.createQuery("from ProductM as p");
//		List<ProductM> products = query.list();
		
		Query query = session.createQuery("select p from ProductM p where p.id > ?1");
		query.setParameter(1, 2L);
		List<ProductM> products = query.list();
		
		System.out.println("Selected products: ");
		for(ProductM product : products) {
			System.out.println(product);
		}
		
		query.uniqueResult();
	}
	
	@Override
	protected void doUpdate(Session session) {
		ProductM product = new ProductM(1L);
		product.setTitle("Cheese");
		product.setPrice(new BigDecimal(550)); // value for update
		product.setProductCategory(new ProductCategoryM(1L));
		
//		session.save(product);
		session.update(product);
//		session.delete(product);
	}
	
}
