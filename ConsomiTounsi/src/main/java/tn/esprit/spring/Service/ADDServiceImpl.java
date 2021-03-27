package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.AddRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.Add;



@Service
public class ADDServiceImpl implements IADDService {
	@Autowired
	private AddRepository AddRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Add addADD(Add a) {
		AddRepository.save(a);
		return a;
	}
	
	@Override
	public void deleteADD(Long i) {
		AddRepository.deleteById(i);
		
	}

	@Override
	public List<Add> retrieveAllAdds() {
		List<Add> adds = (List<Add>) AddRepository.findAll();	
		return adds;
	}

	@Override
	public Add updateADD(Add a) {
		AddRepository.save(a);
		return a;
	}
	
	@Override
	public List<Add> searchAdd(String msg)
	{
		return AddRepository.searchAdd(msg);

	}

	@Override
	public byte[] findImage(int imageId) {
		return AddRepository.getImage(imageId);

	}

	@Override
	public List<Add> retrieveAddsExpensive() {
		return AddRepository.listAdd();

	}
	
	@Override
	public Add getAddByName(String msg) {
		return AddRepository.getAddByName(msg);
	}
	
	
	

}
