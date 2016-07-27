package com.niit.backendproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backendproject.dao.CategoryDAO;
import com.niit.backendproject.model.Category;

public class CategoryTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backendproject");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		category.setCategory_id("CG189");
		category.setDescription("laptop");
		category.setCategory_name("HP");
		categoryDAO.saveOrUpdate(category);
		context.close();
	}
}
