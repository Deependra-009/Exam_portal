package com.exam.services;

import java.util.Set;

import com.exam.modals.User;
import com.exam.modals.UserRole;

public interface UserService {
	
	// creating user
	
	public User createUser(User user,Set<UserRole> userRole) throws Exception;
	
	// get user by username
	
	public User getUser(String username);

}
