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
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.ParticipationServiceImpl;
import tn.esprit.spring.entities.Participation;

@RestController
@RequestMapping("/participation")
public class ParticipationRestController {
	
	@Autowired
	ParticipationServiceImpl participationService;
	
	@PostMapping("/addParticipation")
	public int addParticipation(@RequestBody Participation Participation) {
		return participationService.addParticipation(Participation);
		
	}
	
	@GetMapping("/getAllParticipation")
	public List<Participation> getAllParticipation() {

		return participationService.retrieveAllParticipations();
	}
	
	@DeleteMapping("/deleteParticipation/{id_Participation}") 
	public void deleteParticipation(@PathVariable("id_Participation") int id) {
		participationService.deleteParticipation(id);
	}
	
	@PutMapping(value="/updateParticipation") 
	public Participation updateParticipation(@RequestBody Participation p) {
		return participationService.updateParticipation(p);
	}

}
