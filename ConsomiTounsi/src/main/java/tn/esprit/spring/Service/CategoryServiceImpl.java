package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CategoryRepository;
import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Rating;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository CategoryRepository;
	@Override
	public Category addCategory(Category c) {
		CategoryRepository.save(c);
		return c;
		
	}

	@Override
	public void deleteCategory(int i) {
		CategoryRepository.deleteById(i);
		
	}

	@Override
	public List<Category> retrieveAllCategories() {
		List<Category> categories = (List<Category>) CategoryRepository.findAll();	
		return categories;
	}

	@Override
	public Category updateCategory(Category c) {
		CategoryRepository.save(c);
		return c;
	}

}
