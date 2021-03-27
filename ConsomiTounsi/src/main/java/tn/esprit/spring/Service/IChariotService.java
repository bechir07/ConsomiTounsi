package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Chariot;



public interface IChariotService {

	public int addChariot(Chariot c);

	public void deleteChariot(int i);
	
	public List<Chariot> retrieveAllChariots();
	
	public Chariot updateChariot(Chariot c);
	
	public void affecterChariotAEvent(int eventId, int chariotId);
	
	public void desaffecterChariotDuEvent(int chariotId, int eventId);
}
