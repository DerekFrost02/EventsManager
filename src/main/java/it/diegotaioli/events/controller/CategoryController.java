package it.diegotaioli.events.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.exceptions.BadRequestException;
import it.diegotaioli.events.models.Category;
import it.diegotaioli.events.services.CategoryService;
import jakarta.validation.Valid;

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
	
	@GetMapping("api/categories/{id}")
	public ResponseEntity<List<Category>> indexById()
	{
		List<Category> categories = this.categoryService.getAll();
		return ResponseEntity.ok(categories);
	}
	
	@PostMapping("api/categories")
	public ResponseEntity<Category> store(
			@Valid @RequestBody Category requestCategory,
			BindingResult result
			) throws BadRequestException {
		if(result.hasErrors()) {
			ArrayList<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			throw new BadRequestException(errors);
		}
		
		Category categoryInserted = this.categoryService.insertCategory(requestCategory);
		return new ResponseEntity<>(categoryInserted, HttpStatus.CREATED);
	}

}
