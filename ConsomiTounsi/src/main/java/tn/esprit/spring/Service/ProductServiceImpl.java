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
	public void deleteProduct(int i) {
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

}
