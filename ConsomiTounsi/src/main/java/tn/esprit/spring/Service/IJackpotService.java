package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Jackpot;

public interface IJackpotService {

	public int addJackpot(Jackpot j);

	public void deleteJackpot(int i);
	
	public List<Jackpot> retrieveAllJackpots();
	
	public Jackpot updateJackpot(Jackpot j);
	
	public void desaffecterDonationDuJackpot(int jackpotId, int donationId);
	
	public void affecterEventAJackpot(int eventId, int jackpotId);
	
	public void affecterDonationAJackpot(int donationId, int jackpotId);
	
	public void desaffecterEventDuJackpot(int jackpotId, int eventId);
	
	public double getMaxDonationForJackpot(int jackpotId);
}
