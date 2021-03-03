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

import tn.esprit.spring.Service.PaymentServiceImpl;

import tn.esprit.spring.entities.Payment;
@RestController
public class PaymentRestController {


	@Autowired
	PaymentServiceImpl paymentService;
	@PostMapping("/addPayment")
	public int addPayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
		return payment.getPayment_id();
	}
	
	@GetMapping("/getAllPayment")
	public List<Payment> getAllPayment() {

		return paymentService.getAllPayment();
	}

    @PutMapping(value = "/affecterBillPayment/{payment_id}/{bill_id}") 
	public void affecterBillPayment(@PathVariable("payment_id")int id, @PathVariable("bill_id")int idd) {
    	paymentService.affecterBillPayment(id, idd);
	}
	
	  @PutMapping(value = "/updatepayment") 
		public Payment updatePayment(@RequestBody Payment payment)  {
			return paymentService.updatePayment(payment);
		}
	  
		@DeleteMapping(value = "/deleteById/{payment_id}")
		public void deleteById(@PathVariable("payment_id")int payment_id) {
			paymentService.deleteById(payment_id);
		}
}
