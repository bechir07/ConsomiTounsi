package tn.esprit.spring.Controller;

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
	public Rating addRating(@RequestBody Rating r) 
	{
	return ratingService.addRating(r);
	//return rating;
	}
	
	//http://localhost:8081/ConsomiTounsi/servlet/retrieve-all-ratings
	@GetMapping(value ="/retrieve-all-ratings")
	@ResponseBody
	public List<Rating> getRatings() 
	{
	
	return ratingService.retrieveAllReviews();
    
	} 
	
	
	//http://localhost:8081/ConsomiTounsi/servlet/remove-rating/{id}
	@DeleteMapping("/remove-rating/{id}")
	@ResponseBody
	public void removeRating(@PathVariable("id") int id) {
	ratingService.deleteRating(id);
	 }
	
	//http://localhost:8081/ConsomiTounsi/servlet/update-rating
	@PutMapping("/update-rating")
	@ResponseBody
	public Rating modifyRating(@RequestBody Rating r) {

		return ratingService.addRating(r);

	}

}
