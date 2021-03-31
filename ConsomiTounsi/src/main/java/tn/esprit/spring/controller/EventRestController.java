package tn.esprit.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.EventServiceImpl;
import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Payment;
import tn.esprit.spring.entities.Product;



@RestController
@RequestMapping("/event")
public class EventRestController {
	
	@Autowired
	EventServiceImpl eventService;
	
	@PostMapping("/addEvent")
	public int addEvent(@RequestBody Event event) {
		return eventService.addEvent(event);
		
	}
	
	@GetMapping("/getAllEvent")
	public List<Event> getAllEvent() {

		return eventService.retrieveAllEvents();
	}
	
	@DeleteMapping("/deleteEvent/{id_event}") 
	public void deleteEvent(@PathVariable("id_event") int id) {
		eventService.deleteEvent(id);
	}
	
	@PutMapping(value="/updateEvent") 
	public Event updateEvent(@RequestBody Event e) {
		return eventService.updateEvent(e);
	}

	@GetMapping(value = "/getNbreParticipantsByEvent/{id}")
	public String getNbreParticipantsByEvent(@PathVariable("id")int eventId){
		int i = eventService.getNbreParticipantsByEvent(eventId);
		return "Le nombre du participants du evenement:["+ i +"]";
	}
	
	@GetMapping(value = "/getEventSortedByParticipation")
	public Map<String,Integer> getEventSortedByParticipation(){
		return eventService.getEventSortedByParticipation();
	}
	
	@GetMapping(value = "/getTauxParticpationPourEvent/{id}")
	public String getTauxParticpationPourEvent(@PathVariable("id")int eventId){ 
		int i = eventService.getTauxParticpationPourEvent(eventId);
		return "Le taux d'occupation de cet evenement est :["+ i +"%]";
	}

	@GetMapping(value = "/getMaxParticipationForEvent")
	public Map<String,Integer> getMaxParticipationForEvent(){
		return eventService.getMaxParticipationForEvent();
	}
}
