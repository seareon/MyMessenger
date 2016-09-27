package com.seareon.dto;

import java.util.Iterator;
import java.util.List;

import com.seareon.model.Post;

public class PostsJSON {
	private Post [] posts;

	public Post[] getPosts() {
		return posts;
	}
	
	public void setPosts(Post[] posts) {
		this.posts = posts;
	}

	public PostsJSON(List<Post> postsL) {
		posts = new Post[postsL.size()];
		Iterator<Post> it = postsL.iterator();
		for(int indexArr = 0; it.hasNext(); indexArr++) {
			posts[indexArr] = it.next();
		}
	}
}
