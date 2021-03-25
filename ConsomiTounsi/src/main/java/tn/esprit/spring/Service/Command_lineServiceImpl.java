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
	public int addCommandline(Command_line command_line) {
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
		public void affecterPoductACommand_line(Long Id, int reference) {
			Command_line command_line = command_lineRepository.findById(reference).get();
			Product product = productRepository.findById(Id).get();
			if (!ObjectUtils.isEmpty(command_line) && !ObjectUtils.isEmpty(product)) {
				//command_line.getProduct().add(product);
				product.getCommand_line().add(command_line);

				productRepository.save(product);
			}
		}
	   @Override
			public void affecterCommandACommand_line(int reference, int id) {
				Command_line command_line = command_lineRepository.findById(id).get();
				Command command = commandRepository.findById(reference).get();
				if (!ObjectUtils.isEmpty(command_line) && !ObjectUtils.isEmpty(command)) {
					command.getCommand_line().add(command_line);
					//command.setCommand_line(command_line);

					commandRepository.save(command);
				}
			}

  /* 
	public int getNamePoductById(int id) {
		
		return command_lineRepository.findById(id).getAmount();
	
	}
*/
	@Override
	public void deleteById(int id) {
		
		command_lineRepository.deleteById(id);
	}

}
