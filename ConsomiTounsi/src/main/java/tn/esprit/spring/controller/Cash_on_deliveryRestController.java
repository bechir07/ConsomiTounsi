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

import tn.esprit.spring.Service.Cash_on_deliveryServiceImpl;
import tn.esprit.spring.entities.Cash_on_delivery;


@RestController
public class Cash_on_deliveryRestController {

	


			@Autowired
			Cash_on_deliveryServiceImpl cash_on_deliveryService;
			@PostMapping("/addCash_on_delivery")
			public int addPayment(@RequestBody Cash_on_delivery cash_on_delivery) {
				cash_on_deliveryService.addCash_on_delivery(cash_on_delivery);
				return cash_on_delivery.getPayment_id();
			}
			
			@GetMapping("/getAllCash_on_delivery")
			public List<Cash_on_delivery> getAllCash_on_delivery() {

				return cash_on_deliveryService.getAllCash_on_delivery();
			}
			
			  @PutMapping(value = "/updateCash_on_delivery") 
				public Cash_on_delivery updatePaiement_livraison(@RequestBody Cash_on_delivery cash_on_delivery)  {
					return cash_on_deliveryService.updateCash_on_delivery(cash_on_delivery);
				}
			  
				/*@DeleteMapping(value = "/deleteById/{id_paiment}")
				public void deleteById(@PathVariable("id_paiment")int id_paiment) {
					paiement_livraisonService.deleteById(id_paiment);
				}*/
		}
