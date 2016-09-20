package com.seareon.controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seareon.converter.post.PostDTOPost;
import com.seareon.converter.profile.ProfileDTOProfile;
import com.seareon.dto.PostDTO;
import com.seareon.model.Post;
import com.seareon.model.Profile;
import com.seareon.service.post.PostService;
import com.seareon.service.profile.ProfileService;

@Controller
public class PostController {
	@Autowired
	ProfileService profileService;
	@Autowired
	PostService postService;
	
	@RequestMapping("**/postSave")
	public String savePost(@ModelAttribute("postDTO") PostDTO postDTO, HttpSession session, ModelMap model) {
		Profile profile = null;
		try {
			long id = (Long) session.getAttribute("profileId");
			profile = profileService.getProfileById(id);
			postDTO.setProfile(profile);
			postDTO.setDate(new Date());
			Set<Post> list = profile.getPosts();
			list.add(PostDTOPost.PostDTOToPostConvert(postDTO));
			postService.savePost(postDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("profileDTO",ProfileDTOProfile.ProfileToProfileDTOConvert(profile));
		model.put("postDTO", new PostDTO());
		return "pageOfPosts";
	}
	
	@RequestMapping("/postPage")
	public String createPage(HttpSession session, ModelMap model) {
		model.put("profileDTO", profileService.getProfileDTOById((Long) session.getAttribute("profileId"))); 	
		model.put("postDTO", new PostDTO());
		return "pageOfPosts";
	}
	
	@RequestMapping(value = "**/postUpdate/{num}", method = RequestMethod.POST)
	public String updatePost(@PathVariable(value = "num") int num, HttpSession session, HttpServletRequest req, 
			ModelMap model) {
		String str = req.getParameter("message");
		try {
			Post post = postService.getPost(num);
			post.setMessage(str);
			post.setDate(new Date());
			postService.updatePost(post);
			model.put("profileDTO", profileService.getProfileDTOById((Long) session.getAttribute("profileId")));
			model.put("postDTO", new PostDTO());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pageOfPosts";
	}
}
