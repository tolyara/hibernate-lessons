package main.java.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import main.java.models.magazine.ProductM;

@SuppressWarnings("deprecation")
public class SqlQuerySender extends DAO {

	@Override
	void createQuery(Session session) {		
		doUpdate(session);		
	}

	@Override
	protected void doSelect(Session session) {		
		SQLQuery query = session.createSQLQuery(
				"select {p.*}, {pc.*} from product_m p inner join product_category_m pc on p.product_category_id = pc.id");
		query.addEntity("p", ProductM.class);
		query.addJoin("pc", "p.productCategory");
		List<Object[]> queryResults = query.list();

		System.out.println("Selected products: ");
		for (Object[] result : queryResults) {
			System.out.println(
					"product - ".toUpperCase() + result[0] + ", product category - ".toUpperCase() + result[1]);
		}
	}
	
	protected void doUpdate(Session session) {
		
		SQLQuery query = session.createSQLQuery("insert into product_m(id, title, product_category_id, price) values (:id, :title, :product_category_id, :price)");
		query.setParameter("id", 4);
		query.setParameter("title", "Bread");
		query.setParameter("product_category_id", 1);
		query.setParameter("price", 60);
		query.executeUpdate();
	}

}




















//SQLQuery query = session.createSQLQuery("select p.* from product_m p");
//query.addEntity("p", ProductM.class);
//List<ProductM> products = query.list();





//SQLQuery query = session.createSQLQuery("insert into product_category_m(id, title) values (2, 'Technical products')");
//query.executeUpdate();

//SQLQuery query = session.createSQLQuery("insert into product_m(id,  title, product_category_id, price) values (2, 'Keyboard', 2, 500)");
//query.executeUpdate();
