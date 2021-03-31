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
	
	@PutMapping(value = "/affecterEventAJackpot/{eventId}/{jackpotId}") 
	public void affecterEventAJackpot(@PathVariable("eventId")int eventId, @PathVariable("jackpotId")int jackpotId) {
		jackpotService.affecterEventAJackpot(eventId, jackpotId);
	}
	@PutMapping(value = "/desaffecterEventDuJackpot/{eventId}/{jackpotId}") 
	public void desaffecterEventDuJackpot(@PathVariable("eventId")int eventId, @PathVariable("jackpotId")int jackpotId) {
		jackpotService.desaffecterEventDuJackpot(eventId, jackpotId);
	}
	
	@PutMapping(value = "/affecterDonationAJackpot/{donationId}/{jackpotId}") 
	public void affecterDonationAJackpot(@PathVariable("donationId")int donationId, @PathVariable("jackpotId")int jackpotId) {
		jackpotService.affecterDonationAJackpot(donationId, jackpotId);
	}
	@PutMapping(value = "/desaffecterDonationDuJackpot/{donationId}/{jackpotId}") 
	public void desaffecterDonationDuJackpot(@PathVariable("donationId")int donationId, @PathVariable("jackpotId")int jackpotId) {
		jackpotService.desaffecterDonationDuJackpot(donationId, jackpotId);
	}
	@GetMapping(value = "/getMaxDonationForJackpot/{jackpotId}")
	public String getMaxDonationForJackpot(@PathVariable("jackpotId")int jackpotId){
		double i = jackpotService.getMaxDonationForJackpot(jackpotId);
		return "La donation maximale de cet jackpot:["+ i +"]";
	}
	@GetMapping(value = "/getSumDonationForJackpot/{jackpotId}")
	public String getSumDonationForJackpot(@PathVariable("jackpotId")int jackpotId){
		double i = jackpotService.getSumDonationForJackpot(jackpotId);
		return "La somme total des donations de cet jackpot:["+ i +"]";
	}
	@GetMapping(value = "/getJackpotSortedBySumDonation")
	public Map<String,Double> getJackpotSortedBySumDonation(){
		return jackpotService.getJackpotSortedBySumDonation();
	}
	@GetMapping(value = "/getUsersSortedBySumDonation")
	public Map<String,Double> getUsersSortedBySumDonation(){
		return jackpotService.getUsersSortedBySumDonation();
	}
	
	@GetMapping(value = "/getAvgDonationForJackpot/{jackpotId}")
	public String getAvgDonationForJackpot(@PathVariable("jackpotId")int jackpotId){
		double i = jackpotService.getAvgDonationForJackpot(jackpotId);
		return "La moyenne des donations de cet jackpot:["+ i +"]";
	}
}
