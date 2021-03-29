package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.Service.IRayonService;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Rayon;



@RestController
public class RayonRestController {

	@Autowired
	IRayonService rayonService;
	
	@PostMapping("/addRayon")	
	public int addRayon(@RequestBody Rayon r) {
		rayonService.addRayon(r);
		return r.getId();
	}
	
	@DeleteMapping(value = "/deleteRayon/{id}")
	public void deleteRayon(@PathVariable("id")int id) {
		rayonService.deleteRayon(id);
		
		
	}
	
	@PutMapping(value = "/updateRayon") 
	public Rayon updateRayon(@RequestBody Rayon r)  {
		return rayonService.updateRayon(r);
	}

	@GetMapping("/getAllRayons")
	public List<Rayon> getAllRayons() {

		return rayonService.getAllRayons();
	}
	

	@GetMapping("/getRayonBytype/{type}")
	public List<Rayon> getRayonBytype(@PathVariable("type")String type) {

		return rayonService.getRayonBytype(type);
	}
	@GetMapping("/findByCategory/{id}")
	public Rayon findByCategory(@PathVariable("id")int id) {

		return rayonService.findByCategory(id);
	}
	
	@GetMapping("/findByrayon/{id}")
	public Rayon findByrayon(@PathVariable("id")long id)
	{
		return rayonService.findByrayon(id);
	}
	
	
}
	
