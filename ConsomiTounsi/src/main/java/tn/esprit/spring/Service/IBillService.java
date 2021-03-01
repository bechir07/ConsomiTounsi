package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Bill;

public interface IBillService {



	public void affecterCommandeABill(int reference, int bill_id) ;
	public Bill updateBill(Bill c) ;
	public void deleteByBillId(int bill_id);
	public List<Bill> getAllBillM() ;
	public int addBillM(Bill bill);


}
