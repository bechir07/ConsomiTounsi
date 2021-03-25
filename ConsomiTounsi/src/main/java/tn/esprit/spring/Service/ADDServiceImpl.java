package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.AddRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.entities.ADDView;
import tn.esprit.spring.entities.Add;
import tn.esprit.spring.entities.Product;


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
	/*public String PubProduct(Product p, Add add)
	{
		
		
	}*/

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
	public List<Add> retrieveAdds() {
		return AddRepository.listAdd();

	}

}
