package com.seareon.service.post.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seareon.converter.post.PostDTOPost;
import com.seareon.dao.post.PostDAO;
import com.seareon.dto.PostDTO;
import com.seareon.model.Post;
import com.seareon.service.post.PostService;

@Service("postService")
public class PostServiceImpl implements PostService {
	@Autowired
    private PostDAO postDAO;

	public long savePost(PostDTO postDTO) {
		// TODO Auto-generated method stub
		Post post = PostDTOPost.PostDTOToPostConvert(postDTO);
		return postDAO.savePost(post);
	}

	public void deletePost(long id) {
		// TODO Auto-generated method stub
		postDAO.deletePost(id);
	}

	public void updatePost(PostDTO postDTO) {
		// TODO Auto-generated method stub
		Post post = PostDTOPost.PostDTOToPostConvert(postDTO);
		postDAO.updatePost(post);
	}

	public PostDTO getPost(long id) {
		// TODO Auto-generated method stub
		return PostDTOPost.PostToPostDTOConvert(postDAO.getPost(id));
	}
	
}
