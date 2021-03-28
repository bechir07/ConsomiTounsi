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

import tn.esprit.spring.Service.ADDServiceImpl;
import tn.esprit.spring.entities.Add;




@RestController
public class ADDController {

	@Autowired
	ADDServiceImpl addService ;
	
	
	// http://localhost:8081/ConsomiTounsi/add-ADD
	@PostMapping("/add-ADD")
	@ResponseBody
	public Add addADD(@RequestBody Add a) {

		return addService.addADD(a);

	}
	
	// http://localhost:8081/ConsomiTounsi/update-add
	@PutMapping("/update-add")
	@ResponseBody
	public Add modifyAdd(@RequestBody Add a) {

		return addService.addADD(a);

	}
	
	// http://localhost:8081/ConsomiTounsi/remove-add/{id}
	@DeleteMapping("/remove-add/{id}")
	@ResponseBody
	public void removeAdd(@PathVariable("id") Long id) {
		addService.deleteADD(id);
	}
	
	
	// http://localhost:8081/ConsomiTounsi/retrieve-all-adds
	@GetMapping(value = "/retrieve-all-adds")
	@ResponseBody
	public List<Add> getAdds() {

		return addService.retrieveAllAdds();

	}
	
	// http://localhost:8081/ConsomiTounsi/retrieve-adds-expensive
	@GetMapping(value = "/retrieve-adds-expensive")
	@ResponseBody
	public List<Add> getExpensiveAdd() {

		return addService.retrieveAddsExpensive();

	}
	
	//http://localhost:8081/ConsomiTounsi/retrieve-add-by-name
	@GetMapping(value="/retrieve-add-by-name/{name}")
	@ResponseBody
	public Add getAddByName(@PathVariable("name") String name) {
	return addService.getAddByName(name);
	}

	//http://localhost:8081/ConsomiTounsi/search-add
	    	@GetMapping(value="/search-add/{msg}")
	    	@ResponseBody
	    	public List<Add> getAddSearch(@PathVariable("msg") String msg) {
	    	return addService.searchAdd(msg);
	}
	
	
}
