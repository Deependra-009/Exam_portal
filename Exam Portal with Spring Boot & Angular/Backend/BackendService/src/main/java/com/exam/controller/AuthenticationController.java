package com.exam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtil;
import com.exam.modals.JwtRequest;
import com.exam.modals.JwtResponse;
import com.exam.modals.User;
import com.exam.services.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/generate-token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest  ) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}catch(UsernameNotFoundException e) {
			throw new Exception("User Not Found");
		}
		UserDetails user = userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(user);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	
	private void authenticate(String username,String password) throws Exception {
		
		try {
			
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch(DisabledException e) {
			throw new Exception("USER DISABLED");
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials");
		}
	}
	
	// ------------------------- current user ----------------------------
	
	@GetMapping("/currentuser")
	public User currentUser(Principal principal) {
		
		User user =(User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
		return user;
	}

}