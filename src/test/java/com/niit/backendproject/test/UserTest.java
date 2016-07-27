package com.niit.backendproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backendproject.dao.UserDAO;
import com.niit.backendproject.model.User;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopping");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");
		user.setUser_id("User01");
		user.setMail_id("");
		user.setUser_name("");
		user.setMobile_number("");
		user.setPassword("");

		userDAO.saveOrUpdate(user);
		context.close();
	}
}
