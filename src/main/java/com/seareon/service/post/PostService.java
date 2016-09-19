package com.seareon.service.post;

import com.seareon.dto.PostDTO;
import com.seareon.model.Post;

public interface PostService {
	long savePost(PostDTO postDTO);
	void deletePost(long id);
	void updatePost(Post post);
	Post getPost(long id);
}
