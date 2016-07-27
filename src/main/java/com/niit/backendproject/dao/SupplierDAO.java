package com.niit.backendproject.dao;

import java.util.List;

import com.niit.backendproject.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();

	public Supplier get(String id);

	public void saveOrUpdate(Supplier supplier);

	public void delete(String id);
}
