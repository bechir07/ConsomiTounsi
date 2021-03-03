package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Rating;

public interface IRatingService  {
	
	public Rating addRating(Rating r);

	public void deleteRating(int i);
	
	public List<Rating> retrieveAllReviews();
	
	public Rating updateRating(Rating r);

}
