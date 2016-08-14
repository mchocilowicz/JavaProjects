package pl.spring.projekt.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.projekt.dao.PurchaseDAO;
import pl.spring.projekt.domain.Product;
import pl.spring.projekt.domain.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseDAO purchaseDAO;

	@Transactional
	public List<Purchase> findAllPurchases() {
		return purchaseDAO.findAllPurchases();
	}

	@Transactional
	public void add(Purchase purchase) {
		purchaseDAO.add(purchase);
		
	}

	@Transactional
	public void remove(int id) {
		purchaseDAO.remove(id);
		
	}
	
	
}
