package com.seareon.service.user;

import com.seareon.dto.UserDTO;
import com.seareon.model.User;

public interface UserService {
	public long saveUser(UserDTO userDTO);
	public User getUser(UserDTO userDTO);
	public long saveUser(User user);
	public User getUser(User user);
	public void updateUser(User user);
}
