package pl.spring.projekt.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.spring.projekt.domain.Product;


@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
    SessionFactory sessionFactory;
	
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}
		 
	public List<Product> listProduct() {
		 return sessionFactory.getCurrentSession().createQuery("from Product order by id").list();
	}
		 
	public void removeProduct(int id) {
		 Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
		 if (null != product) {
			 sessionFactory.getCurrentSession().delete(product);
		 }
	}
	
	public Product getProduct(int id) {
		 return (Product)sessionFactory.getCurrentSession().get(Product.class, id);
	}
		    
	public void editProduct(Product product) {
		 sessionFactory.getCurrentSession().update(product);
	}
			
		  
	
}
