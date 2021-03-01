package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.RatingRepository;
import tn.esprit.spring.entities.Rating;



@Service
public class RatingServiceImpl implements IRatingService {
	
	@Autowired
	private RatingRepository RatingRepository;
	
	@Override
	public int addRating(Rating r) {
		RatingRepository.save(r);
		return r.getId();
	}

	@Override
	public void deleteRating(int i) {
		RatingRepository.deleteById(i);
		
	}

	@Override
	public List<Rating> retrieveAllReviews(int id) {
		
			List<Rating> ratings = (List<Rating>) RatingRepository.findAll();	
			return ratings;

	}

	@Override
	public Rating updateRating(Rating r) {
		RatingRepository.save(r);
		return r;
	}

}
