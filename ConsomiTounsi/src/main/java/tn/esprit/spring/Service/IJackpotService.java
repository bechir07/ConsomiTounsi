package tn.esprit.spring.Service;

import java.util.List;
import java.util.Map;

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
	
	public double getSumDonationForJackpot(int jackpotId);
	
	public Map<String,Double> getJackpotSortedBySumDonation();
	
	public Map<String,Double> getUsersSortedBySumDonation();
	
	public double getAvgDonationForJackpot(int jackpotId);
}
