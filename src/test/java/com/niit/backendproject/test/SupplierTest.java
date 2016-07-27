package com.niit.backendproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backendproject.dao.SupplierDAO;
import com.niit.backendproject.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopping");
		context.refresh();

		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setSupplier_id("");
		supplier.setSupplier_address("");
		supplier.setSupplier_name("");
		supplierDAO.saveOrUpdate(supplier);
		context.close();
	}
}
