package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.modals.Exam.Category;
import com.exam.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/test")
	public String categoryTest() {
		return "category test";
	}
	
	// add category
	
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		Category c=this.categoryService.addCategory(category);
		return ResponseEntity.ok(c);
	}
	
	// get mapping
	
	@GetMapping("/get/{id}")
	public Category getCategory(@PathVariable("id") long id){

		return this.categoryService.getCategory(id);
	}
	
	// get All Categories
	@GetMapping("/get-all")
	public List<Category> getAllCategory(){
		return this.categoryService.getCategories();
	}
	
	// update category
	@PutMapping("/update")
	public Category updateCategory(@RequestBody Category category){
		return this.categoryService.updateCategory(category);
	}
	
	// delete category
	
	@DeleteMapping("/delete/{id}")
	public void deleteCategory(@PathVariable("id") long id){
		this.categoryService.deleteCategory(id);
	}
	

}
