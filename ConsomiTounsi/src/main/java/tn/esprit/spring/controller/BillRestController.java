package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.mapstruct.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.lowagie.text.DocumentException;

import tn.esprit.spring.Service.BillServiceImpl;
import tn.esprit.spring.Service.Bill_PdfServiceImpl;
import tn.esprit.spring.Service.IBillService;
import tn.esprit.spring.Service.TwillioService;
import tn.esprit.spring.entities.Bill;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
///////////////////////////////////////////////////////////////
import java.io.IOException;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

	@Autowired
	IBillService billService;
	Bill_PdfServiceImpl billp;
	//http://localhost:8081/ConsomiTounsi/servlet/
	@PostMapping("/addBill")
	
	public int addbillM(@RequestBody Bill bill) {
		String body = "Hello. Good Morning!! A New Invoice Successfully Added!! Thank You.";
		twillioService.sendSms(to, from, body);
		billService.addBillM(bill);
		return bill.getBill_id();
	}
	

	@GetMapping("/getAllBillM")
	public List<Bill> getAllBillM() {

		return billService.getAllBillM();
	}
	
	@GetMapping("/getAllBillMass")
	public List<Bill> getAllBillMass() {

		return billService.listAll();
	}
	
		@PutMapping("/affecterCommandtoBill/{refcom}/{idbill}")
		public void affecterCommandtoBill(@PathVariable("refcom") int reference, @PathVariable("idbill") int bill_id) {
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


@GetMapping(value = "/getBillByEtat/{payment_type}")
public List<?> getBillByEtat(@PathVariable("payment_type") String payment_type) {
	return billService.getBillByEtat(payment_type);
	
}
@GetMapping(value = "/getBillByclientname/{first_name}")
public List<?> getBillByclient(@PathVariable("first_name") String first_name) {
	return billService.getBillByclientname(first_name);
}
@GetMapping(value = "/getBillByclient/{client_id}")
public List<?> getBillByclient(@PathVariable("client_id") int client_id) {
	return billService.getBillByclient(client_id);
}
@GetMapping(value = "/getFACTURE")
public List<?> getFACTURE() {
	return billService.getafficher();
	
}

@PutMapping(value = "/updatetotalprice") 
	public int update_price()  {
		return billService.update_prix();
	}

@GetMapping("/pdf")
public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
     
    List<Bill> listBill = billService.getAllBillM();
     
    Bill_PdfServiceImpl exporter = new Bill_PdfServiceImpl(listBill);
    exporter.export(response);
     
}
@Autowired
TwillioService twillioService;
@Value("${app.twillio.fromPhoneNo}")
private String from;

@Value("${app.twillio.toPhoneNo}")
private String to;

@GetMapping("/sendSms")
public String sendSms() {
	
	String body = "Hello. Good Morning!!";
	twillioService.sendSms(to, from, body);
	return "message sent successfully";
	
	
}





@GetMapping("/makeCall")
public String makeVoiceCall() {
	
	twillioService.makeCall(from, to);
	return "call initiated..";
	
	
}
/////////////////////////////////////


/*
@Autowired
ServletContext context;

@RequestMapping(value = "/pdf/{fileName:.+}", method = RequestMethod.GET, produces = "application/pdf")
public ResponseEntity<InputStreamResource> download(@PathVariable("fileName") String fileName) throws IOException {
System.out.println("Calling Download:- " + fileName);
ClassPathResource pdfFile = new ClassPathResource("" + fileName);
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.parseMediaType("application/pdf"));
headers.add("Access-Control-Allow-Origin", "*");
headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
headers.add("Access-Control-Allow-Headers", "Content-Type");
headers.add("Content-Disposition", "filename=" + fileName);
headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
headers.add("Pragma", "no-cache");
headers.add("Expires", "0");

headers.setContentLength(pdfFile.contentLength());
ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
return response;

}*/
/*
@RequestMapping(value="/download", method=RequestMethod.GET) 
public ResponseEntity<Object> downloadFile() throws IOException  {
	FileWriter filewriter =  null;
	try {
	Bill csv1 = new Bill();
	csv1.getBill_id();
	csv1.getDate_of_bill();
	csv1.getPayment_type();
	csv1.getState();
	csv1.getTotal_price();
	

	
	List<Bill> csvDataList = new ArrayList<>();
	csvDataList.add(csv1);
	
	StringBuilder filecontent = new StringBuilder("ID, getDate_of_bill, getPayment_type,getState,getTotal_price\n");
	for(Bill csv:csvDataList) {
		filecontent.append(csv.getBill_id()).append(",").append(csv.getDate_of_bill()).append(",").append(csv.getPayment_type()).append(csv.getState()).append(csv.getTotal_price()).append("\n");
	}
	
	String filename = "C:\\pdf\\csvdata.csv";
	
 filewriter = new FileWriter(filename);
	filewriter.write(filecontent.toString());
	filewriter.flush();
	
	File file = new File(filename);
	
	InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	HttpHeaders headers = new HttpHeaders();
	headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	headers.add("Pragma", "no-cache");
	headers.add("Expires", "0");
	
	ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
	return responseEntity;
	} catch (Exception e ) {
		return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);	
	} finally {
		if(filewriter!=null)
			filewriter.close();
	}
}*/





@Autowired
BillServiceImpl b;

@GetMapping("/users-csv")
public void downloadUsersCSV(@Context HttpServletResponse httpServletResponse) throws IOException{
	b.generateCsvResponse(httpServletResponse);
}
}
//}
