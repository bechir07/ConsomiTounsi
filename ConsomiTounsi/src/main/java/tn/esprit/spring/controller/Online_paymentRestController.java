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

import tn.esprit.spring.Service.Online_paymentServiceImpl;
import tn.esprit.spring.entities.Online_payment;
@RestController
public class Online_paymentRestController {


		@Autowired
		Online_paymentServiceImpl online_paymentService;
		@PostMapping("/ajouterPaiement_enligne")
		public int addPayment(@RequestBody Online_payment online_payment) {
			online_paymentService.addOnline_payment(online_payment);
			return online_payment.getPayment_id();
		}
		
		@GetMapping("/getAllOnline_payment")
		public List<Online_payment> getAllOnline_payment() {

			return online_paymentService.getAllOnline_payment();
		}
		
		  @PutMapping(value = "/updateOnline_payment") 
			public Online_payment updateOnline_payment(@RequestBody Online_payment online_payment)  {
				return online_paymentService.updateOnline_payment(online_payment);
			}
		  
		/*	@DeleteMapping(value = "/deleteById/{id_paiment}")
			public void deleteById(@PathVariable("id_paiment")int id_paiment) {
				paiement_enligneService.deleteById(id_paiment);
			}*/
	}
