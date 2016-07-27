package com.niit.backendproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Transactional
	public void delete(String id) {
		User usertodelete = new User();
		usertodelete.setUser_id(id);
		sessionFactory.getCurrentSession().delete(usertodelete);
	}

	@Transactional
	public User get(String id) {
		String hql = "from User where id =" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listuser = (List<User>) query.list();
		if (listuser != null && listuser.isEmpty()) {
			return listuser.get(0);
		}
		return null;
	}

	@Transactional
	public List<User> list() {

		@SuppressWarnings("unchecked")
		List<User> listuser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listuser;
	}

}
