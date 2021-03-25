package tn.esprit.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.AddRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Service.ADDViewServiceImpl;
import tn.esprit.spring.entities.ADDView;
import tn.esprit.spring.entities.Add;
import tn.esprit.spring.entities.User;




@RestController
public class ADDViewController {
	@Autowired
	ADDViewServiceImpl addviewService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddRepository addRepository;
	
	// http://localhost:8081/ConsomiTounsi/servlet/addview/{iduser}&{idad}
	@RequestMapping(method=RequestMethod.PUT,value="addview/{iduser}&{idad}")
	public String addvu(@PathVariable Long  iduser,@PathVariable Long  idad){
			
			Optional<User> user=userRepository.findById(iduser);
			System.out.println(user);
			Add add = addRepository.findById(idad).get();
			
			ADDView av=new ADDView();
			av.setUser(user.get());
			av.setAdd(add);
			return	addviewService.addVu(iduser, idad,av);
		}
	
	//http://localhost:8081/ConsomiTounsi/servlet/retrieve-nbreviews
	@GetMapping(value ="/retrieve-nbreviews")
	@ResponseBody
	public int getNbreviews(@PathVariable("id") Long id) 
	{
	
	return addviewService.nbVu(id);
    
	}


}
