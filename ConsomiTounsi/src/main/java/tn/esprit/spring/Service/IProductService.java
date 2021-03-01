package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.*;

public interface IProductService {
	public int addProduct(Product p);

	public void deleteProduct(int i);
	
	public List<Product> retrieveAllProducts(int id);
	
	public Product updateProduct(Product p);

}
