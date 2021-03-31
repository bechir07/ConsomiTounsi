package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.ChariotRepository;
import tn.esprit.spring.Repository.EventRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.entities.Chariot;
import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;

@Service
public class ChariotServiceImpl implements IChariotService {

	@Autowired
	private ChariotRepository ChariotRepository;
	@Autowired
	private EventRepository EventRepository;
	@Autowired
	private CommandRepository CommandRepository;
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
	public void desaffecterChariotDuEvent(int eventId, int chariotId)
	{
		Event event = EventRepository.findById(eventId).get();
		Chariot chariot = ChariotRepository.findById(chariotId).get();
		if (!ObjectUtils.isEmpty(chariot) && !ObjectUtils.isEmpty(event)) {
        //departement.getEmployes().remove(departement.getEmployes().indexOf(employe));
		event.setChariotev(null);
		EventRepository.save(event);
			
		}
	}
	
	@Override	
	public void affecterCommandAChariot(Long commandId, int chariotId) {
			
			
			Chariot chariot = ChariotRepository.findById(chariotId).get();
			Command command = CommandRepository.findById(commandId).get();
			if (!ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(chariot)) {
				command.setChariot(chariot);
				CommandRepository.save(command);
			}
		}
	
	@Override
	public void desaffecterCommandDuChariot(Long commandId, int chariotId)
	{
		
		 Command command = CommandRepository.findById(commandId).get();
		Chariot chariot = ChariotRepository.findById(chariotId).get();
		if (!ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(chariot)) {
			command.setChariot(null);
			CommandRepository.save(command);
		}
	}
	
	
}
