package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.Service.ReparationService;
import tn.esprit.spring.entities.Reparation;

@RestController
@RequestMapping("/Reparation")
public class ReparationController {

	@Autowired
	ReparationService reparationService;
	
	
	public ReparationController() {
		
	}

	@GetMapping(value = "/reparations")
	@ResponseBody
	public List<Reparation> getReparations() {

		return reparationService.getAllReparations();

	}
	
	@PutMapping("/updateReparation/{id}")
	@ResponseBody String updateReparation(@org.springframework.web.bind.annotation.RequestBody Reparation r ,@PathVariable("id") Long idProduct ) {
		return reparationService.updateReparation(r, idProduct);
	}

	@DeleteMapping("/deleteReparation")
	@ResponseBody String deleteReparation(@RequestParam(name="id",defaultValue="0")int id) {
		reparationService.deleteReparation(id);
		return "done";
	}
}
