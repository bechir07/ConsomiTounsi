package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.*;

public interface IProductService {
	public 	String addProduct(Product p);

	
	public List<Product> retrieveAllProducts();
	
	public String updateProduct(Product p);

	void deleteProduct(long i);

}
