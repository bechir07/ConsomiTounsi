package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Rating;

public interface IRatingService  {
	
	public int addRating(Rating r);

	public void deleteRating(int i);
	
	public List<Rating> retrieveAllReviews(int id);
	
	public Rating updateRating(Rating r);

}
