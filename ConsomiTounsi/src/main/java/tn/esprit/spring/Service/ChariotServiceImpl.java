package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.ChariotRepository;
import tn.esprit.spring.Repository.EventRepository;
import tn.esprit.spring.entities.Chariot;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;

@Service
public class ChariotServiceImpl implements IChariotService {

	@Autowired
	private ChariotRepository ChariotRepository;
	@Autowired
	private EventRepository EventRepository;
	@Override
	public int addChariot(Chariot c) {
		ChariotRepository.save(c);
		return c.getId();
	}

	@Override
	public void deleteChariot(int i) {
		ChariotRepository.deleteById(i);
		
	}

	@Override
	public List<Chariot> retrieveAllChariots() {
		List<Chariot> chariots = (List<Chariot>) ChariotRepository.findAll();	
		return chariots;
	}

	@Override
	public Chariot updateChariot(Chariot c) {
		ChariotRepository.save(c);
		return c ;
	}
	
	@Override
	public void affecterChariotAEvent(int eventId, int chariotId) {
		Chariot chariot = ChariotRepository.findById(chariotId).get();
		Event event = EventRepository.findById(eventId).get();
		System.out.println(event);
		if (!ObjectUtils.isEmpty(chariot) && !ObjectUtils.isEmpty(event)) {
			event.setChariotev(chariot);
			EventRepository.save(event);
		}
	}
	
	@Override
	public void desaffecterChariotDuEvent(int chariotId, int eventId)
	{
		Event event = EventRepository.findById(eventId).get();
		Chariot chariot = ChariotRepository.findById(chariotId).get();
		if (!ObjectUtils.isEmpty(chariot) && !ObjectUtils.isEmpty(event)) {
        //departement.getEmployes().remove(departement.getEmployes().indexOf(employe));
		event.setChariotev(null);
		EventRepository.save(event);
			
		}
	}
	
	
}
