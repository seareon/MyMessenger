package com.seareon.dao.profile.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.seareon.dao.profile.ProfileDAO;
import com.seareon.model.Profile;
import com.seareon.util.Constants;

@Repository("profileDao")
@Transactional
public class ProfileDAOImpl implements ProfileDAO {
	@Autowired
    private SessionFactory sessionFactory;

	public long saveProfile(Profile profile) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(profile);
		return profile.getId();
	}

	public void deleteProfile(long id) {
		// TODO Auto-generated method stub
		Profile profile = new Profile();
		profile.setId(id);
		Profile mergedProfile = (Profile) sessionFactory.getCurrentSession().merge(profile);
		sessionFactory.getCurrentSession().delete(mergedProfile);
	}

	public void updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		Profile mergedProfile = (Profile) sessionFactory.getCurrentSession().merge(profile);
		sessionFactory.getCurrentSession().update(mergedProfile);
	}

	public Profile getProfile(long id) {
		// TODO Auto-generated method stub
		Profile profile = sessionFactory.getCurrentSession().get(Profile.class, id);
		return profile;
	}

	public Profile getProfileByUserId(long id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(Constants.QUERY_GET_PROFILE_BY_USER_ID);
		query.setParameter("id", id);
		return (Profile) query.uniqueResult();
	}

	public Profile getProfileByUserLogin(String userLogin) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(Constants.QUERY_GET_PROFILE_BY_USER_LOGIN);
		query.setParameter("login", userLogin);
		Profile profile = (Profile) query.uniqueResult();
		return profile;
	}

}
