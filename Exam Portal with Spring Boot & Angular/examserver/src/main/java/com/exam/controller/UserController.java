package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import com.exam.helper.UserFoundException;
import com.exam.helper.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		user.setProfile("default.png");
		
		//password encoding with bcrypt password encoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(100L);
		role.setRoleName("Admin");
		UserRole ur=new UserRole();
		ur.setUser(user);
		ur.setRole(role);
		roles.add(ur);
		return this.userService.createUser(user, roles);
		
	}
	
	//get by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return this.userService.getUser(username);
	}
	
	//delete user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		
		this.userService.deleteUser(userId);
		
	}
	
	//update
	
	
//	@ExceptionHandler(UserFoundException.class)
//	public ResponseEntity<?> exceptionHandler(UserFoundException ex){
//		return ResponseEntity.;
//	}
//
}
