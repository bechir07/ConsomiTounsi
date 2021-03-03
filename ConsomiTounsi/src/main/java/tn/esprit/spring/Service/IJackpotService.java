package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Jackpot;

public interface IJackpotService {

	public int addJackpot(Jackpot j);

	public void deleteJackpot(int i);
	
	public List<Jackpot> retrieveAllJackpots();
	
	public Jackpot updateJackpot(Jackpot j);
}
