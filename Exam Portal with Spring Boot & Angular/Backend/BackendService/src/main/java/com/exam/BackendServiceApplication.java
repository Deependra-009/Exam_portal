package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.modals.Role;
import com.exam.modals.User;
import com.exam.modals.UserRole;
import com.exam.services.UserService;

@SpringBootApplication
public class BackendServiceApplication {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendServiceApplication.class, args);
	}

}
