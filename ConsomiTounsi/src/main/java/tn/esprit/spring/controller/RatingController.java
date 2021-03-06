package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Repository.RatingRepository;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.Service.RatingServiceImpl;
import tn.esprit.spring.entities.Rating;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.User;


@RestController
public class RatingController {
	@Autowired
	RatingServiceImpl ratingService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private RatingRepository RatingRepository;
	
	// http://localhost:8081/ConsomiTounsi/addRating/{iduser}/{idp}
	
	@RequestMapping(method=RequestMethod.PUT,value="/addRating/{iduser}/{idp}")
	public String addRating(@PathVariable("iduser") Long  iduser,@PathVariable("idp") Long  idp,@RequestBody Rating r){
			
			Optional<User> user=userRepository.findById(iduser);
			//System.out.println(user);
			Product prod = ProductRepository.findById(idp).get();
			
			//Rating r=new Rating();
			
			//r.setNote(r.getNote());
			//r.setReview(r.getReview());
			r.setUser(user.get());
			r.setProduct(prod);
			return	ratingService.addRating(r, idp,iduser);
		}
	
	//http://localhost:8081/ConsomiTounsi/retrieve-all-ratings
	@GetMapping(value ="/retrieve-all-ratings")
	@ResponseBody
	public List<Rating> getRatings() 
	{
	
	return ratingService.retrieveAllRating();
    
	} 
	
	
	//http://localhost:8081/ConsomiTounsi/remove-rating/{id}
	@DeleteMapping("/remove-rating/{id}")
	@ResponseBody
	public void removeRating(@PathVariable("id") Long id) {
	ratingService.deleteRating(id);
	 }
	
	//http://localhost:8081/ConsomiTounsi/update-rating/{id}/{note}
	@PutMapping("/update-rating/{id}/{note}")
	@ResponseBody
	public String modifyRating(@PathVariable("id") Long id,@PathVariable("id") int note) {

		return ratingService.updateRating(id,note);

	}
	//http://localhost:8081/ConsomiTounsi/editNote/{id}/{note}
	@GetMapping("/editNote/{id}/{note}")
	public String updateNote(@PathVariable("id") Long id,@PathVariable("note") int note){
			return ratingService.updateRating(id, note);
		
	}
	
	//http://localhost:8081/ConsomiTounsi/retrieve-nbvu/{id}
		@GetMapping(value ="/retrieve-nbvu/{id}")
		@ResponseBody
		public int getNbvu(@PathVariable("id") Long id) 
		{
		
		return ratingService.nbReview(id);
	    
		} 
		
		//http://localhost:8081/ConsomiTounsi/retrieve-all-ratingParProduct/{id}
		@GetMapping(value = "retrieve-all-ratingParProduct/{id}")
		@ResponseBody
		public List<Rating> getReviewsParProduct(@PathVariable("id") Long id) {

			return ratingService. retrieveAllReviews(id);

		}
		
		
		//http://localhost:8081/ConsomiTounsi/retrieve-last-reviews/{id}
		@GetMapping(value ="/retrieve-last-reviews/{id}")
		@ResponseBody
		public List<Rating> getLastReviews(@PathVariable("id")Long id) 
		{
		
		return ratingService.listLastReviews(id);
	    
		} 
	
}
