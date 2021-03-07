package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.DonationRepository;
import tn.esprit.spring.entities.Donation;

@Service
public class DonationServiceImpl implements IDonationService {
	
	@Autowired
	private DonationRepository DonationRepository;
	@Override
	public int addDonation(Donation d) {
		DonationRepository.save(d);
		return d.getId();
	}

	@Override
	public void deleteDonation(int i) {
		DonationRepository.deleteById(i);
		
	}

	@Override
	public List<Donation> retrieveAllDonations() {
		List<Donation> Donations = (List<Donation>) DonationRepository.findAll();	
		return Donations;
	}

	@Override
	public Donation updateDonation(Donation d) {
		DonationRepository.save(d);
		return d ;
	}

}
