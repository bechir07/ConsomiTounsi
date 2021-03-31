package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Rayon;



public interface IRayonService {
	
	public int addRayon(Rayon r);
	public void deleteRayon(int i);	
	public Rayon updateRayon(Rayon r);
	public List<Rayon> getAllRayons();
	
	public Rayon findByrayon(long id);
	public List<Rayon> getRayonBytype(String type);
	public Rayon findByCategory(int id);
	public List<Product> findAllProductByrayon(int idr);
	
	

}

