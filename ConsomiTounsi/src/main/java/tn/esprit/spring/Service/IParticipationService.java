package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Participation;

public interface IParticipationService {

	public int addParticipation(Participation p);

	public void deleteParticipation(int i);
	
	public List<Participation> retrieveAllParticipations();
	
	public Participation updateParticipation(Participation p);
}
