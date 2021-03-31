package tn.esprit.spring.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import tn.esprit.spring.Service.PaypalService;
import tn.esprit.spring.Service.DonationServiceImpl;
import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.entities.Order;

@RestController
public class PaypalController {

	@Autowired
	PaypalService service;
	@Autowired
	DonationServiceImpl donationService;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping(value="/home")
	public String home() {
		return "home";
	}

	@PostMapping("/pay")
	public String payment(@RequestBody Donation donation) {
		donationService.addDonation(donation);
		try {
			//System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
			Payment payment = service.createPayment(donation.getMontant(), "USD", "paypal",
					"sale", "testing", "http://localhost:8081/ConsomiTounsi/" + CANCEL_URL,
					"http://localhost:8081/ConsomiTounsi/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            if (payment.getState().equals("approved")) {
	                return "success";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:/";
	    }
}


