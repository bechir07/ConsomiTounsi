package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.StatService;


@RestController
public class StatController {
	
	@Autowired
	StatService statService;
	//statistique nb des command par année
	@GetMapping(value ="/retrieve-all-usersAnne")
	public List<?> getUser() {
	
	return statService.retrieveAllUser();
    
	
} 
	//statistique nb des command par mois
	@GetMapping(value ="/retrieve-all-usersMois")
	public List<?> getUserMois() {
	
	return statService.retrieveAllUserMois();

}

	/*// nb des enfant par jardin
	@GetMapping(value ="/retrieve-EnfantParJardin")
	public List<?> getEnfantParJardin() {
	
	return statService.retrieveEnfantParJardin();

}
	// nb des enfant par niveau dans chaque jardin
	@GetMapping(value ="/retrieve-EnfantParNiveau")
	public List<?> getEnfantParNiveau() {
	
	return statService.retrieveEnfantParNiveau();

}
*/	
/*	
	
//calcul de score du user depend du nb partage de post , react, commentaire et participation dans les event
@RequestMapping(method = RequestMethod.PUT, value="modify-score")
	
	public void updateScore() {
	 statService.updateScore();
	 }
*/
@GetMapping(value ="/bestUser")
public List<?> getBestUser() {

return statService.BestUser();

}



}