package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.DeliveryMenService;
import tn.esprit.spring.Service.DeliveryService;
import tn.esprit.spring.Service.ReclamationService;
import tn.esprit.spring.Service.ReparationService;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.Exchange;
import tn.esprit.spring.entities.Reclamation;


//@RepositoryRestController
@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {

	@Autowired
	ReclamationService reclamationService;
	@Autowired
	DeliveryMenService dms;
	@Autowired
	ReparationService reparationService;
	
	
	@GetMapping("/test")
	@ResponseBody
	 String getAllStocks() {
		dms.stats();
		return "test";
	}
	@PutMapping("/decision")
	//@RequestMapping(value="/decision",method=RequestMethod.PUT)
	@ResponseBody String decision (@RequestBody Reclamation r,@RequestParam(name="couponValue",defaultValue="0")float couponValue,
			@RequestParam(name="typePanne",defaultValue="")String typePanne,@RequestParam(name="prixReparation",defaultValue="0")float prixReparation,
			@RequestParam(name="idProduct",defaultValue="0")Long idProduct,@RequestParam(name="idClient",defaultValue="0")Long idClient) {		
		return reclamationService.decision(r, couponValue,typePanne,prixReparation,idProduct,idClient);
		
	}
	
	@RequestMapping(value="/newReclamation",method=RequestMethod.POST)
	@ResponseBody Reclamation newReclamation (@RequestBody Reclamation r,@RequestParam(name="id",defaultValue="0")Long id) {		
		return reclamationService.clientAddReclamation(r, id);
		
	}
	
	@PutMapping(value="/updateReclamation")
	@ResponseBody Reclamation updateReclamation (@RequestBody Reclamation r,@RequestParam(name="id",defaultValue="0")Long id) {		
		return reclamationService.clientUpdateReclamation(r, id);
		
	}
	
	
}
