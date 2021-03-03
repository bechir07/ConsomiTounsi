package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.JackpotRepository;
import tn.esprit.spring.entities.Jackpot;

@Service
public class JackpotServiceImpl implements IJackpotService {

	@Autowired
	private JackpotRepository JackpotRepository;
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
}
