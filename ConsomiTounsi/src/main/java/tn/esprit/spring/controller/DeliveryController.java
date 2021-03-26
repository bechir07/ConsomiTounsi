package tn.esprit.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.DeliveryMenRepository;
import tn.esprit.spring.Service.DeliveryMenService;
import tn.esprit.spring.Service.DeliveryService;
import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMen;

@RestController
@RequestMapping("/Delivery")
public class DeliveryController {

	
	@Autowired
	DeliveryService ds;
	@Autowired
	DeliveryMenService dm;
	
	@RequestMapping(value="/newDelivery",method=RequestMethod.POST)
	@ResponseBody Delivery newDelivery (@RequestBody Delivery d,@RequestParam(name="id",defaultValue="0")Long DeliveryMenId) {		
		return ds.addDelivery(d, DeliveryMenId);
		
	}
	
	@PatchMapping("/updateDelivery")
	 Delivery updateDelivery (@RequestBody Delivery d,@RequestParam(name="id",defaultValue="0")Long DeliveryMenId) {		
		return ds.updateDelivery(d, DeliveryMenId);
		
	}
	
	@GetMapping("/delivriesByDM/{id}")
	List<Delivery> getDeliveriesByDeliveryMen(@PathVariable("id") Long id){
		return ds.allDelivriesByDeliveryMen(id);
	}
	
	@GetMapping("/distance")
	Map<Long,Double> getDistance(){
		return dm.plusProcheDeliveryMen();
	}
	
	//delete delivery
	//http://localhost:8082/ConsomiTounsi/servlet/Deliveries/{id}
	//get all deliveries
	//http://localhost:8082/ConsomiTounsi/servlet/Deliveries
	//get delivery by id
	//http://localhost:8082/ConsomiTounsi/servlet/Deliveries/{id}
}
