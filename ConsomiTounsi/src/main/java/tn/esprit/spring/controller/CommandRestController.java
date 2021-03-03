package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.CommandServiceImpl;
import tn.esprit.spring.entities.Command;


@RestController
public class CommandRestController {

	@Autowired
	CommandServiceImpl commandService;
	
	@PostMapping("/addCommand")
	public int addCommand(@RequestBody Command command) {
		commandService.addCommand(command);
		return command.getReference();
	}
	
	  @GetMapping("/nombreCommand")
	  @ResponseBody
	public long getNombreCommandeJPQL() {
	 return commandService.getNombreCommandJPQL();
	  }
	
	@GetMapping("/getAllCommandes")
	public List<Command> getAllCommandes() {

		return commandService.getAllCommandes();
	}
	
	//@PutMapping(value = "/mettreAjourByReferenceJPQL/{reference}/{id_client}/{quantite}/{prix_total}/{date_commande}")
	//public void mettreAjourEmailByEmployeIdJPQL(@PathVariable("reference")int reference,@PathVariable("id_client") int id_client,@PathVariable("quantite") int quantite,@PathVariable("prix_total") int prix_total,@PathVariable("date_commande") int date_commande) {
		//commandeService.mettreAjourByReferenceJPQL(reference);
//}
	

    @PutMapping(value = "/affecterProductACommand/{id}/{reference}") 
	public void affecterProductACommand(@PathVariable("id")int id, @PathVariable("reference")int reference) {
		commandService.affecterPoductACommand(id, reference);
	}

    @GetMapping("/getNamePoductByReference/{reference}")
	public String getNamePoductByReference(@PathVariable("reference") int reference) {
		return commandService.getNamePoductByReference(reference);
	}


    @GetMapping("/getCommandByReference/{reference}")
	public List<String> getCommandByReferenceJPQL(@PathVariable("reference") int reference) {
		return commandService.getCommandByReferenceJPQL(reference);
	}
    
	@DeleteMapping(value = "/deleteByReference/{reference}")
	public void deleteByReference(@PathVariable("reference")int reference) {
		commandService.deleteByReference(reference);
	}
		  @PutMapping(value = "/updatecommande") 
			public Command updateCommande(@RequestBody Command command)  {
				return commandService.updateCommande(command);
			}
		





} 


