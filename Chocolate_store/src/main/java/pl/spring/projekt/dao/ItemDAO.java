package pl.spring.projekt.dao;


import java.util.List;

import pl.spring.projekt.domain.Item;
import pl.spring.projekt.domain.ShoppingCart;
import pl.spring.projekt.domain.User;



public interface ItemDAO {
	
	public void addItem(Item item);
	public List<Item> listItem(String login);
	public void removeItems(String login);
	public void removeItem(int id);
	public Item find(String name);
	public Item find(int id);
	public void update(Item item);
	

}
