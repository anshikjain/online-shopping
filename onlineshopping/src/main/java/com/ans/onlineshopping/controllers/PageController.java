package com.ans.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ans.shoppingbackend.dao.CategoryDao;
import com.ans.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value = {"/", "/index", "/home"})
	public ModelAndView index()
	{
		System.out.println("Inside index()");
		ModelAndView modelView = new ModelAndView("page");
		modelView.addObject("userClickHome", true);
		modelView.addObject("title", "Home");
		modelView.addObject("categories", categoryDao.list());
		return modelView;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about()
	{
		System.out.println("Inside about()");
		ModelAndView modelView = new ModelAndView("page");
		modelView.addObject("userClickAbout", true);
		modelView.addObject("title", "About Us");
		return modelView;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact()
	{
		System.out.println("Inside contact()");
		ModelAndView modelView = new ModelAndView("page");
		modelView.addObject("userClickContact", true);
		modelView.addObject("title", "Contact Us");
		return modelView;
	}
	
	@RequestMapping(value = "/listProducts")
	public ModelAndView listProducts()
	{
		System.out.println("Inside listProducts()");
		ModelAndView modelView = new ModelAndView("page");
		modelView.addObject("userClickAllProducts", true);
		modelView.addObject("title", "All Products");
		modelView.addObject("categories", categoryDao.list());
		return modelView;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showProductsByCategory(@PathVariable("id") int id)
	{
		System.out.println("Inside showProductsByCategory()");
		
		Category category = categoryDao.getCategoryById(id);
		
		ModelAndView modelView = new ModelAndView("page");
		modelView.addObject("userClickCategoryProducts", true);
		modelView.addObject("title", category.getName());
		modelView.addObject("category", category);
		modelView.addObject("categories", categoryDao.list());
		return modelView;
	}
	
}
