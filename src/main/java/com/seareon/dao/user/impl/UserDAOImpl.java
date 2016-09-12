package com.seareon.dao.user.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.seareon.dao.user.UserDAO;
import com.seareon.model.User;
import com.seareon.util.Constants;

@Repository("userDao")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
    private SessionFactory sessionFactory;

	public long saveUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		User mergedUser = (User) sessionFactory.getCurrentSession().merge(user);
		sessionFactory.getCurrentSession().update(mergedUser);

	}

	public User getUser(long id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(Constants.QUERY_GET_USER_BY_ID);
		query.setParameter("id", id);
		return (User) query.uniqueResult();
	}

	public User getUserByName(String login) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(Constants.QUERY_GET_USER_BY_LOGIN);
		query.setParameter("login", login);
		return (User) query.uniqueResult();
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(id);
		User mergedUser = (User) sessionFactory.getCurrentSession().merge(user);
		sessionFactory.getCurrentSession().delete(mergedUser);
	}

}
