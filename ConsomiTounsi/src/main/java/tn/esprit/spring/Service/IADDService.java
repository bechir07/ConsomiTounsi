package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Add;

public interface IADDService {
	public Add addADD(Add a);

	public void deleteADD(int i);
	
	public List<Add> retrieveAllAdds();
	
	public Add updateADD(Add a);
}
