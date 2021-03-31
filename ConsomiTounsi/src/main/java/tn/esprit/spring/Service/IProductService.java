package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.*;

public interface IProductService {
	public 	String addProduct(Product p);

	public Iterable<Product> findAll();

	public List<Product> retrieveAllProducts();
	
	public String updateProduct(Product p);
	
	public String affectProduitToCategory(Long productId, Long catId);
	
	public List<Product> retrieveProductByCategory(Long idcc);
	
	public Rating getRating( Long id);
	
	public List<Product> listProductNotExpensive();
	
	public List<Product> listProductExpensive();

	
	public float SommeNote( Long idProduct);
	
	public Product getProductByName( String msg);

	void deleteProduct(long i);
	
	public String affectProduitToAdd(Long productId, Long addId);
	
	
	public String applyCouponOnAdd(Long productId, Long cId);
	
	public List<Product> retrieveProductWithCoupon (Long idc);

	public  Long top_note_product();
	
	public Optional<Product> getProdById(Long prodId);


}
