package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.LikeAdd;


public interface ILikeAddService {
	
	public String addLike(LikeAdd l);
	public List<LikeAdd> retrieveAllLike();
	public String updateLike(Long id, boolean etat);
	public int nbLike(Long id);
	void deletePubLike(Long id);
	public String deleteLike(Long iduser,Long idadd);
	public int nbdisLike(Long id);

}
