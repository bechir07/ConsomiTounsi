package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Rating;

@Service
public class ProductServiceImpl  implements IProductService{

	@Autowired
	private ProductRepository ProductRepository;
	@Override
	public int addProduct(Product r) {
		ProductRepository.save(r);
		return r.getId();
	}

	@Override
	public void deleteProduct(int i) {
		ProductRepository.deleteById(i);
		
	}

	@Override
	public List<Product> retrieveAllProducts(int id) {
		List<Product> products = (List<Product>) ProductRepository.findAll();	
		return products;
	}

	@Override
	public Product updateProduct(Product p) {
		ProductRepository.save(p);
		return p ;
	}

}
