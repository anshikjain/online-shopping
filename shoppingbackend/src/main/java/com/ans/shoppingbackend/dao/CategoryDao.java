package com.ans.shoppingbackend.dao;

import java.util.List;



import com.ans.shoppingbackend.dto.Category;


public interface CategoryDao {
	
	public List<Category> list();

	public Category getCategoryById(int id);
}
