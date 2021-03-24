package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Rating;

public interface IRatingService  {
	
	public String addRating(Rating r);

	public void deleteRating(int i);
	
	public List<Rating> retrieveAllReviews(int id);
		
	public int nbReview(int id);



	String updateRating(int id,int note);

	public List<Rating> listLastReviews(int id);

}
