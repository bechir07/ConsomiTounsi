package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Rayon;



public interface IRayonService {
	
	public int addRayon(Rayon r);
	public void deleteRayon(int i);	
	public Rayon updateRayon(Rayon r);
	public List<Rayon> getAllRayons();
	
	

}

