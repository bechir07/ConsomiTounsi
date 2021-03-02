package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.EventRepository;
import tn.esprit.spring.entities.Event;


@Service
public class EventServiceImpl implements IEventService{
	
	@Autowired
	private EventRepository EventRepository;
	@Override
	public int addEvent(Event e) {
		EventRepository.save(e);
		return e.getId();
	}

	@Override
	public void deleteEvent(int i) {
		EventRepository.deleteById(i);
		
	}

	@Override
	public List<Event> retrieveAllEvents(int id) {
		List<Event> events = (List<Event>) EventRepository.findAll();	
		return events;
	}

	@Override
	public Event updateEvent(Event e) {
		EventRepository.save(e);
		return e ;
	}

}
