package tn.esprit.spring.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.Service.IBillService;
import tn.esprit.spring.entities.Bill;


@RestController
public class BillRestController {

	@Autowired
	IBillService billService;
	//http://localhost:8081/ConsomiTounsi/servlet/
	@PostMapping("/addBill")
	
	public int addbillM(@RequestBody Bill bill) {
		billService.addBillM(bill);
		return bill.getBill_id();
	}
	

	@GetMapping("/getAllBillM")
	public List<Bill> getAllBillM() {

		return billService.getAllBillM();
	}
	
		@PutMapping("/affecterCommandtoBill/{idbill}/{refcom}")
		 @ResponseBody
		public void affecterCommandtoBill(@PathVariable("refcom") int reference, @PathVariable("idfac") int bill_id) {
			billService.affecterCommandeABill(reference,bill_id);

		}

	 @PutMapping(value = "/updateBill") 
		public Bill updateBill(@RequestBody Bill bill)  {
			return billService.updateBill(bill);
		}
	
	//@PutMapping(value = "/deleteByIdfacture/{id_facture}")
	//public void deleteByIdfacture(@PathVariable("id_facture")int id_facture) {
	//	factureService.deleteByIdfacture(id_facture);

@DeleteMapping(value = "/deletebillById/{bill_id}")
public void deleteById(@PathVariable("bill_id")int bill_id) {
	billService.deleteByBillId(bill_id);
	
	
}
}
//}
