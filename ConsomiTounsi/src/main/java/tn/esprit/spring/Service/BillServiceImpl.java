package tn.esprit.spring.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.BillRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.Repository.PaymentRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.*;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


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
	public String addBillM(Bill bill) {
		if((bill.getPayment_type().equals("online_payment"))) {
			return "erreur : c'est une facture de vente en ligne";
		}
		else{
		
		billRepository.save(bill);
		return "bill added successfuly";
	}
	}

	

	@Override
	public List<Bill> getAllBillM() {
		List<Bill> bills = (List<Bill>) billRepository.findAll();
		return bills;
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
	Bill bill = billRepository.findById(bill_id).get();
	Command command = commandRepository.findById(reference).get();
	if (!ObjectUtils.isEmpty(bill) && !ObjectUtils.isEmpty(command))
		bill.setCommand(command);
	commandRepository.save(command);
	billRepository.getTotalPrace(0);
	}


 
public List<Bill> listAll() {
    return billRepository.findAll(Sort.by("total_price").ascending());
}


@Override
public int update_prix() {//
	return billRepository.getTotalPrace(0);}


@Override
public List<?> getBillByEtat(String payment_type) {
	 List<?> Ebills = (List<?>) billRepository.getbillByEtat(payment_type);
		return Ebills;
}
@Override
public List<?> getBillByclient(int client_id) {
	 List<?> billsC = (List<?>) billRepository.getbillbyclient(client_id);
		return billsC;
}
@Override
public List<?> getBillByclientname(String first_name) {
	 List<?> billsCN = (List<?>) billRepository.getbillbyclientname(first_name);
		return billsCN;
}


@Override
public List<?> getafficher() {
	List<?> L = (List<?>) billRepository.getafficher();
	return L;
}








public void generateCsvResponse(HttpServletResponse response) throws IOException {
	CSVPrinter csvPrinter = null;
	   String filename = "someFileName.csv";
	   List<Bill> bills = (List<Bill>) billRepository.findAll();
	   try {
	      response.setContentType("text/csv");
	      response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
	               "attachment; filename=\"" + filename + "\"");
	       csvPrinter = new CSVPrinter(response.getWriter(),
	      CSVFormat.DEFAULT.withHeader(" Bill_id ", " Date_of_bill ", " Payment_type ","  State  "," Total_price "));
	      for (Bill bill : bills) {
	        csvPrinter.printRecord(Arrays.asList(bill.getBill_id(),bill.getDate_of_bill(),bill.getPayment_type(), bill.getState(), bill.getTotal_price()));
	      }
	    
	      } catch (IOException e) {
	        e.printStackTrace();
	       }finally {
	           if(csvPrinter != null)
	               csvPrinter.close();
	                    }
	        }





}
	
	
	//@Override
	//public void deleteByIdfacture(int id_facture) {
		
		//factureRepository.deleteByIdfacture(id_facture);
	//}
