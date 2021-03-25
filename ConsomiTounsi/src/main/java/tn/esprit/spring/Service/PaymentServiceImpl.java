package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.BillRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.Repository.PaymentRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.Bill;
import tn.esprit.spring.entities.Command;
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

	@Override
	public long addPayment(Payment payment) {
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

	public void affecterBillPayment(long payment_id, long bill_id) {
		Payment payment = paymentRepository.findById(payment_id).get();
		Bill bill = billRepository.findById(bill_id).get();
		if (!ObjectUtils.isEmpty(payment) && !ObjectUtils.isEmpty(bill))
			payment.setBill(bill);
		billRepository.save(bill);
	}
	
	@Override
	public void deleteById(long Payment_id) {
		
		paymentRepository.deleteById(Payment_id );
	}
	
	@Override
	public int update_prix() {//
		return paymentRepository.getTotalPrace(0);}
	
	@Override
	public List<?> getpaymentdetails() {
		List<?> p = (List<?>) paymentRepository.getpaymentdetails();
		return p;
	}
	
	@Override
	public List<?> getpaymentByclient(long id) {
		 List<?> billsC = (List<?>) paymentRepository.getpaymentbyclient(id);
			return billsC;
	}
	@Override
	public List<?> getpaymentByEtat(String payment_type) {
		 List<?> pe = (List<?>) paymentRepository.getpaymentByEtat(payment_type);
			return pe;
	}
	@Override
	public List<?> getpaymentbyproduct(String name) {
		 List<?> pc = (List<?>) paymentRepository.getpaymentbyproduct(name);
			return pc;
	}
	
}
