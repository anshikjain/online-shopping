package com.ans.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ans.shoppingbackend.dao.CategoryDao;
import com.ans.shoppingbackend.dto.Category;

public class TestCategory {
	private static AnnotationConfigApplicationContext applicationContext;
	private static CategoryDao categoryDao;
	private Category category;

	@BeforeClass
	public static void init()
	{
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.ans.shoppingbackend");
		applicationContext.refresh();
		categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
		
	}
	
	@Test
	public void testCRUDCategory()
	{
		category = new Category();
		category.setName("Television");
		category.setDescription("Television description");
		category.setImageURL("CAT_01.png");
		category.setActive(true);
		
		assertEquals("Successfully added category.", true, categoryDao.add(category));
		
		category = new Category();
		category.setName("Mobiles");
		category.setDescription("Mobile description");
		category.setImageURL("CAT_02.png");
		category.setActive(true);
		
		assertEquals("Successfully added category.", true, categoryDao.add(category));
		
		category = new Category();
		category.setName("Laptops");
		category.setDescription("Laptop description");
		category.setImageURL("CAT_03.png");
		category.setActive(true);
		
		assertEquals("Successfully added category.", true, categoryDao.add(category));
		
		category  = categoryDao.getCategoryById(1);
		assertEquals("Successfully fetched category.", "Television", category.getName());
		
		category.setName("TV");
		category.setDescription("TV description");
		assertEquals("Successfully updated category.", true, categoryDao.update(category));
		
		assertEquals("Successfully deleted category.", true, categoryDao.delete(category));
		
		assertEquals("Successfully fetched categories.", 2, categoryDao.list().size());
		
	}
	

//	@Test
//	public void testGetCategory()
//	{
//		category  = categoryDao.getCategoryById(1);
//		assertEquals("Successfully fetched category.", "Television", category.getName());
//	}
	
	
}
