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

import tn.esprit.spring.Service.JackpotServiceImpl;
import tn.esprit.spring.entities.Jackpot;

@RestController
@RequestMapping("/jackpot")
public class JackpotRestController {

	@Autowired
	JackpotServiceImpl jackpotService;
	
	@PostMapping("/addJackpot")
	public int addJackpot(@RequestBody Jackpot Jackpot) {
		return jackpotService.addJackpot(Jackpot);
		
	}
	
	@GetMapping("/getAllJackpot")
	public List<Jackpot> getAllJackpot() {

		return jackpotService.retrieveAllJackpots();
	}
	
	@DeleteMapping("/deleteJackpot/{id_Jackpot}") 
	public void deleteJackpot(@PathVariable("id_Jackpot") int id) {
		jackpotService.deleteJackpot(id);
	}
	
	@PutMapping(value="/updateJackpot") 
	public Jackpot updateJackpot(@RequestBody Jackpot j) {
		return jackpotService.updateJackpot(j);
	}
	
	@PutMapping(value = "/affecterEventAJackpot/{id}/{id}") 
	public void affecterEventAJackpot(@PathVariable("id")int eventId, @PathVariable("id")int jackpotId) {
		jackpotService.affecterEventAJackpot(eventId, jackpotId);
	}
	@PutMapping(value = "/desaffecterEventDuJackpot/{id}/{id}") 
	public void desaffecterEventDuJackpot(@PathVariable("id")int eventId, @PathVariable("id")int jackpotId) {
		jackpotService.desaffecterEventDuJackpot(eventId, jackpotId);
	}
	
	@PutMapping(value = "/affecterDonationAJackpot/{id}/{id}") 
	public void affecterDonationAJackpot(@PathVariable("id")int donationId, @PathVariable("id")int jackpotId) {
		jackpotService.affecterDonationAJackpot(donationId, jackpotId);
	}
	@PutMapping(value = "/desaffecterDonationDuJackpot/{id}/{id}") 
	public void desaffecterDonationDuJackpot(@PathVariable("id")int donationId, @PathVariable("id")int jackpotId) {
		jackpotService.desaffecterDonationDuJackpot(donationId, jackpotId);
	}
	@GetMapping(value = "getMaxDonationForJackpot/{id}")
	public String getMaxDonationForJackpot(@PathVariable("id")int jackpotId){
		double i = jackpotService.getMaxDonationForJackpot(jackpotId);
		return "La donation maximale de cet jackpot:["+ i +"]";
	}
}
