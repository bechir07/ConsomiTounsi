package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.RatingRepository;
import tn.esprit.spring.entities.Rating;



@Service
public class RatingServiceImpl implements IRatingService {
	
	@Autowired
	private RatingRepository RatingRepository;
	private static final Logger L = (Logger) LogManager.getLogger(ProductServiceImpl.class);
	

	
	@Override
	public String addRating(Rating r,Long idp,long u )
	{

		Rating ra= new Rating();
		ra=RatingRepository.ratingexist(u, idp);
		if (ra==null)
		{
		r.setDateRating(new Date());
		RatingRepository.save(r);
		return "save with succes";
		}
		return "rating added";
	}
	

	@Override
	public void deleteRating(Long i) {
		RatingRepository.deleteById(i);
		
	}

	@Override
	public List<Rating> retrieveAllReviews(Long id) {
		
		return RatingRepository.listReviews(id);

	}

	@Override
	public int nbReview(Long id) {
		return RatingRepository.nbreviews(id);
	}

	@Override
	public String updateRating(Long id, int note) {
		Rating rating = new Rating();

		rating = RatingRepository.findById(id).get();

		 rating.setNote(note);

		// rating.setNote(5);
		rating.setDateRating(new Date());
		RatingRepository.save(rating);

		return "note enregistré";
	}

	@Override
	public List<Rating> listLastReviews(Long id) {
		return RatingRepository.listLastReviews(id);
	}

	
	public List<Rating> retrieveAllRating() {
		List<Rating> ratings = (List<Rating>) RatingRepository.findAll();
		/*for (Rating rating : ratings) {
			L.info("user +++ : " + rating);
		}*/
		return ratings;

	}
}
