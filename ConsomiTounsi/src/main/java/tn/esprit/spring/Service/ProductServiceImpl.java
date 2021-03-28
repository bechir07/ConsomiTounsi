package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CouponRepository;
import tn.esprit.spring.Repository.CategoryRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.Repository.AddRepository;
import tn.esprit.spring.entities.Add;
import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Coupon;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Rating;

@Service
public class ProductServiceImpl  implements IProductService{

	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private CategoryRepository CatRepository;
	@Autowired
	private AddRepository AddRepository;
	@Autowired
	private CouponRepository CouponRepository;
	private static final Logger l=LogManager.getLogger(ProductServiceImpl.class);
	
	@Override
	public String addProduct(Product p) {
		if(p.getReference().startsWith("619")) 
		{
		ProductRepository.save(p);
		return "product added successfuly";
		}
		else
		{
			return "non-tunisien product";
		}
		
	}

	@Override
	public void deleteProduct(long i) {

		ProductRepository.deleteById(i);
		
	}

	@Override
	public List<Product> retrieveAllProducts() {
		List<Product> products = (List<Product>) ProductRepository.findAll();	
		return products;
	}

	@Override
	public String updateProduct(Product p) {
		if(p.getReference().startsWith("619")) 
		{
		ProductRepository.save(p);
		return "product added successfuly";
		}
		else
		{
			return "non-tunisien product";
		}
	}


	@Override
	public void affectProduitToCategory(Long productId, Long catId)
	{
		Category categoryEntity = CatRepository.findById(catId).get();
		Product productEntity = ProductRepository.findById(productId).get();

		if(categoryEntity.getProduct() == null){

			List<Product> products = new ArrayList<>();
			 products.add(productEntity);
			categoryEntity.setProduct(products);
		}else{

			categoryEntity.getProduct().add(productEntity);

		}
		
		
	}

	@Override
	public List<Product> retrieveProductByCategory(Long  idc) {
		Category c = CatRepository.findById(idc).get();
		List<Product> products = (List<Product>) ProductRepository.retrieveProductByCategory(c);
		for (Product p : products){
			l.info("product +++"+p);
		}
		return products;
	}

	@Override
	public float getRating(Long id) {
		return ProductRepository.getRating(id);
	}

	@Override
	public List<Product> listProductNotExpensive() {
		List<Product> products = (List<Product>) ProductRepository.listProductNotExpensive();	
		return products;
	}

	@Override
	public float SommeNote(Long idProduct) {
		return ProductRepository.SommeNote(idProduct);
	}

	@Override
	public Product getProductByName(String msg) {
		return ProductRepository.getProductByName(msg);
	}

	@Override
	public void affectProduitToAdd(Long productId, Long addId)
	{
		Add addEntity = AddRepository.findById(addId).get();
		Product productEntity = ProductRepository.findById(productId).get();


		if(productEntity.getAdd() == null){

			List<Add> adds = new ArrayList<>();
			 adds.add(addEntity);
			productEntity.setAdd(adds);
		}else{

			productEntity.getAdd().add(addEntity);

		}
	}


		@Override
		public List<Product> listProductExpensive() {
			List<Product> products = (List<Product>) ProductRepository.listProductExpensive();	
			return products;
		}
		
}
