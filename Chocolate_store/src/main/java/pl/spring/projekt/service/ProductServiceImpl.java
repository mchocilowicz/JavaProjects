package pl.spring.projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.projekt.dao.ProductDAO;
import pl.spring.projekt.domain.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO productDAO;
	
	@Transactional
	public void addProduct(Product product) {
		productDAO.addProduct(product);
		
	}

	@Transactional
	public List<Product> listProduct() {
		return productDAO.listProduct();
	}

	@Transactional
	public void removeProduct(int id) {
		productDAO.removeProduct(id);
	}

	@Transactional
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	@Transactional
	public void editProduct(Product product) {
		productDAO.editProduct(product);
		
	}

}
