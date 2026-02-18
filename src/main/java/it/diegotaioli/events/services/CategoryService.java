package it.diegotaioli.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.diegotaioli.events.models.Category;
import it.diegotaioli.events.repositories.CategoryRepository;

@Service
public class CategoryService {
	
private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getAll()
	{
		return this.categoryRepository.findAll();
	}

}
