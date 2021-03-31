package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.AddRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Service.LikeAddServiceImpl;
import tn.esprit.spring.entities.Add;
import tn.esprit.spring.entities.LikeAdd;
import tn.esprit.spring.entities.User;

@RestController
public class LikeAddController {

	@Autowired
	LikeAddServiceImpl likeaddService ;
	@Autowired
	UserRepository userRepository ;
	@Autowired
	AddRepository addRepository ;
	
	// http://localhost:8081/ConsomiTounsi/add-like
	@PostMapping("/add-like")
	@ResponseBody
	public String addLike(@RequestBody LikeAdd l) 
	{
	return likeaddService.addLike(l);
	}
	
	
	// http://localhost:8081/ConsomiTounsi/retrieve-all-likes
	@GetMapping(value ="/retrieve-all-likes")
	@ResponseBody
	public List<LikeAdd> getLikes() {
	
	return likeaddService.retrieveAllLike();
	}

	// http://localhost:8081/ConsomiTounsi/editLike/{id}/{etat}
	@GetMapping("/editLike/{id}/{etat}")
	public String updateLike(@PathVariable("id") Long id,@PathVariable("etat") boolean etat){
			return likeaddService.updateLike(id, etat);
		
	}
	
	
	// http://localhost:8081/ConsomiTounsi/addLike/{idad}/{etat}/{iduser}
	@RequestMapping(method=RequestMethod.PUT,value="/addLike/{idad}/{etat}/{iduser}")
    public String addlike(@PathVariable("iduser") Long  iduser,@PathVariable("iduser") Long  idad,@PathVariable boolean  etat){
		
		
		User us=userRepository.findAllById(iduser);
		
		Add add = addRepository.findById(idad).get();
		
		LikeAdd la=new LikeAdd();
		la.setUser(us);
		la.setAdd(add);
		la.setEtat(etat);
		if(etat==true){
		return	likeaddService.addLike(iduser, idad, la);
		}
		else
		return likeaddService.addDislike(iduser, idad, la);
	
	    }
	
	
		// http://localhost:8081/ConsomiTounsi/remove-like/{idadd}/{iduser}
		@DeleteMapping("/remove-like/{idadd}/{iduser}")
		public void removeLike(@PathVariable("idadd") Long idadd,@PathVariable("iduser") Long iduser) {
		
		
		likeaddService.deleteLike(iduser,idadd);
		}
	
		//http://localhost:8081/ConsomiTounsi/nblikes/{id}
		@GetMapping(value ="/nblikes/{id}")
		@ResponseBody
		public int getNblikes(@PathVariable("id") Long id) 
		{
		
		return likeaddService.nbLike(id);
	    
		}
		
		
		//http://localhost:8081/ConsomiTounsi/nbdislikes/{id}
		@GetMapping(value ="/nbdislikes/{id}")
		@ResponseBody
		public int getNbdislikes(@PathVariable("id") Long id) 
		{
		
		return likeaddService.nbdisLike(id);
	    
		}
		// http://localhost:8081/ConsomiTounsi/addDislike/{idad}/{iduser}
		@RequestMapping(method=RequestMethod.PUT,value="/addDislike/{idad}/{iduser}")
	    public String addDislike(@PathVariable Long  iduser,@PathVariable Long  idad,LikeAdd likeadd)
		{
			
			
		return likeaddService.addDislike(iduser,idad,likeadd);
		
		    }

}
