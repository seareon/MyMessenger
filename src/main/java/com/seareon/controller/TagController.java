package com.seareon.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.seareon.dto.UserDTO;

@Controller
public class TagController {
	@RequestMapping("/tagExit")
	public String exit(HttpSession session, ModelMap model) {
		session.invalidate();
		model.put("userDTO", new UserDTO());
		return "authorization";
	}
}
