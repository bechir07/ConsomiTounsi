package tn.esprit.spring.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ExchangeRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.Repository.ReclamationRepository;
import tn.esprit.spring.Repository.ReparationRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entities.Decision;
import tn.esprit.spring.entities.Exchange;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.Reparation;
import tn.esprit.spring.entities.User;

@Service
public class ReclamationService {

	public ExchangeRepository exchangeRepository;
	public UserRepository userRepository;
	public ReclamationRepository reclamationRepository;
	public ReparationRepository reparationRepository;
	public ProductRepository productRepository;

	@Autowired
	public ReclamationService(ExchangeRepository exchangeRepository,UserRepository userRepository,ReclamationRepository reclamationRepository,ReparationRepository reparationRepository,ProductRepository productRepository) {
		this.exchangeRepository=exchangeRepository;
		this.userRepository=userRepository;
		this.reclamationRepository=reclamationRepository;
		this.reparationRepository=reparationRepository;
		this.productRepository=productRepository;
	}

	public Reclamation clientAddReclamation(Reclamation r , Long id) {	
		r.setUsers(userRepository.getOne(id));
		r.setDateLimit(LocalDate.now().plusDays(15));
		r.setDecision(Decision.Pending);
		return reclamationRepository.save(r);
	}
	
	public Reclamation clientUpdateReclamation(Reclamation r , Long id) {	
		r.setDecision(Decision.Pending);
		r.setUsers(userRepository.getOne(id));
		return reclamationRepository.save(r);
	}
	
	public String decision(Reclamation r,float couponValue,String typePanne,float prixReparation,Long idProduct,Long idClient) {
		if(r.getDecision().equals(Decision.Remboursement)) {
			return "Remboursement";
		}
		if(r.getDecision().equals(Decision.Echange)) {
					return  exchange(r,couponValue);
				}
		if(r.getDecision().equals(Decision.Réparation)) {
			return reparation(r,typePanne,prixReparation,idProduct);
		}
		if(r.getDecision().equals(Decision.Refusé)) {
			r.setState(false);
			r.setUsers(userRepository.getOne(idClient));
			reclamationRepository.save(r);
			return"Reclamation Refusé";
		}
		return "";
	}

	private String exchange(Reclamation r,float couponValue) {
		// TODO Auto-generated method stub
		Exchange exchange = new Exchange();
		exchange.setCouponValue(couponValue);
		exchange.setState("En cours");
		//LocalDateTime today =  LocalDateTime.now();     //Today
		//LocalDateTime tomorrow = today.plusDays(15); 
		exchange.setDateLimite(LocalDate.now().plusDays(15));
		//exchange.setNumCoupon(numCoupon); LocalDate.now().plusDays(15)
		Reclamation reclamation = reclamationRepository.getOne(r.getId());
		reclamation.setDecision(r.getDecision());
		reclamationRepository.save(reclamation);
		System.out.println("====================>"+ reclamation.getUsers().getId());
		
		  exchange.setUsers(reclamation.getUsers());
		  exchangeRepository.save(exchange);
		  //affecter coupon au user 
		  User u=userRepository.getOne(reclamation.getUsers().getId());
		  u.getExchanges().add(exchange); 
		  userRepository.save(u);
		 
		return 		"{done}";

	}
	
	private String reparation(Reclamation r,String typePanne,float prixReparation,Long idProduct) {
		Reparation reparation = new Reparation();
		reparation.setDateReparation(LocalDate.now().plusDays(15));
		reparation.setTypePanne(typePanne);
		reparation.setState("En cours");
		reparation.setPrixReparation(prixReparation);
		Product p = productRepository.getOne(idProduct);
		reparation.setProduct(p);
		reparationRepository.save(reparation);
		p.setReparation(reparation);
		productRepository.save(p);
		
		return "{done}";
	}
	
	

	
}
