package com.ans.shoppingbackend.dao;

import java.util.List;



import com.ans.shoppingbackend.dto.Category;


public interface CategoryDao {
	
	public boolean add(Category category);
	
	public List<Category> list();

	public Category getCategoryById(int id);

	boolean update(Category category);

	boolean delete(Category category);
}
