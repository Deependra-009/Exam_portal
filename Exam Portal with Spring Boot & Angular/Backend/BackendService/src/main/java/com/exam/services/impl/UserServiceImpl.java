package com.exam.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.exam.modals.Role;
import com.exam.modals.User;
import com.exam.modals.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	// creating user
	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception  {
		// TODO Auto-generated method stub
		
		User local=null;
		
		try {
			local=this.userRepository.findByUsername(user.getUsername());
			
			if(local!=null) {
				throw new Exception("User Already Exception");
			}
			
			for(UserRole ur:userRole) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRole);
			local=this.userRepository.save(user);
				
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,"User Already Exists");
			
			
		}

		return local;
		
	}

	// get user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User user=null;
		
		try {
			user=this.userRepository.findByUsername(username);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not Found");
		}
		
		return user;
	}

}
