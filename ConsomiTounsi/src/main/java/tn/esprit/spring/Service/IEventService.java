package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Event;


public interface IEventService {
	
	public int addEvent(Event e);

	public void deleteEvent(int i);
	
	public List<Event> retrieveAllEvents();
	
	public Event updateEvent(Event e);

}
