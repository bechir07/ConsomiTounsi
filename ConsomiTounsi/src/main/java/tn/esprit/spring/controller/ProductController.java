package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.ProductServiceImpl;
import tn.esprit.spring.entities.Product;




@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	
	//http://localhost:8081/ConsomiTounsi/servlet/addProduct
	@PostMapping("/addProduct")
	@ResponseBody
	public String addArticle(@RequestBody Product p) {
		
		return productService.addProduct(p);
	}
	
	//http://localhost:8081/ConsomiTounsi/servlet/retrieve-all-products
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Product> getProducts() {
	List<Product> list = productService.retrieveAllProducts();
	 return list;
	}
	
	//http://localhost:8081/ConsomiTounsi/servlet/deleteProduct/{id_product}
	@DeleteMapping("/deleteProduct/{id_product}") 
	@ResponseBody 
	public void deleteProduct(@PathVariable("id_product")Long id) {
		productService.deleteProduct(id);
	}

	//http://localhost:8081/ConsomiTounsi/servlet/updateProduct
	@PutMapping(value="/updateProduct") 
	@ResponseBody
	public void updateProduct(@RequestBody Product p) {
		productService.updateProduct(p);
	}
	
	//http://localhost:8081/ConsomiTounsi/servlet/deleteProduct/{id_product}
	@PostMapping("/affectProductCategory/{productId}/{catId}") 
	@ResponseBody 
	public void affectProduitToCategory(@PathVariable("productId")Long idProduct,@PathVariable("catId") Long idCat) {
		productService.affectProduitToCategory(idProduct, idCat);
	}
	
	// http://localhost:8081/ConsomiTounsi/servlet/retrieve-products-by-category
		@GetMapping(value = "/retrieve-products-by-category")
		@ResponseBody
		public List<Product> getProductsByCategory(@PathVariable("id") Long id) {

			return productService.retrieveProductByCategory(id);

		}
		
		
		//http://localhost:8081/ConsomiTounsi/servlet/retrieve-rating-product
		@GetMapping(value ="/retrieve-rating-product")
		@ResponseBody
		public float getRatingProduct(@PathVariable("id") Long id) 
		{
		
		return productService.getRating(id);
	    
		}
		
		//http://localhost:8081/ConsomiTounsi/servlet/retrieve-product-not-expensive
		@GetMapping(value ="/retrieve-product-not-expensive")
		@ResponseBody
		public List<Product> getProductNotExpensive() 
		{
		
		return productService.listProductNotExpensive();	    
		} 
		
		
		
		//http://localhost:8081/ConsomiTounsi/servlet/retrieve-product-note
		@GetMapping(value ="/retrieve-product-note")
		@ResponseBody
		public float getNoteProduct(@PathVariable("id") Long id) 
		{
				
		return productService.SommeNote(id);
			    
		}
		

		//http://localhost:8081/ConsomiTounsi/servlet/retrieve-product-by-name
		    	@GetMapping(value="/retrieve-product-by-name/{name}")
		    	@ResponseBody
		    	public Product getProductByName(@PathVariable("name") String name) {
		    	return productService.getProductByName(name);
		}
		    	
		
		    	
}
