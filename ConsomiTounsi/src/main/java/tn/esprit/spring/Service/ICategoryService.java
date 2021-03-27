package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Category;

public interface ICategoryService {
	
	public Category addCategory(Category c);

	public void deleteCategory(Long i);
	
	public List<Category> retrieveAllCategories();
	
	public Category updateCategory(Category c);
}
