package pl.spring.projekt.service;

import java.util.List;

import pl.spring.projekt.domain.Purchase;

public interface PurchaseService {
	
	public List<Purchase> findAllPurchases();
	public void add(Purchase purchase);
    public void remove(int id);
    

}
