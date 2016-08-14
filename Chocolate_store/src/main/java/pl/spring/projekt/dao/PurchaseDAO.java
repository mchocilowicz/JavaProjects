package pl.spring.projekt.dao;

import java.util.List;

import pl.spring.projekt.domain.Purchase;

public interface PurchaseDAO {
	
	public List<Purchase> findAllPurchases();
	public void add(Purchase purchase);
    public void remove(int id);
    
    
}
