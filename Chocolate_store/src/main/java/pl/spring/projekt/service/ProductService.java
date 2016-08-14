package pl.spring.projekt.service;

import java.util.List;

import pl.spring.projekt.domain.Product;



public interface ProductService {
	
	public void addProduct(Product product);
	public List<Product> listProduct();
	public void removeProduct (int id);
	public Product getProduct(int id);
	public void editProduct(Product product);

}
