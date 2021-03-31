package tn.esprit.spring.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	public List<Event> retrieveAllEvents() {
		List<Event> events = (List<Event>) EventRepository.findAll();	
		return events;
	}

	@Override
	public Event updateEvent(Event e) {
		EventRepository.save(e);
		return e ;
	}
	
	@Override
	public Map<String,Integer> getEventSortedByParticipation() {
		List<Event> eventList = (List<Event>) EventRepository.findAll();
		Map<String,Integer> m =new HashMap<>();
		
		for (Event e : eventList) {
			m.put(e.getName(),e.getUsersevent().size() );
		}
		Map<String,Integer> sortedMap= m.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap;
	}
	
	 @Override 
	    public int getNbreParticipantsByEvent(int eventId){
	    	
	    	Event event = EventRepository.findById(eventId).get();
	    	return event.getUsersevent().size();
	    	
	    }
	 
	 @Override
		public int getTauxParticpationPourEvent(int eventId){
			Event event = EventRepository.findById(eventId).get();
			int nbr = event.getUsersevent().size();
			System.out.println(nbr);
			int pr= nbr*2;//50/100 
			System.out.println(pr);
			return pr;
		}
	 @Override
		public Map<String,Integer> getMaxParticipationForEvent() {
			List<Event> eventList = (List<Event>) EventRepository.findAll();
			Map<String,Integer> m =new HashMap<>();
			int max=0;
			String name=null;
			for (Event e : eventList) {
				if(e.getUsersevent().size()>max){
					max=e.getUsersevent().size();
					name=e.getName();
				}
				
			}
			m.put(name,max);
			return m;
		}
	 

}
