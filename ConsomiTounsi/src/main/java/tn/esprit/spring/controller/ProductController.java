package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tn.esprit.spring.helpers.ZXingHelper;
import tn.esprit.spring.Service.ProductServiceImpl;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Rating;




@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	
	//http://localhost:8081/ConsomiTounsi/addProduct
	@PostMapping("/addProduct")
	@ResponseBody
	public String addArticle(@RequestBody Product p) {
		
		return productService.addProduct(p);
	}
	
	//http://localhost:8081/ConsomiTounsi/retrieve-all-products
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Product> getProducts() {
	List<Product> list = productService.retrieveAllProducts();
	 return list;
	}
	
	//http://localhost:8081/ConsomiTounsi/deleteProduct/{id_product}
	@DeleteMapping("/deleteProduct/{id_product}") 
	@ResponseBody 
	public void deleteProduct(@PathVariable("id_product")Long id) {
		productService.deleteProduct(id);
	}

	//http://localhost:8081/ConsomiTounsi/updateProduct
	@PutMapping(value="/updateProduct") 
	@ResponseBody
	public void updateProduct(@RequestBody Product p) {
		productService.updateProduct(p);
	}
	
	//http://localhost:8081/ConsomiTounsi/affectProductCategory/{idProduct}/{catId}
	@PostMapping("/affectProductCategory/{idProduct}/{catId}") 
	@ResponseBody 
	public void affectProduitToCategory(@PathVariable("idProduct")Long idProduct,@PathVariable("catId") Long catId) {
		productService.affectProduitToCategory(idProduct, catId);
		
	}
	
	// http://localhost:8081/ConsomiTounsi/retrieve-products-by-category/{id}
		@GetMapping(value = "/retrieve-products-by-category/{id}")
		@ResponseBody
		public List<Product> getProductsByCategory(@PathVariable("id") Long id) {

			return productService.retrieveProductByCategory(id);

		}
		
		
		//http://localhost:8081/ConsomiTounsi/retrieve-rating-product/{id}
		@GetMapping(value ="/retrieve-rating-product/{id}")
		@ResponseBody
		public Rating getRatingProduct(@PathVariable("id") Long id) 
		{
		
		return productService.getRating(id);
	    
		}
		
		//http://localhost:8081/ConsomiTounsi/retrieve-product-not-expensive
		@GetMapping(value ="/retrieve-product-not-expensive")
		@ResponseBody
		public List<Product> getProductNotExpensive() 
		{
		
		return productService.listProductNotExpensive();	    
		} 
		//http://localhost:8081/ConsomiTounsi/retrieve-product-expensive
				@GetMapping(value ="/retrieve-product-expensive")
				@ResponseBody
				public List<Product> getProductExpensive() 
				{
				
				return productService.listProductExpensive();	    
				}
		
		
		//http://localhost:8081/ConsomiTounsi/retrieve-product-note/{id}
		@GetMapping(value ="/retrieve-product-note/{id}")
		@ResponseBody
		public float getNoteProduct(@PathVariable("id") Long id) 
		{
				
		return productService.SommeNote(id);
			    
		}
		

				//http://localhost:8081/ConsomiTounsi/retrieve-product-by-name/{name}
		    	@GetMapping(value="/retrieve-product-by-name/{name}")
		    	@ResponseBody
		    	public Product getProductByName(@PathVariable("name") String name) {
		    	return productService.getProductByName(name);
		}
		    	
		    	//http://localhost:8081/ConsomiTounsi/affectAdd/{productId}/{addId}
		    	@PostMapping("/affectAdd/{productId}/{addId}") 
		    	@ResponseBody 
		    	public void affectProduitToAdd(@PathVariable("productId")Long productId,@PathVariable("addId") Long addId) {
		    		productService.affectProduitToAdd(productId, addId);
		    	}
		    	
		    	//http://localhost:8081/ConsomiTounsi/barcode/{id}
		    	@RequestMapping(value = "/barcode/{id}", method = RequestMethod.GET)
		    	public void barcode(@PathVariable("id") Long id, HttpServletResponse response) throws Exception {
		    		response.setContentType("image/png");
		    		OutputStream outputStream = response.getOutputStream();
		    		outputStream.write(ZXingHelper.getBarCodeImage(id.toString(), 200, 200));
		    		outputStream.flush();
		    		outputStream.close();
		    	}
		    	
		    	//http://localhost:8081/ConsomiTounsi/qrcode/{id}
		    	@RequestMapping(value = "/qrcode/{id}", method = RequestMethod.GET)
		    	public void qrcode(@PathVariable("id") Long id, HttpServletResponse response) throws Exception {
		    		response.setContentType("image/png");
		    		OutputStream outputStream = response.getOutputStream();
		    		outputStream.write(ZXingHelper.getQRCodeImage(id.toString(), 200, 200));
		    		outputStream.flush();
		    		outputStream.close();
		    	}
		    	
		    	//http://localhost:8081/ConsomiTounsi/applyCouponOnAdd/{productId}/{cId}
		    	@PostMapping("/applyCouponOnAdd/{productId}/{cId}") 
		    	@ResponseBody 
		    	public void applyCouponOnAdd(@PathVariable("productId")Long idProduct,@PathVariable("cId") Long cId)
		    	{
		    			   productService.applyCouponOnAdd(idProduct, cId);
		    	}
		    	
		    	
		    	
		    	
		    	// http://localhost:8081/ConsomiTounsi/retrieve-products-with-coupon/{id}
				@GetMapping(value = "/retrieve-products-with-coupon/{id}")
				@ResponseBody
				public List<Product> retrieveProductWithCoupon(@PathVariable("id") Long id) {

					return productService.retrieveProductWithCoupon(id);

				}
		    	
				//http://localhost:8081/ConsomiTounsi/top_note_product
				@GetMapping(value = "/top_note_product")
				@ResponseBody
				public Optional<Product> top_note_product() {
				 Long l = productService.top_note_product();
					Optional<Product> prod = productService.getProdById(l);
					return prod;

				}
}
