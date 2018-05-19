package com.ans.onlineshopping.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ans.shoppingbackend.dao.ProductDao;
import com.ans.shoppingbackend.dto.Product;

@RestController
@RequestMapping("/rest")
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDao.listActiveProducts();
	}
	
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id)
	{
		return productDao.listActiveProductsByCategory(id);
	}
}
