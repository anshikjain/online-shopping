package com.ans.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ans.shoppingbackend.dao.CategoryDao;
import com.ans.shoppingbackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		String selectQuery = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
		query.setParameter("active", true);	
		return query.getResultList();
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub

		try {

			Category category = sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
			return category;
		} catch (Exception exception) {
			return null;
		}

	}

	@Override
	public boolean add(Category category) {
		try {

			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
	
	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
	
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

}
