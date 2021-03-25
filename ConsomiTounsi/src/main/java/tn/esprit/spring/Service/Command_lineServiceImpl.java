package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.BillRepository;
import tn.esprit.spring.Repository.CommandRepository;
import tn.esprit.spring.Repository.Command_lineRepository;
import tn.esprit.spring.Repository.PaymentRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Command_line;
import tn.esprit.spring.entities.Product;
@Service
public class Command_lineServiceImpl  implements ICommand_lineService{
	
	
	@Autowired
	CommandRepository commandRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	PaymentRepository paiementRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	Command_lineRepository command_lineRepository;
	
	@Override
	public long addCommandline(Command_line command_line) {
		return command_lineRepository.save(command_line).getId();
	}
	
	/*
	public void affecterCommandABill(int reference, int bill_id) {
 		Command command = commandRepository.findById(reference).get();
		Bill bill =billRepository.findById(bill_id).get();
		if (ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(bill))
		bill.setCommand(command);
		billRepository.save(bill);
	}*/
	
	@Override
	public List<Command_line> getAllCommandes_line() {
		return(List<Command_line>) (command_lineRepository.findAll());
			}
	@Override
	public Command_line updateCommande_line(Command_line c) {
		
		return command_lineRepository.save(c);
	
		

	}
	/*
	public long getNombreCommand_lineJPQL() {
		return command_lineRepository.getNombreCommand_lineJPQL();
	}*/
	
	   @Override
		public void affecterPoductACommand_line(long Id, long reference) {
			Command_line command_line = command_lineRepository.findById(reference).get();
			Product product = productRepository.findById(Id).get();
			if (!ObjectUtils.isEmpty(command_line) && !ObjectUtils.isEmpty(product)) {
			
				command_line.setProduct(product);
				productRepository.save(product);
			}
		}
	   @Override
			public void affecterCommandACommand_line(long reference, long id) {
				Command_line command_line = command_lineRepository.findById(id).get();
				Command command = commandRepository.findById(reference).get();
				if (!ObjectUtils.isEmpty(command_line) && !ObjectUtils.isEmpty(command)) {
					command_line.setCommand(command);

					commandRepository.save(command);
				}
			}

  /* 
	public int getNamePoductById(int id) {
		
		return command_lineRepository.findById(id).getAmount();
	
	}
*/
	@Override
	public void deleteById(long id) {
		
		command_lineRepository.deleteById(id);
	}

	/*@Override
	public int CalculPrixPlat() {
		// TODO Auto-generated method stub
		return 0;
	}*/
	@Override
	public int updatetotal() {
		 return command_lineRepository.getmonta(0);
	}
	@Override
	public int update_prix() {//
		return command_lineRepository.getQuntityIngredient(0);
		}


	/*@Override
	public int somme() {
		return command_lineRepository.getmonta2();
	}*/

	
	/*@Override
	public String CalculPrixPlat() {
		float m=0;
		List<Command_line> command_line=productRepository.GetIPlat();
		for(Command_line p:command_line){
		m=0;
		List<Product> products =productRepository.GetIngreidnet(p.getId());
		for(Product i:products){
			float q;
			q=(float) productRepository.getQuntityIngredient(i.getId(),p.getId());
			m=(float) (m+i.getPrice()*q);
			p.setTotal_product_price(m);
			command_lineRepository.save(p);
					
			}	
	}	
		return "Prix de plats modifié!";
	}*/
    

}
