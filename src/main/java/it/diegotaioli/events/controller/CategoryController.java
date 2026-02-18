package it.diegotaioli.events.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.models.Category;
import it.diegotaioli.events.services.CategoryService;

@RestController
public class CategoryController {
	
private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("api/categories")
	public ResponseEntity<List<Category>> index()
	{
		List<Category> categories = this.categoryService.getAll();
		return ResponseEntity.ok(categories);
	}

}
