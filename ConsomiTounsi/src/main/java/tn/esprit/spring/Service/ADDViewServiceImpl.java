package tn.esprit.spring.Service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ADDViewRepository;
import tn.esprit.spring.entities.ADDView;


@Service
public class ADDViewServiceImpl implements IADDViewService{

	@Autowired
    private ADDViewRepository addviewRepository ;
	
	private static final Logger L =(Logger) LogManager.getLogger(ADDViewServiceImpl.class);
	
	
	public String addVu(int iduser,int idad, ADDView addview){
		addview.setDateView(new Date());
		addviewRepository.save(addview);
	
		return "add with succes";
	}
	
	public int nbVu(int id)
	{
		return  addviewRepository.nbVu(id);
	}
	
	
}
