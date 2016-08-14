package pl.spring.projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.projekt.dao.ItemDAO;
import pl.spring.projekt.domain.Item;
import pl.spring.projekt.domain.ShoppingCart;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired 
	ItemDAO itemDAO;
	
	@Transactional
	public void addItem(Item item) {
		itemDAO.addItem(item);
		
	}

	@Transactional
	public List<Item> listItem(String login) {
		return itemDAO.listItem(login);
	}

	@Transactional
	public void removeItems(String login) {
		itemDAO.removeItems(login);
		
	}

	@Transactional
	public void removeItem(int id) {
		itemDAO.removeItem(id);
		
	}

	@Transactional
	public Item find(String name) {
		return itemDAO.find(name);
	}
	
	@Transactional
	public Item find(int id){
		return itemDAO.find(id);
	}

	@Transactional
	public void update(Item item) {
		itemDAO.update(item);
		
	}
	
	

}
