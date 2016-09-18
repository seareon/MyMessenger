package com.seareon.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seareon.converter.profile.ProfileDTOProfile;
import com.seareon.model.Profile;
import com.seareon.service.profile.ProfileService;
import com.seareon.service.user.UserService;

@Controller
public class ProfileController {
	@Autowired
	ProfileService profileService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "**/profileInfo", method = RequestMethod.GET)
	public String goToProfilePage(ModelMap model, HttpSession session) {
		model.put("profileDTO", profileService.getProfileDTOById((Long) session.getAttribute("profileId")));
		return "profilePage";
	}
	
	@RequestMapping("/edit")
	public String editProfile(ModelMap model, HttpSession session) {
		Profile profile = profileService.getProfileById((Long) session.getAttribute("profileId"));
		model.put("profile", profile);
		return "editProfile";
	}
	
	@RequestMapping("/updateProfile")
	public String updateProfile(@ModelAttribute("profile") Profile profile, ModelMap model, HttpSession session) {
		userService.updateUser(profile.getUser());
		profileService.updateProfile(profile);
		model.put("profileDTO", ProfileDTOProfile.ProfileToProfileDTOConvert(profile));
		return "profilePage";
	}
}
