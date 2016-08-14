package pl.spring.projekt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.spring.projekt.domain.Purchase;
import pl.spring.projekt.domain.User;


@Repository
public class PurchaseDAOImpl implements PurchaseDAO {

	@Autowired
	SessionFactory sessionFactory;

	
	public List<Purchase> findAllPurchases() {
		   return sessionFactory.getCurrentSession().createQuery("from Purchase order by date").list();
	}

	
	public void add(Purchase purchase) {
		 sessionFactory.getCurrentSession().save(purchase);
		
	}

	
	public void remove(int id) {
		Purchase purchase = (Purchase) sessionFactory.getCurrentSession().load(
				 Purchase.class, id);
	        if (null != purchase) {
	            sessionFactory.getCurrentSession().delete(purchase);
	        }
		
	}
	
	}
