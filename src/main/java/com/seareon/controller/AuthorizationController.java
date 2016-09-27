package com.seareon.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.seareon.converter.profile.ProfileDTOProfile;
import com.seareon.dto.PostDTO;
import com.seareon.dto.ProfileDTO;
import com.seareon.dto.UserDTO;
import com.seareon.model.Post;
import com.seareon.model.Profile;
import com.seareon.model.User;
import com.seareon.service.profile.ProfileService;
import com.seareon.service.user.UserService;
import com.seareon.validators.ProfileDTOValidator;
import com.seareon.validators.UserDTOValidator;

@Controller
public class AuthorizationController {
	@Autowired
	UserService userService;
	@Autowired
	UserDTOValidator userDTOValidator;
	@Autowired
	ProfileDTOValidator profileDTOValidator;
	@Autowired
	ProfileService profileService;
	
	@RequestMapping(value = "**/", method = RequestMethod.GET)
	public String createPageAuthorization(ModelMap model, HttpSession session) {
		model.put("userDTO", new UserDTO());
		return "authorization";
	}
	
	@RequestMapping("/signUp")
	public String singUp(ModelMap model) {
		model.put("profileDTO", new ProfileDTO());
		return "registration";
	}
	
	@RequestMapping("/reg")		// вынести в отдельный контроллер??? 
	public String registration(@ModelAttribute("profileDTO") ProfileDTO profileDTO, BindingResult result, 
			HttpSession session, ModelMap model) {
		profileDTOValidator.validate(profileDTO, result);
		
		if(!result.hasErrors()) {
			ProfileDTO profileDto = profileService.getProfileDTOByUserLogin(profileDTO.getUser().getLogin());
			if(profileDto == null) {
				Profile profile = ProfileDTOProfile.ProfileDTOToProfileConvert(profileDTO);
				long userId = userService.saveUser(profile.getUser());
				long profileId = profileService.saveProfile(profile);
				session.setAttribute("profileID", profileId);
				session.setAttribute("userId", userId);
				model.put("profileDTO", ProfileDTOProfile.ProfileToProfileDTOConvert(profile));
				model.put("postDTO", new PostDTO());
				return "pageOfPosts";		
			}
			model.addAttribute("errors", "A user with the same username exists!");
			return "registration";
		}
		
		return "registration";
	}
	
	@RequestMapping("/logIn")
	public String logIn(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, HttpSession session,
			ModelMap model) {
		userDTOValidator.validate(userDTO, result);
		
		if(!result.hasErrors()) {
			User user = userService.getUser(userDTO);
			if(user != null) {
//				model.put("profileDTO", ProfileDTOProfile.ProfileToProfileDTOConvert(user.getProfile())); 	
				List<Post> postsList = new ArrayList<Post>( user.getProfile().getPosts());
				for(Profile profile : user.getProfile().getSubscribers()) {
					postsList.addAll(profile.getPosts());
				}
				Collections.sort(postsList);
				model.put("posts", postsList);
				model.put("postDTO", new PostDTO());
				session.setAttribute("userName", user.getLogin());
				session.setAttribute("profileId", user.getProfile().getId());		
				session.setAttribute("userId", user.getId());
				return "pageOfPosts";		
			}
			model.addAttribute("errors", "A user with the same username does not exist!");
			return "authorization";
		}
		return "authorization";
	}
}
