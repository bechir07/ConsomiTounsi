package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Donation;

public interface IDonationService {

	public int addDonation(Donation d);

	public void deleteDonation(int i);
	
	public List<Donation> retrieveAllDonations();
	
	public Donation updateDonation(Donation d);
}
