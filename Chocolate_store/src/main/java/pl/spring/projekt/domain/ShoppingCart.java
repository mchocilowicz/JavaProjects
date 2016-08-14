package pl.spring.projekt.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ShoppingCart {
	
	private Map<Item, Integer> contents = new HashMap<Item, Integer>();

	public Map<Item, Integer> getContents() {
		return contents;
	}
	
	public Set<Item> getProducts() {
		return contents.keySet();
	}
	
	public void addProduct(Item item, int count) {
		
		
		
		if (contents.containsKey(item.getId())) {
			contents.put(item,  contents.get(item)+count);
		} 
		else {
			contents.put(item, count);
		}
		
	}
	
	
	public void removeProduct(Item item) {
		contents.remove(item);
	}
	
	public void clearCart() {
		contents.clear();
	}
	
	@Override
	public String toString() {
		return contents.toString();
	}
	
	public double getTotalCost() {
		double totalCost = 0;
		for (Item item : contents.keySet()) {
			totalCost += item.getPrice();
		}
		return totalCost;
	}
}