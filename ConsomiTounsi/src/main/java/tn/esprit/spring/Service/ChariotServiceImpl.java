package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ChariotRepository;
import tn.esprit.spring.entities.Chariot;

@Service
public class ChariotServiceImpl implements IChariotService {

	@Autowired
	private ChariotRepository ChariotRepository;
	@Override
	public int addChariot(Chariot c) {
		ChariotRepository.save(c);
		return c.getId();
	}

	@Override
	public void deleteChariot(int i) {
		ChariotRepository.deleteById(i);
		
	}

	@Override
	public List<Chariot> retrieveAllChariots() {
		List<Chariot> chariots = (List<Chariot>) ChariotRepository.findAll();	
		return chariots;
	}

	@Override
	public Chariot updateChariot(Chariot c) {
		ChariotRepository.save(c);
		return c ;
	}
}
