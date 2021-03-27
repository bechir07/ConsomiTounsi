package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Rating;

public interface IRatingService  {
	
	public String addRating(Rating r,Long idp,long u );

	public void deleteRating(Long i);
	
	public List<Rating> retrieveAllReviews(Long id);
		
	public int nbReview(Long id);



	String updateRating(Long id,int note);

	public List<Rating> listLastReviews(Long id);

}
