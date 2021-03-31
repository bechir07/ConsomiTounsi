package tn.esprit.spring.Service;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;

import tn.esprit.spring.Repository.RemboursementRepository;
import tn.esprit.spring.entities.Remboursement;

@Service
public class RemboursementService {
	
	@Value("${STRIPE_SECRET_KEY}")
    private String secretKey;
	@Autowired
	RemboursementRepository remboursementRepository; 
	@Autowired
	private JavaMailSender mailSender;
    
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    public Charge charge(Remboursement remboursement) 
      throws AuthenticationException, InvalidRequestException,
        APIConnectionException, CardException, APIException {
    	// ############### create token ################
    	 Map<String, Object> cardParams = new HashMap<>();
    	 cardParams.put("number", "4242424242424242");
    	 cardParams.put("exp_month", "01");
    	 cardParams.put("exp_year", "2024");
    	 cardParams.put("cvc", "123");
    	 Map<String, Object> tokenParams = new HashMap<>();
    	 tokenParams.put("card", cardParams);
    	 Token token = Token.create(tokenParams);
    	 
    	//Customer c = Customer.retrieve("cus_JAsUPj1yJy4xWh");
        Map<String, Object> chargeParams = new HashMap<>();
       
        chargeParams.put("amount",String.valueOf(remboursement.getAmount()));
        chargeParams.put("currency", remboursement.getCurrency());
        chargeParams.put("description", remboursement.getDescription());
       chargeParams.put("source", token.getId());
       chargeParams.put("receipt_email", remboursement.getReceipt_email());
       //chargeParams.put("customer", "cus_JAsUPj1yJy4xWh");
      //  chargeParams.put("Customer id", "cus_JAsUPj1yJy4xWh");
        System.out.println("===========> "+token.getId());
        System.out.println("===========> "+chargeParams);
        Charge c = Charge.create(chargeParams);
        System.out.println("==============> "+ c.getStatus());
        if (c.getStatus().equals("succeeded")) {
        remboursementRepository.save(remboursement);
       System.out.println("done!!");
    }
        return c;
    }

}
