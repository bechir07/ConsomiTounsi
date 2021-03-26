package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Add;

public interface IADDService {
	public Add addADD(Add a);

	public void deleteADD(Long i);
	
	public List<Add> retrieveAllAdds();
	
	public Add updateADD(Add a);
	
	byte[] findImage(int imageId);
	
	List<Add> searchAdd(String msg);
	
	List<Add> retrieveAddsExpensive();
	
	public Add getAddByName(String msg);
	


}
