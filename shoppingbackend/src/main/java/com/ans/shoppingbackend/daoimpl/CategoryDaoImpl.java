package com.ans.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ans.shoppingbackend.dao.CategoryDao;
import com.ans.shoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television description");
		category.setImageURL("CAT_01.png");
		category.setActive(true);
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("Mobile description");
		category2.setImageURL("CAT_02.png");
		category2.setActive(true);
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Laptops");
		category3.setDescription("Laptop description");
		category3.setImageURL("CAT_03.png");
		category3.setActive(true);
		
		categories.add(category);
		categories.add(category2);
		categories.add(category3);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		for (Iterator iterator = categories.iterator(); iterator.hasNext();) {
			Category category = (Category) iterator.next();
			if(category.getId() == id)
			{
				return category;
			}
			
		}
		return null;
		
	}
	
	
	
}
