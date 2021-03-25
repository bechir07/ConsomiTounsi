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

import tn.esprit.spring.Service.Command_lineServiceImpl;
import tn.esprit.spring.entities.Command_line;

@RestController
public class Command_lineController{

	@Autowired
	Command_lineServiceImpl command_lineService;
	
	//http://localhost:8081/ConsomiTounsi/servlet/
		@PostMapping("/addCommand_line")
		public int addCommand_line(@RequestBody Command_line command) {
			command_lineService.addCommandline(command);
			return command.getId();
		}
		
		 /* @GetMapping("/nombreCommand")
		  @ResponseBody
		public long getNombreCommande_lineJPQL() {
		 return command_lineService.getNombreCommand_lineJPQL();
		  }*/
		
		@GetMapping("/getAllCommandes_line")
		public List<Command_line> getAllCommandes_line() {

			return command_lineService.getAllCommandes_line();
		}
		
		//@PutMapping(value = "/mettreAjourByReferenceJPQL/{reference}/{id_client}/{quantite}/{prix_total}/{date_commande}")
		//public void mettreAjourEmailByEmployeIdJPQL(@PathVariable("reference")int reference,@PathVariable("id_client") int id_client,@PathVariable("quantite") int quantite,@PathVariable("prix_total") int prix_total,@PathVariable("date_commande") int date_commande) {
			//commandeService.mettreAjourByReferenceJPQL(reference);
	//}
		

	    @PutMapping(value = "/affecterProductACommand_line/{id}/{id}") 
		public void affecterProductACommand_line(@PathVariable("id")Long id, @PathVariable("id")int idc) {
			command_lineService.affecterPoductACommand_line(id, idc);
		}
	    
	    @PutMapping(value = "/affecterCommandACommand_line/{reference}/{id}") 
			public void affecterCommandACommand_line(@PathVariable("reference")int reference, @PathVariable("id")int id) {
				command_lineService.affecterCommandACommand_line(reference, id);
			}
	/*
	    @GetMapping("/getNamePoductByReference/{reference}")
		public String getNamePoductByReference(@PathVariable("reference") int reference) {
			return commandService.getNamePoductByReference(reference);
		}
	*/
/*
	    @GetMapping("/getCommandlineByid/{id}")
		public List<String> getCommand_lineByIdJPQL(@PathVariable("id") int id) {
			return command_lineService.getCommandByIdJPQL(id);
		}*/
	    
		@DeleteMapping(value = "/deleteByidc/{id}")
		public void deleteById(@PathVariable("id")int id) {
			command_lineService.deleteById(id);
		}
			  @PutMapping(value = "/updatecommande_line") 
				public Command_line updateCommande_line(@RequestBody Command_line command)  {
					return command_lineService.updateCommande_line(command);
				}
			


}
