package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.AddRepository;
import tn.esprit.spring.entities.Add;


@Service
public class ADDServiceImpl implements IADDService {
	@Autowired
	private AddRepository AddRepository;

	@Override
	public Add addADD(Add a) {
		AddRepository.save(a);
		return a;
	}

	@Override
	public void deleteADD(int i) {
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

}
