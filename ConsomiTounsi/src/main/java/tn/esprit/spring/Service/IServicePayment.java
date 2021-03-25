package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Payment;

public interface IServicePayment {

	
	public long addPayment(Payment payment);
	public List<Payment> getAllPayment();
	public Payment updatePayment(Payment p);
	public void deleteById(long Payment_id);
	public void affecterBillPayment(long payment_id, long bill_id);
	int update_prix();
	List<?> getpaymentdetails();
	List<?> getpaymentByclient(long id);
	List<?> getpaymentByEtat(String payment_type);
	List<?> getpaymentbyproduct(String name);

}
