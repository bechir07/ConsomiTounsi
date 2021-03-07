package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.DonChariotRepository;
import tn.esprit.spring.entities.DonChariot;

@Service
public class DonChariotServiceImpl implements IDonChariotService {
	
	@Autowired
	private DonChariotRepository DonChariotRepository;
	@Override
	public int addDonChariot(DonChariot dc) {
		DonChariotRepository.save(dc);
		return dc.getId();
	}

	@Override
	public void deleteDonChariot(int i) {
		DonChariotRepository.deleteById(i);
		
	}

	@Override
	public List<DonChariot> retrieveAllDonChariots() {
		List<DonChariot> DonChariots = (List<DonChariot>) DonChariotRepository.findAll();	
		return DonChariots;
	}

	@Override
	public DonChariot updateDonChariot(DonChariot dc) {
		DonChariotRepository.save(dc);
		return dc ;
	}

}
