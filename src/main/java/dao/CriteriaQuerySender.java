package main.java.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import main.java.models.magazine.ProductCategoryM;
import main.java.models.magazine.ProductM;

public class CriteriaQuerySender extends DAO {

	@Override
	void createQuery(Session session) {
		
	}

	@Override
	protected void doSelect(Session session) {
		Criteria criteria = session.createCriteria(ProductCategoryM.class, "productCategory");
		criteria.createCriteria("productCategory.products", "product");
		criteria.add(Restrictions.eq("productCategory.title", "Technical products"));
		criteria.setProjection(Projections.distinct(Projections.property("product.title")));

		List<Object> results = criteria.list();

		for (Object resultElement : results) {
			System.out.println(resultElement);
		}
	}

	@Override
	protected void doUpdate(Session session) {
		Criteria criteria = session.createCriteria(ProductM.class);
		ProductM product = (ProductM) criteria.add(Restrictions.eq("title", "Cheese")).uniqueResult();
		product.setPrice(new BigDecimal(530));
		session.saveOrUpdate(product);
	}

}





















//Criteria criteria = session.createCriteria(ProductM.class);
//Criteria criteria = session.createCriteria(ProductM.class, "p"); //alias

//criteria.add(Restrictions.eq("title", "Cheese"));
//criteria.add(Restrictions.eq("productCategory", new ProductCategoryM(2L)));
//criteria.add(Restrictions.between("price", new BigDecimal(520), new BigDecimal(20_000)));
//criteria.add(Restrictions.in("id", 2L, 3L));
//criteria.add(Restrictions.sqlRestriction("id > 2"));

//criteria.addOrder(Order.desc("id"));
//criteria.setFirstResult(1); // offset
//criteria.setMaxResults(2);  // limit
//criteria = criteria.setProjection(Projections.property("title"));