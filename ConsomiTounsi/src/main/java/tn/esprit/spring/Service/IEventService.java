package tn.esprit.spring.Service;

import java.util.List;
import java.util.Map;

import tn.esprit.spring.entities.Event;


public interface IEventService {
	
	public int addEvent(Event e);

	public void deleteEvent(int i);
	
	public List<Event> retrieveAllEvents();
	
	public Event updateEvent(Event e);
	
	public int getNbreParticipantsByEvent(int eventId);
	
	public Map<String,Integer> getEventSortedByParticipation();
	
	public int getTauxParticpationPourEvent(int eventId);
	
	public Map<String,Integer> getMaxParticipationForEvent();

}
