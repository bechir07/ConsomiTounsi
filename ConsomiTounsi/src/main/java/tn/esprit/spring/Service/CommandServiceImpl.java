package tn.esprit.spring.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.Bill;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.Repository.*;


@Service
public class CommandServiceImpl implements ICommandService{
	@Autowired
	CommandRepository commandRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	PaymentRepository paiementRepository;
	@Autowired
	ProductRepository productRepository;

	@Override
	public int addCommand(Command command) {
		return commandRepository.save(command).getReference();
	}
	
	
	public void affecterCommandABill(int reference, int bill_id) {
		Command command = commandRepository.findById(reference).get();
		Bill bill =billRepository.findById(bill_id).get();
		if (ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(bill))
		bill.setCommand(command);
		billRepository.save(bill);
	}
	
	@Override
	public List<Command> getAllCommandes() {
		return(List<Command>) (commandRepository.findAll());
			}
	@Override
	public Command updateCommande(Command c) {
		
		return commandRepository.save(c);
	
		

	}
	
	public long getNombreCommandJPQL() {
		return commandRepository.getNombreCommandJPQL();
	}
	
    @Override
	public void affecterPoductACommand(int Id, int reference) {
		Command command = commandRepository.findById(reference).get();
		Product product = productRepository.findById(Id).get();
		if (!ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(product)) {
			command.getProduct().add(product);

			commandRepository.save(command);
		}
	}
    
	public String getNamePoductByReference(int reference) {
		
		return commandRepository.findByReference(reference).getNamePoduct();
	
	}

	@Override
	public void deleteByReference(int reference) {
		
		commandRepository.deleteById(reference);
	}

	@Override
	public List<String> getCommandByReferenceJPQL(int reference) {
		// TODO Auto-generated method stub
		return null;
	}
	
}