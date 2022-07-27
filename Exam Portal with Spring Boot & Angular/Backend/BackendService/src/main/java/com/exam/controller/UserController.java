package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.modals.Role;
import com.exam.modals.User;
import com.exam.modals.UserRole;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	public String test() {
		return "Application test successfully";
	}
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@RequestBody User User) throws Exception {
		
		Role role=new Role();
		role.setRoleId(1L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setUser(User);
		userRole.setRole(role);
		
		Set<UserRole> roles= new HashSet<>();
		roles.add(userRole);
		
		User local=this.userService.createUser(User, roles);
		
		System.out.println(local.toString());
		return new ResponseEntity<User>(local,HttpStatus.OK);
	}

}
