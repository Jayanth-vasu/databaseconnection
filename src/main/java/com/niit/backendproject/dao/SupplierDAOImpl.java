package com.niit.backendproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	public SupplierDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);

	}

	@Transactional
	public void delete(String id) {
		Supplier suppliertodelete = new Supplier();
		suppliertodelete.setSupplier_id(id);
		sessionFactory.getCurrentSession().delete(suppliertodelete);
	}

	@Transactional
	public Supplier get(String id) {
		String hql = "from Supplier where id =" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> listsupplier = (List<Supplier>) query.list();
		if (listsupplier != null && listsupplier.isEmpty()) {
			return listsupplier.get(0);
		}
		return null;
	}

	@Transactional
	public List<Supplier> list() {

		@SuppressWarnings("unchecked")
		List<Supplier> listsupplier = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listsupplier;
	}

}
