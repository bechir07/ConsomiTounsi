package tn.esprit.spring.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ExchangeRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entities.Exchange;
import tn.esprit.spring.entities.User;

@Service
public class ExchangeService {

	
	ExchangeRepository exchangeRepository;
	UserRepository userRepository;
	@Autowired
	public ExchangeService(ExchangeRepository exchangeRepository, UserRepository userRepository) {
		this.exchangeRepository = exchangeRepository;
		this.userRepository = userRepository;
	}

	public Exchange updateExchange(Exchange e , Long id) {
		Exchange exchange = exchangeRepository.getOne(e.getNumCoupon());
		System.out.println("=================>  "+e.toString());
		exchange.setCouponValue(e.getCouponValue());
		exchange.setState(e.getState());
		//LocalDateTime today =  LocalDateTime.now();     //Today
		//LocalDateTime tomorrow = today.plusDays(15); 
		exchange.setDateLimite(e.getDateLimite());
		//exchange.setNumCoupon(numCoupon); LocalDate.now().plusDays(15)
		User u=userRepository.getOne(id);
		u.getExchanges().remove(e);
		//exchange.getUsers().getExchanges().remove(e);
		exchange.setUsers(u);
		exchangeRepository.save(exchange);
		//affecter coupon au user
		
		
		u.getExchanges().add(exchange);
		userRepository.save(u);
		return null;
	}
	
	public void deleteExchange(int id) {
		// TODO Auto-generated method stub
		Exchange e = exchangeRepository.getOne(id);
		userRepository.getOne(e.getUsers().getId()).setExchanges(null);
		userRepository.flush();
		exchangeRepository.deleteById(id);
		
	}
	
	public List<Exchange> getAllEchanges() {
		// TODO Auto-generated method stub
		return exchangeRepository.findAll();
	}
	
	public List<Exchange> getAllExchangeByUsersId(int id){
		return exchangeRepository.getAllExchangeByUsersId(id);
	}
	
}
