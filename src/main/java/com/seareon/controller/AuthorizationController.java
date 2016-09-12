package com.seareon.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seareon.dao.profile.ProfileDAO;
import com.seareon.dto.ProfileDTO;
import com.seareon.dto.UserDTO;
import com.seareon.model.User;
import com.seareon.service.profile.ProfileService;
import com.seareon.service.user.UserService;
import com.seareon.validators.UserDTOValidator;

@Controller
public class AuthorizationController {
	@Autowired
	UserService userService;
	@Autowired
	UserDTOValidator userDTOValidator;
	@Autowired
	ProfileService profileService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String createPageAuthorization(ModelMap model) {
		model.put("userDTO", new UserDTO());
		return "authorization";
	}
	
	@RequestMapping("/logIn")
	public String logIn(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result, HttpSession session,
			ModelMap model) {
		userDTOValidator.validate(userDTO, result);
		
		if(!result.hasErrors()) {
			User user = userService.getUser(userDTO);
			if(user != null) {
				model.put("profile", profileService.getProfileByUserId(user.getId()));		
				return "";		
			}
			model.addAttribute("errors", "A user with the same username does not exist!");
			return "authorization";
		}
		return "redirect:authorization";
	}
}
