package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.Repository.CategoryRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.Repository.RayonRepository;
import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Rayon;




@Service
public class RayonServiceImpl implements IRayonService {
	
	@Autowired
	private RayonRepository rayonRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	

	@Override
	public int addRayon(Rayon r) {
		rayonRepository.save(r);
		return r.getId();
	}

	@Override
	public void deleteRayon(int i) {
		rayonRepository.deleteById(i);
		
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		rayonRepository.save(r);
		return r ;
	}

	@Override
	public List<Rayon> getAllRayons() {
		
		List<Rayon> Rayons = (List<Rayon>) rayonRepository.findAll();	
		return Rayons;
	}
	
	@Override
	public List<Rayon> getRayonBytype(String type) {
		List<Rayon> rayons = rayonRepository.findByType(type);
		return rayons;
		
	}

	@Override
	public Rayon findByCategory(int id)
	{
		Rayon rayon = rayonRepository.findByCategory(id);
		return rayon;
	}

	@Override
	public Rayon findByrayon(long id) {
		int products=rayonRepository.findByrayon(id);
		Rayon p=rayonRepository.findById(products).get();
		return p;
	}

	@Override
	public List<Product> findAllProductByrayon(int idr) {
		List<Product> products=new ArrayList<Product>();
		List<Long> productID =rayonRepository.findAllProductByrayon(idr);
		 for (int i = 0; i < productID.size(); i++) {
		      System.out.println(productID.get(i));
		     long p= productID.get(i);
		      Product product =productRepository.findById(p).get();
		      
		      products.add(product);
		      
		    }
		return products;
	}
	
	
	

}
