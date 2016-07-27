package com.niit.backendproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}

	@Transactional
	public void delete(String id) {
		Product producttodelete = new Product();
		producttodelete.setProduct_id(id);
		sessionFactory.getCurrentSession().delete(producttodelete);
	}

	@Transactional
	public Product get(String id) {
		String hql = "from Product where id =" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listproduct = (List<Product>) query.list();
		if (listproduct != null && !listproduct.isEmpty()) {
			return listproduct.get(0);
		}
		return null;
	}

	@Transactional
	public List<Product> list() {

		@SuppressWarnings("unchecked")
		List<Product> listproduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listproduct;
	}

}
