package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.LikeAddRepository;


import tn.esprit.spring.entities.LikeAdd;

@Service
public class LikeAddServiceImpl implements ILikeAddService{
	private static final Logger L =(Logger) LogManager.getLogger(LikeAddServiceImpl.class);

	@Autowired
    private LikeAddRepository LikeAddRepository;
	@Override
	public String addLike(LikeAdd l) {
		List<LikeAdd> like =new ArrayList<LikeAdd>();
		like=LikeAddRepository.findAll();

		
		for( LikeAdd la : like)
		{
			if (l.getAdd().getId()==la.getAdd().getId() && (l.getUser().getId().equals(la.getUser().getId() ) ) && 
					l.isEtat()==la.isEtat())
				 // throw new RuntimeException("You can't cancel these !");
			{
				
			return "user a déja aimé cette pub";
}
	
			else 
		    {
			LikeAddRepository.save(l);
			
				}
}
		return "like enregistré";
	}

public String addLike(Long iduser,Long idad,LikeAdd likeadd){
		LikeAdd la= new LikeAdd();
		la=LikeAddRepository.likeexist(iduser, idad);
		if (la==null)
		{
		LikeAddRepository.save(likeadd);
		return "save with succes";
		}
		else if(la.isEtat()==false){
			la.setEtat(true);
			LikeAddRepository.save(la);
		}
		return "update with succes";
	}
	public String addDislike(Long iduser,Long idad,LikeAdd likeadd){
	LikeAdd la= new LikeAdd();
	la=LikeAddRepository.likeexist(iduser, idad);
	if (la==null){
	LikeAddRepository.save(likeadd);
	return "save with succes";
	}
	else if(la.isEtat()==true){
		la.setEtat(false);
		LikeAddRepository.save(la);
	}
	return "update with succes";
	}

	@Override
	public List<LikeAdd> retrieveAllLike() {
		List<LikeAdd> likes = (List<LikeAdd>) LikeAddRepository.findAll();
		/*for (LikeAdd like : likes) {
			L.info("user +++ : " + like);
		}*/
		return likes;
	}

	@Override
	public String updateLike(Long id, boolean etat) {
		LikeAdd like =new LikeAdd();
		like= LikeAddRepository.findAllById(id);

		like.setEtat(etat);
		
		LikeAddRepository.save(like);
       		return "react updated";
	}

	@Override
	public int nbLike(Long id) {
		return LikeAddRepository.nbLike(id);
	}
	@Override
	public int nbdisLike(Long id) {
		return LikeAddRepository.nbDisLike(id);
	}

	@Override
	public void deletePubLike(Long id) {
		LikeAddRepository.deleteById(id);
		
	}

	@Override
	public String deleteLike(Long iduser, Long idadd) {
		LikeAdd la= new LikeAdd();
		la=LikeAddRepository.likeexist(iduser, idadd);
		if (la==null)
		{
		
		return "add doesn't exist";
		}
		else {
			
			LikeAddRepository.delete(la);
		}
		return "deletion with succes";
	}

}
