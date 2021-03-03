package tn.esprit.spring.controller;

import java.util.List;

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

}
