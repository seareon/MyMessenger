package com.seareon.dao.post;

import com.seareon.model.Post;

public interface PostDAO {
	long savePost(Post post);
    void deletePost(long id);		// надо ли??
    void updatePost(Post post);
    Post getPost(long id);
}
