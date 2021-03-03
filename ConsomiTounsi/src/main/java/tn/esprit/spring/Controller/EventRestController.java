package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.EventServiceImpl;
import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Event;



@RestController
@RequestMapping("/event")
public class EventRestController {
	
	@Autowired
	EventServiceImpl eventService;
	
	@PostMapping("/addEvent")
	public int addEvent(@RequestBody Event event) {
		return eventService.addEvent(event);
		
	}

}
