package com.exam.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.modals.Exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category getCategory(long cid) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(cid).get();
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public void deleteCategory(long cid) {
		// TODO Auto-generated method stub
		Category c=new Category();
		c.setCid(cid);
		this.categoryRepository.delete(c);
	}

}
