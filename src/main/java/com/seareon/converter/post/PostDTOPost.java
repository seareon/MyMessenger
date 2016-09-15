package com.seareon.converter.post;

import com.seareon.dto.PostDTO;
import com.seareon.model.Post;

public class PostDTOPost {
	public static Post PostDTOToPostConvert(PostDTO postDTO) {
		Post post = new Post();
		post.setDate(postDTO.getDate());
		post.setMessage(postDTO.getMessage());
		post.setProfile(postDTO.getProfile());
		return post;
	}
	
	public static PostDTO PostToPostDTOConvert(Post post) {
		PostDTO postDTO = new PostDTO();
		postDTO.setDate(post.getDate());
		postDTO.setMessage(post.getMessage());
		postDTO.setProfile(post.getProfile());
		return postDTO;
	}
}
