package tn.esprit.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Service.RemboursementService;
import tn.esprit.spring.entities.Remboursement;
import tn.esprit.spring.entities.Remboursement.Currency;
import tn.esprit.spring.entities.User;

@RestController()
public class RemboursementController {

	    @Autowired
	    private RemboursementService paymentsService;
	    @Autowired
	    UserRepository r;

	    @PostMapping("/charge")
	    public  Map<String, Object> charge(@RequestBody Remboursement chargeRequest)
	      throws StripeException {
	        chargeRequest.setDescription("ConsoumiTounsi Refund service");
	        chargeRequest.setCurrency(Currency.USD);
	        Charge charge = paymentsService.charge(chargeRequest);
	        Map<String, Object> chargeParams = new HashMap<>();
	        chargeParams.put("id", charge.getId());
	        chargeParams.put("status", charge.getStatus());
	        chargeParams.put("chargeId", charge.getId());
	        chargeParams.put("balance_transaction", charge.getBalanceTransaction());      
	        return chargeParams;
	    }
	    @GetMapping("tt")
	    public List<User> lis(){
	    	return r.findAll();
	    }

	  /*  @ExceptionHandler(StripeException.class)
	    public String handleError(Model model, StripeException ex) {
	        model.addAttribute("error", ex.getMessage());
	        return "result";
	    }
	*/

}
