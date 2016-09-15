package com.seareon.service.post;

import com.seareon.dto.PostDTO;

public interface PostService {
	long savePost(PostDTO postDTO);
	void deletePost(long id);
	void updatePost(PostDTO postDTO);
	PostDTO getPost(long id);
}
