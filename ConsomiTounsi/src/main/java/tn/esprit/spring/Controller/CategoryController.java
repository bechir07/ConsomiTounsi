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

import tn.esprit.spring.Service.CategoryServiceImpl;
import tn.esprit.spring.entities.Category;




@RestController
public class CategoryController {

@Autowired
CategoryServiceImpl categoryService ;

//http://localhost:8081/ConsomiTounsi/servlet/add-category
@PostMapping("/add-category")
@ResponseBody
public Category addCategory(@RequestBody Category c) 
{
return categoryService.addCategory(c);

}

//http://localhost:8081/ConsomiTounsi/servlet/retrieve-all-categories

@GetMapping(value ="/retrieve-all-categories")
@ResponseBody
public List<Category> getCategories() {

return categoryService.retrieveAllCategories();

} 

//http://localhost:8081/ConsomiTounsi/servlet/remove-category/{id}

@DeleteMapping("/remove-category/{id}")
@ResponseBody
public void removeCategory(@PathVariable("id") int id) {
categoryService.deleteCategory(id);
 }


//http://localhost:8081/ConsomiTounsi/servlet/update-category

@PutMapping("/update-category")
@ResponseBody
public Category modifyCategory(@RequestBody Category c) {

	return categoryService.addCategory(c);

}

}
