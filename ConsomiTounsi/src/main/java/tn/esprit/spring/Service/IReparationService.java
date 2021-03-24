package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Reparation;


public interface IReparationService {

	public int addReparation(Reparation r);
	public void deleteReparation(int i);
	public Reparation updateReparation(Reparation r);
	public List<Reparation> getAllReparations();
	
}
