package tn.esprit.spring.Service;

import java.util.List;



import tn.esprit.spring.entities.*;

public interface IProductService {
	public 	String addProduct(Product p);

	
	public List<Product> retrieveAllProducts();
	
	public String updateProduct(Product p);

	
	public void affectProduitToCategory(Long productId, Long catId);
	
	public List<Product> retrieveProductByCategory(Long idcc);
	
	public float getRating( Long id);
	
	public List<Product> listProductNotExpensive();
	
	public float SommeNote( Long idProduct);
	
	public Product getProductByName( String msg);


	void deleteProduct(long i);


}
