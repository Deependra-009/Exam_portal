package com.exam.services;

import java.util.List;
import java.util.Set;

import com.exam.modals.Exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Category getCategory(long cid);
	public List<Category> getCategories();
	public void deleteCategory(long cid);

}
