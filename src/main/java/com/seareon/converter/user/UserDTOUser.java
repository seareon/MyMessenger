package com.seareon.converter.user;

import com.seareon.dto.UserDTO;
import com.seareon.model.User;

public class UserDTOUser {
	public static User UserDTOToUserConvert(UserDTO userDTO) {
		User user = new User();
		user.setLogin(userDTO.getLogin());
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	public static UserDTO UserToUserDTOConvert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin(user.getLogin());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}
}
