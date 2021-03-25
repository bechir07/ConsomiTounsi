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
	//http://localhost:8081/ConsomiTounsi/servlet/
	@PostMapping("/addPayment")
	public long addPayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
		return payment.getPayment_id();
	}
	
	@GetMapping("/getAllPayment")
	public List<Payment> getAllPayment() {

		return paymentService.getAllPayment();
	}

    @PutMapping(value = "/affecterBillPayment/{payment_id}/{bill_id}") 
	public void affecterBillPayment(@PathVariable("payment_id")long id, @PathVariable("bill_id")long idd) {
    	paymentService.affecterBillPayment(id, idd);
    	paymentService.update_prix();
	}
	
	  @PutMapping(value = "/updatepayment") 
		public Payment updatePayment(@RequestBody Payment payment)  {
			return paymentService.updatePayment(payment);
		}
	  
		@DeleteMapping(value = "/deleteById/{payment_id}")
		public void deleteById(@PathVariable("payment_id")long payment_id) {
			paymentService.deleteById(payment_id);
		}
		
		@PutMapping(value = "/updatetotalpricepayment") 
		public int update_price()  {
			return paymentService.update_prix();
		}
		
		@GetMapping(value = "/getpaymentdetails")
		public List<?> getpaymentdetails() {
			return paymentService.getpaymentdetails();
			
		}
		@GetMapping(value = "/getpaymentByclient/{id}")
		public List<?> getpaymentByclient(@PathVariable("id") long id) {
			return paymentService.getpaymentByclient(id);
		}
		@GetMapping(value = "/getpaymentByEtat/{payment_type}")
		public List<?> getpaymentByEtat(@PathVariable("payment_type") String payment_type) {
			return paymentService.getpaymentByEtat(payment_type);
			
		}
		@GetMapping(value = "/getpaymentbyproduct/{name}")
		public List<?> getpaymentbyproduct(@PathVariable("name") String name) {
			return paymentService.getpaymentbyproduct(name);
		}
}
