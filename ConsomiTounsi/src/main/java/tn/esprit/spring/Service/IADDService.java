package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Add;

public interface IADDService {
	public int addADD(Add a);

	public void deleteADD(int i);
	
	public List<Add> retrieveAllAdds(int id);
	
	public Add updateADD(Add a);
}
