package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.RayonRepository;
import tn.esprit.spring.entities.Rayon;



@Service
public class RayonServiceImpl implements IRayonService {
	
	@Autowired
	private RayonRepository rayonRepository;

	@Override
	public int addRayon(Rayon r) {
		rayonRepository.save(r);
		return r.getId();
	}

	@Override
	public void deleteRayon(int i) {
		rayonRepository.deleteById(i);
		
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		rayonRepository.save(r);
		return r ;
	}

	@Override
	public List<Rayon> getAllRayons() {
		List<Rayon> Rayons = (List<Rayon>) rayonRepository.findAll();	
		return Rayons;
	}

}
