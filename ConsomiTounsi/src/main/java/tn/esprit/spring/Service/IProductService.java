package tn.esprit.spring.Service;

import java.util.List;



import tn.esprit.spring.entities.*;

public interface IProductService {
	public 	String addProduct(Product p);

	
	public List<Product> retrieveAllProducts();
	
	public String updateProduct(Product p);
<<<<<<< HEAD

=======
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git
	
	public void affectProduitToCategory(Long productId, Long catId);
	
	public List<Product> retrieveProductByCategory(Long idcc);
	
	public float getRating( Long id);
	
	public List<Product> listProductNotExpensive();
	
	public float SommeNote( Long idProduct);
	
	public Product getProductByName( String msg);
<<<<<<< HEAD

=======
>>>>>>> branch 'main' of https://github.com/bechir07/ConsomiTounsi.git

	void deleteProduct(long i);
	public void affectProduitToAdd(Long productId, Long addId);

}
