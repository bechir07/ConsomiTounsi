package tn.esprit.spring.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Command;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.Repository.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


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
	@Autowired
	CommandServiceImpl commandService;
	@Autowired
	public JavaMailSender javamailsender;
	@Override
	public long addCommand(Command command) {
		return commandRepository.save(command).getReference();
	}
	
	
	
	
	public void affecterClientACommand(long id, long reference) {
		Command command = commandRepository.findById(reference).get();
		User user = userRepository.findById(id).get();
		System.out.println("user "+user.getUsername());
		System.out.println("command "+command.getReference());
		if (!ObjectUtils.isEmpty(command) && !ObjectUtils.isEmpty(user))
			{
			System.out.println("in if");
			//user.getCommand().add(command);
			command.setClient(user);
		userRepository.save(user);
		}
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
	
 
    /*
	public Date getNamePoductByReference(int reference) {
		
		return commandRepository.findByReference(reference).getOrder_date();
	
	}*/

	@Override
	public void deleteByReference(long reference) {
		
		commandRepository.deleteById(reference);
	}

	@Override
	public List<String> getCommandByReferenceJPQL(long reference) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Command> GetComByDate() {
		
		return (List<Command>) (commandRepository.GetComByDate());
		
	}
	
	//command by client
	@Override
	public List<?> getafficherC() {
		List<?> L = (List<?>) commandRepository.getafficherC();
		return L;
	}
	
	//Stistique (client du mois) id client nbr commande
	public HashMap<Integer , Integer> stat(){
		return null;
		/*HashMap<Integer , Integer> tt = new HashMap<Integer , Integer>();
		int a=0;
		List<User> us = userRepository.findAll();
		for(User u : us){
			for(Command c : u.getCommand()){
				if(c.getOrder_date().getMonthValue()==Calendar.getInstance().get(Calendar.MONTH))
				a+=1;
				tt.put(u.getId(), a);
			}
			
			
			
		}
		System.out.println("=> "+tt.toString());
		return tt;*/
	}
	
	@Override
	public int updatetotal() {
		 return commandRepository.getmonta(0);
	}
	 @Override
		public String EnvoiPlanning() {	
			List<Command> repas=commandService.GetComByDate();
			SimpleMailMessage m=new SimpleMailMessage();
			m.setTo("montassarhmidi@gmail.com");
			m.setSubject("Command of day" );
			m.setText("Bonjour /n"+repas.toString());
			javamailsender.send(m);
			return "Mail envoyé !";
			
			
		}




	
	 
	
}