package pl.spring.projekt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.spring.projekt.domain.Item;
import pl.spring.projekt.domain.ShoppingCart;
import pl.spring.projekt.domain.UserRole;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
    SessionFactory sessionFactory;
	
	public void addItem(Item item){
		sessionFactory.getCurrentSession().save(item);
	}
	@SuppressWarnings("unchecked")
	public List<Item> listItem(String login){
		List<Item> items = new ArrayList<Item>();
		
		items = sessionFactory.getCurrentSession()
							   .createQuery("from Item where orderBy=?")
							   .setParameter(0, login)
							   .list();
		
		
		return items;
	}
	
	public void removeItems(String login){
		sessionFactory.getCurrentSession().delete("from Item e where e.orderBy = '"+login+"'");
	}
	
	public void removeItem(int id){
		Item item = (Item) sessionFactory.getCurrentSession().load(Item.class, id);
		 if (null != item) {
			 sessionFactory.getCurrentSession().delete(item);
		 }
	}
	
	@SuppressWarnings("unchecked")
	public Item find(String name) {
		
		return (Item) sessionFactory.getCurrentSession()
	  			.createQuery("from Item where name=?")
	  			.setParameter(0, name).uniqueResult();
	}
	
	public Item find(int id){
		return (Item)sessionFactory.getCurrentSession().get(Item.class, id);
		
	}
	
	public void update(Item item) {
		sessionFactory.getCurrentSession().update(item);
		
	}
	
	
}
