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

import tn.esprit.spring.Service.DonationServiceImpl;
import tn.esprit.spring.entities.Donation;

@RestController
@RequestMapping("/donation")
public class DonationRestController {
	
	@Autowired
	DonationServiceImpl donationService;
	
	@PostMapping("/addDonation")
	public int addDonation(@RequestBody Donation Donation) {
		return donationService.addDonation(Donation);
		
	}
	
	@GetMapping("/getAllDonation")
	public List<Donation> getAllDonation() {

		return donationService.retrieveAllDonations();
	}
	
	@DeleteMapping("/deleteDonation/{id_Donation}") 
	public void deleteDonation(@PathVariable("id_Donation") int id) {
		donationService.deleteDonation(id);
	}
	
	@PutMapping(value="/updateDonation") 
	public Donation updateDonation(@RequestBody Donation d) {
		return donationService.updateDonation(d);
	}


}
