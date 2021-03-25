package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.RatingServiceImpl;
import tn.esprit.spring.entities.Rating;


@RestController
public class RatingController {
	@Autowired
	RatingServiceImpl ratingService;
	
	
	//http://localhost:8081/ConsomiTounsi/servlet/add-rating
	@PostMapping("/add-rating")
	@ResponseBody
	public String addRating(@RequestBody Rating r) 
	{
	return ratingService.addRating(r);
	//return rating;
	}
	
	//http://localhost:8081/ConsomiTounsi/servlet/retrieve-all-ratings
	@GetMapping(value ="/retrieve-all-ratings")
	@ResponseBody
	public List<Rating> getRatings() 
	{
	
	return ratingService.retrieveAllRating();
    
	} 
	
	
	//http://localhost:8081/ConsomiTounsi/servlet/remove-rating/{id}
	@DeleteMapping("/remove-rating/{id}")
	@ResponseBody
	public void removeRating(@PathVariable("id") Long id) {
	ratingService.deleteRating(id);
	 }
	
	//http://localhost:8081/ConsomiTounsi/servlet/update-rating
	@PutMapping("/update-rating")
	@ResponseBody
	public String modifyRating(@RequestBody Rating r) {

		return ratingService.addRating(r);

	}
	@GetMapping("/editNote/{id}&{note}")
	public String updateNote(@PathVariable("id") Long id,@PathVariable("note") int note){
			return ratingService.updateRating(id, note);
		
	}
	
	//http://localhost:8081/ConsomiTounsi/servlet/retrieve-nbvu
		@GetMapping(value ="/retrieve-nbvu")
		@ResponseBody
		public int getNbvu(@PathVariable("id") Long id) 
		{
		
		return ratingService.nbReview(id);
	    
		} 
		
		//http://localhost:8081/ConsomiTounsi/servlet/retrieve-all-ratingParProduct/{id}
		@GetMapping(value = "retrieve-all-ratingParProduct/{id}")
		@ResponseBody
		public List<Rating> getReviewsParProduct(@PathVariable("id") Long id) {

			return ratingService. retrieveAllReviews(id);

		}
		
		
		//http://localhost:8081/ConsomiTounsi/servlet/retrieve-last-reviews
		@GetMapping(value ="/retrieve-last-reviews")
		@ResponseBody
		public List<Rating> getLastReviews(Long id) 
		{
		
		return ratingService.listLastReviews(id);
	    
		} 
	
}
