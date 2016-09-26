package com.seareon.dao.user;

import com.seareon.model.User;

public interface UserDAO {
	long saveUser(User user);
    void updateUser(User user);
    User getUser(long id);
    User getUserByName(String login);
//    void deleteUserById(long id);
}
