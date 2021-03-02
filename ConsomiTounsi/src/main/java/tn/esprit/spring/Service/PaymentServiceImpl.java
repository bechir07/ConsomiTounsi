package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.BillRepository;
import tn.esprit.spring.Repository.Cash_on_deliveryRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.Repository.Online_paymentRepository;
import tn.esprit.spring.Repository.PaymentRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.Payment;


@Service
public class PaymentServiceImpl implements IServicePayment{

	
	@Autowired
	CommandRepository commandRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	Online_paymentRepository online_paymentRepository;
	@Autowired
	Cash_on_deliveryRepository cash_on_deliveryRepository;

	@Override
	public int addPayment(Payment payment) {
		return paymentRepository.save(payment).getPayment_id();
	}
	
	@Override
	public List<Payment> getAllPayment() {
		return(List<Payment>) (paymentRepository.findAll());
			}
	@Override
	public Payment updatePayment(Payment p) {
		
		return paymentRepository.save(p);
	
		

	}
	
	@Override
	public void deleteById(int Payment_id) {
		
		paymentRepository.deleteById(Payment_id );
	}
}
