package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ParticipationRepository;
import tn.esprit.spring.entities.Participation;

@Service
public class ParticipationServiceImpl implements IParticipationService{

	@Autowired
	private ParticipationRepository ParticipationRepository;
	@Override
	public int addParticipation(Participation p) {
		ParticipationRepository.save(p);
		return p.getId();
	}

	@Override
	public void deleteParticipation(int i) {
		ParticipationRepository.deleteById(i);
		
	}

	@Override
	public List<Participation> retrieveAllParticipations() {
		List<Participation> Participations = (List<Participation>) ParticipationRepository.findAll();	
		return Participations;
	}

	@Override
	public Participation updateParticipation(Participation p) {
		ParticipationRepository.save(p);
		return p ;
	}
}
