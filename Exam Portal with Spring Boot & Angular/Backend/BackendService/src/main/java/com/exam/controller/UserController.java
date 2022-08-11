package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/test")
	public String test() {
		return "Application test successfully";
	}
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@RequestBody User User) throws Exception {
		
		// BCyptPasword
		System.out.println("-----------");
		
		User.setPassword(this.passwordEncoder.encode(User.getPassword()));
		
		Role role=new Role();
		role.setRoleId(1L);
		role.setRoleName("ADMIN");
		
		UserRole userRole=new UserRole();
		userRole.setUser(User);
		userRole.setRole(role);
		
		Set<UserRole> roles= new HashSet<>();
		roles.add(userRole);
		
		User local=this.userService.createUser(User, roles);
		
		System.out.println(local.toString());
		return new ResponseEntity<User>(local,HttpStatus.OK);
	}
	
	@GetMapping("/getuser/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username){
		
		User user=this.userService.getUser(username);
		if(user==null) {
			return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
