package tn.esprit.spring.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.Repository.ReparationRepository;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Reparation;

@Service
public class ReparationService implements IReparationService {
	
	@Autowired
	ReparationRepository reparationRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	private JavaMailSender mailSender;
	

	public ReparationService() {
		
	}

	@Override
	public int addReparation(Reparation r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteReparation(int id) {
		// TODO Auto-generated method stub
		Reparation r = reparationRepository.getOne(id);
		Product p=productRepository.getOne(r.getProduct().getId());
		p.setReparation(null);
		productRepository.save(p);
		reparationRepository.deleteById(id);
		
	}

	@Override
	public String updateReparation(Reparation r,Long idProduct ) {
		// TODO Auto-generated method stub
		
		/*
		 * Reparation reparation = new Reparation();
		 * reparation.setDateReparation(r.getDateReparation());
		 * reparation.setTypePanne(r.getTypePanne()); reparation.setState(r.getState());
		 * 
		 *  reparation.setPrixReparation(r.getPrixReparation());
		 */
		
		Product p = productRepository.getOne(idProduct);
		System.out.println("============== "+p.getUser().getEmail());
		
		  r.setProduct(p); reparationRepository.save(r);
		  p.setReparation(r); productRepository.save(p);
		  System.out.println("==========> "+r.toString());
		 	if(r.getState().equals("works")) {
			/*
			 * MimeMessagePreparator messagePreparator = mimeMessage -> { MimeMessageHelper
			 * messageHelper = new MimeMessageHelper(mimeMessage,true);
			 * messageHelper.setFrom("montassarhmidi@gmail.com");
			 * messageHelper.setTo(p.getUser().getEmail());
			 * messageHelper.setSubject("Produit est en bonne etat");
			 * messageHelper.setText(""); //FileSystemResource file = new
			 * FileSystemResource(new File("c:/cpg.jpg"));
			 * //messageHelper.addAttachment(file.getFilename(), file);
			 * 
			 * }; mailSender.send(messagePreparator);
			 */
		     System.out.println("send notifaction to client.. produit fixed!");
		}
		return "send notifaction to client.. produit fixed!";
	}

	@Override
	public List<Reparation> getAllReparations() {
		// TODO Auto-generated method stub
		return reparationRepository.findAll();
	}

}
