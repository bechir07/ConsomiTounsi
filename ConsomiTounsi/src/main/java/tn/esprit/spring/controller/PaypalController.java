package tn.esprit.spring.controller;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import tn.esprit.spring.Service.PaypalService;
import org.springframework.core.env.Environment;


@RestController
public class PaypalController {
/*
	@Autowired
	PaypalService service;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping("/")
	public String home() {
		return "home";
	}

/*	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8081/ConsomiTounsi/servlet/" + CANCEL_URL,
					"http://localhost:8081/ConsomiTounsi/servlet/" + SUCCESS_URL);
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
////////////////////////////////////

	  /*  private final PaypalService payPalClient;
	    @Autowired
	    PayPalController(PaypalService payPalClient){
	        this.payPalClient = payPalClient;
	    }*/
	
		
	 /*   @PostMapping(value = "/make/payment")
	    public Map<String, Object> makePayment(@RequestParam("sum") String sum){
	        return service.createPayment(sum);
	    }
	    @PostMapping(value = "/complete/payment")
	    public Map<String, Object> completePayment(HttpServletRequest request, @RequestParam("paymentId") String paymentId, @RequestParam("payerId") String payerId){
	        return service.completePayment(request);
	    }*/
	    
	    /////////////////////////////////////////////////////
	    
	    
	   
}