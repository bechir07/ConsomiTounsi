package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.DonationRepository;
import tn.esprit.spring.Repository.EventRepository;
import tn.esprit.spring.Repository.JackpotRepository;

import tn.esprit.spring.entities.Donation;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;

@Service
public class JackpotServiceImpl implements IJackpotService {

	@Autowired
	private JackpotRepository JackpotRepository;
	@Autowired
	private DonationRepository DonationRepository;
	@Autowired
	private EventRepository EventRepository;
	
	@Override
	public int addJackpot(Jackpot j) {
		JackpotRepository.save(j);
		return j.getId();
	}

	@Override
	public void deleteJackpot(int i) {
		JackpotRepository.deleteById(i);
		
	}

	@Override
	public List<Jackpot> retrieveAllJackpots() {
		List<Jackpot> Jackpots = (List<Jackpot>) JackpotRepository.findAll();	
		return Jackpots;
	}

	@Override
	public Jackpot updateJackpot(Jackpot j) {
		JackpotRepository.save(j);
		return j ;
	}
@Override	
public void affecterDonationAJackpot(int donationId, int jackpotId) {
		
		// Le bout Master de cette relation N:1 est departement
		// donc il faut rajouter l'entreprise a departement
		// ==> c'est l'objet departement(le master) qui va mettre a jour
		// l'association
		// Rappel : la classe qui contient mappedBy represente le bout child. Le
		// child c'est celui qui a la cardinalité faible (One) dans une
		// association @OneToMany
		//ObjectUtils.isEmpty(Object) Checks if an Object is empty or null.
		Jackpot jackpot = JackpotRepository.findById(jackpotId).get();
		Donation donation = DonationRepository.findById(donationId).get();
		if (!ObjectUtils.isEmpty(jackpot) && !ObjectUtils.isEmpty(donation)) {
			donation.setJackpot(jackpot);
			DonationRepository.save(donation);
		}
	}
@Override
public void affecterEventAJackpot(int eventId, int jackpotId) {
	
	// Le bout Master de cette relation N:1 est departement
	// donc il faut rajouter l'entreprise a departement
	// ==> c'est l'objet departement(le master) qui va mettre a jour
	// l'association
	// Rappel : la classe qui contient mappedBy represente le bout child. Le
	// child c'est celui qui a la cardinalité faible (One) dans une
	// association @OneToMany
	//ObjectUtils.isEmpty(Object) Checks if an Object is empty or null.
	Jackpot jackpot = JackpotRepository.findById(jackpotId).get();
	Event event = EventRepository.findById(eventId).get();
	System.out.println(event);
	if (!ObjectUtils.isEmpty(jackpot) && !ObjectUtils.isEmpty(event)) {
		event.setJackpotev(jackpot);
		EventRepository.save(event);
	}
}
@Override
public void desaffecterDonationDuJackpot(int jackpotId, int donationId)
{
	/*Jackpot jackpot = JackpotRepository.findById(jackpotId).get();

	int donationNb = jackpot.getDonations().size();
	for(int index = 0; index < donationNb; index++){
		if(jackpot.getDonations().get(index).getId() == donationId){
			dep.getEmployes().remove(index);
			break;//a revoir
		}
	}*/
	 Donation donation = DonationRepository.findById(donationId).get();
	Jackpot jackpot = JackpotRepository.findById(jackpotId).get();
	if (!ObjectUtils.isEmpty(jackpot) && !ObjectUtils.isEmpty(jackpot)) {
        //departement.getEmployes().remove(departement.getEmployes().indexOf(employe));
		//jackpot.getDonations().remove(donation);
		donation.setJackpot(null);
		DonationRepository.save(donation);
	}
}
	
	
	@Override
	public void desaffecterEventDuJackpot(int jackpotId, int eventId)
	{
		/*Jackpot jackpot = JackpotRepository.findById(jackpotId).get();

		int donationNb = jackpot.getDonations().size();
		for(int index = 0; index < donationNb; index++){
			if(jackpot.getDonations().get(index).getId() == donationId){
				dep.getEmployes().remove(index);
				break;//a revoir
			}
		}*/
		 Event event = EventRepository.findById(eventId).get();
		Jackpot jackpot = JackpotRepository.findById(jackpotId).get();
		if (!ObjectUtils.isEmpty(jackpot) && !ObjectUtils.isEmpty(event)) {
	        //departement.getEmployes().remove(departement.getEmployes().indexOf(employe));
			event.setJackpotev(null);
			EventRepository.save(event);
			
			
		}
	}
	
	@Override
	public double getMaxDonationForJackpot(int jackpotId){
		
		return JackpotRepository.getMaxDonationForJackpot(jackpotId);
	}
	

}
