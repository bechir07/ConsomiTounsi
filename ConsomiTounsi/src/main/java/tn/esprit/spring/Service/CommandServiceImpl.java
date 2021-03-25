package tn.esprit.spring.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.User;
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
	@Autowired
	UserRepository userRepository;

	@Override
	public int addCommand(Command command) {
		return commandRepository.save(command).getReference();
	}
	
	
	
	
	public void affecterClientACommand(Long id, int reference) {
		Command command = commandRepository.findById(reference).get();
		User user =userRepository.findById(id).get();
		if (!ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(user))
			user.getCommand().add(command);
			//user.setCommand(command);
		userRepository.save(user);
	}
	
	@Override
	public List<Command> getAllCommandes() {
		return(List<Command>) (commandRepository.findAll());
			}
	@Override
	public Command updateCommande(Command c) {
		
		return commandRepository.save(c);
	
		

	}
	
	/*public long getNombreCommandJPQL() {
		return commandRepository.getNombreCommandJPQL();
	}
	*/
 
    /*
	public Date getNamePoductByReference(int reference) {
		
		return commandRepository.findByReference(reference).getOrder_date();
	
	}*/

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