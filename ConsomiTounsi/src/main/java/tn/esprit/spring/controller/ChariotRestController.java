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

import tn.esprit.spring.Service.ChariotServiceImpl;
import tn.esprit.spring.entities.Chariot;

@RestController
@RequestMapping("/chariot")
public class ChariotRestController {
	
	@Autowired
	ChariotServiceImpl chariotService;
	
	@PostMapping("/addChariot")
	public int addChariot(@RequestBody Chariot chariot) {
		return chariotService.addChariot(chariot);
		
	}
	
	@GetMapping("/getAllChariot")
	public List<Chariot> getAllChariot() {

		return chariotService.retrieveAllChariots();
	}
	
	@DeleteMapping("/deleteChariot/{id_chariot}") 
	public void deleteChariot(@PathVariable("id_chariot") int id) {
		chariotService.deleteChariot(id);
	}
	
	@PutMapping(value="/updateChariot") 
	public Chariot updateChariot(@RequestBody Chariot c) {
		return chariotService.updateChariot(c);
	}
	
	@PutMapping(value = "/affecterChariotAEvent/{id}/{id}") 
	public void affecterChariotAEvent(@PathVariable("id")int eventId, @PathVariable("id")int chariotId) {
		chariotService.affecterChariotAEvent(eventId, chariotId);
	}
	@PutMapping(value = "/desaffecterChariotDuEvent/{id}/{id}") 
	public void desaffecterEventDuJackpot(@PathVariable("id")int eventId, @PathVariable("id")int chariotId) {
		chariotService.desaffecterChariotDuEvent(eventId, chariotId);
	}
	
	@PutMapping(value = "/affecterCommandAChariot/{id}/{id}") 
	public void affecterCommandAChariot(@PathVariable("id")Long commandId, @PathVariable("id")int chariotId) {
		chariotService.affecterCommandAChariot(commandId, chariotId);
	}
	@PutMapping(value = "/desaffecterEventDuChariot/{id}/{id}") 
	public void desaffecterCommandDuChariot(@PathVariable("id")Long commandId, @PathVariable("id")int chariotId) {
		chariotService.desaffecterCommandDuChariot(commandId, chariotId);
	}

}
