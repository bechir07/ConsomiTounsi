package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.Service.ExchangeService;
import tn.esprit.spring.entities.Exchange;
import tn.esprit.spring.entities.Reparation;

@RestController
@RequestMapping("/Exchange")
public class ExchangeController {
	
	@Autowired
	ExchangeService exchangeService;
	
	@GetMapping(value = "/exchanges")
	@ResponseBody
	public List<Exchange> getExchanges() {

		return exchangeService.getAllEchanges();

	}
	
	@GetMapping(value = "/exchangesByUsers/{id}")
	@ResponseBody
	public List<Exchange> getExchangesByUsersId(@PathVariable("id") int id) {

		return exchangeService.getAllExchangeByUsersId(id);

	}
	
	
	@PatchMapping("/updateExchange/{id}")
	 Exchange updateReparation(@RequestBody Exchange e ,@PathVariable("id") Long id ) {
		return exchangeService.updateExchange(e, id);
	}
	
	@DeleteMapping("/deleteExchange")
	@ResponseBody String deleteExchange(@RequestParam(name="id",defaultValue="0")int id) {
		exchangeService.deleteExchange(id);
		return "done";
	}
	
}
