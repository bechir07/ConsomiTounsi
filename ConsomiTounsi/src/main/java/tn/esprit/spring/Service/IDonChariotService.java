package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.DonChariot;;

public interface IDonChariotService {
	
	public int addDonChariot(DonChariot dc);

	public void deleteDonChariot(int i);
	
	public List<DonChariot> retrieveAllDonChariots();
	
	public DonChariot updateDonChariot(DonChariot dc);

}
