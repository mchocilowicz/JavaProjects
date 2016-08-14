package pl.spring.projekt.dao;

import java.util.List;

import pl.spring.projekt.domain.Product;



public interface ProductDAO {

	public void addProduct(Product product);
	public List<Product> listProduct();
	public void removeProduct (int id);
	public Product getProduct(int id);
	public void editProduct(Product product);
	
}
