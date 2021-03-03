package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Category;

public interface ICategoryService {
	
	public int addCategory(Category c);

	public void deleteCategory(int i);
	
	public List<Category> retrieveAllCategories(int id);
	
	public Category updateCategory(Category c);
}
