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

import tn.esprit.spring.Service.DonChariotServiceImpl;
import tn.esprit.spring.entities.DonChariot;

@RestController
@RequestMapping("/donchariot")
public class DonChariotRestController {
	
	@Autowired
	DonChariotServiceImpl donchariotService;
	
	@PostMapping("/addDonChariot")
	public int addDonChariot(@RequestBody DonChariot DonChariot) {
		return donchariotService.addDonChariot(DonChariot);
		
	}
	
	@GetMapping("/getAllDonChariot")
	public List<DonChariot> getAllDonChariot() {

		return donchariotService.retrieveAllDonChariots();
	}
	
	@DeleteMapping("/deleteDonChariot/{id_DonChariot}") 
	public void deleteDonChariot(@PathVariable("id_DonChariot") int id) {
		donchariotService.deleteDonChariot(id);
	}
	
	@PutMapping(value="/updateDonChariot") 
	public DonChariot updateDonChariot(@RequestBody DonChariot dc) {
		return donchariotService.updateDonChariot(dc);
	}

}
