package com.seareon.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.seareon.converter.user.UserDTOUser;
import com.seareon.dao.user.UserDAO;
import com.seareon.dto.UserDTO;
import com.seareon.model.User;
import com.seareon.service.user.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;	
	
	public long saveUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = UserDTOUser.UserDTOToUserConvert(userDTO);
		return userDAO.saveUser(user);
	}

	public User getUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = UserDTOUser.UserDTOToUserConvert(userDTO);
		return userDAO.getUserByName(user.getLogin());
	}

	public long saveUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.saveUser(user);
	}

	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.getUserByName(user.getLogin());
	}
	
	
}
