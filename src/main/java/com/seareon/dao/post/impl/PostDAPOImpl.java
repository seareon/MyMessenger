package com.seareon.dao.post.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seareon.dao.post.PostDAO;
import com.seareon.model.Post;

@Repository("postDao")
@Transactional
public class PostDAPOImpl implements PostDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.seareon.dao.post.PostDAO#savePost(com.seareon.model.Post)
	 */
	public long savePost(Post post) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(post);
		return post.getId();
	}

	public void deletePost(long id) {
		// TODO Auto-generated method stub
		Post post = new Post();
		post.setId(id);
		Post mergedPost = (Post) sessionFactory.getCurrentSession().merge(post);
		sessionFactory.getCurrentSession().delete(mergedPost);
	}

	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		Post mergedPost = (Post) sessionFactory.getCurrentSession().merge(post);
		sessionFactory.getCurrentSession().update(mergedPost);
	}

	/* (non-Javadoc)
	 * @see com.seareon.dao.post.PostDAO#getPost(long)
	 */
	public Post getPost(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Post.class, id);
	}

}
