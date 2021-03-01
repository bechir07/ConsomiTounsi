package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.BillRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.Repository.PaymentRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.*;

@Service
public class BillServiceImpl implements IBillService{

	@Autowired
	CommandRepository commandRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public int addBillM(Bill bill) {
		return billRepository.save(bill).getBill_id();
	}

	@Override
	public List<Bill> getAllBillM() {
		return(List<Bill>) (billRepository.findAll());
	}
	
	
	@Override
	public void deleteByBillId(int bill_id) {
		
		billRepository.deleteById(bill_id);
	}
	@Override
	public Bill updateBill(Bill c) {
		
		return billRepository.save(c);
	
		

	}
@Override
public void affecterCommandeABill(int reference, int bill_id) {
	
	Command command = commandRepository.findById(reference).get();
	Bill bill =billRepository.findById(bill_id).get();
	if (ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(bill))
	bill.setCommand(command);
	billRepository.save(bill);
	}
}

	
	
	//@Override
	//public void deleteByIdfacture(int id_facture) {
		
		//factureRepository.deleteByIdfacture(id_facture);
	//}
