package com.exam.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.services.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String header = request.getHeader("Authorization");
		
		String username=null;
		String jwttoken=null;
		
		if(header!=null && header.startsWith("Bearer ")) {
			try {
				jwttoken=header.substring(7);
				username=this.jwtutil.getUsernameFromToken(jwttoken);
				
				
			}catch(ExpiredJwtException e) {
				System.out.println("jwt token has expired");
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}
		else {
			System.out.println("Invalid Token");
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails user = this.userDetailsServiceImpl.loadUserByUsername(username);
			if(this.jwtutil.validateToken(jwttoken, user)) {
				
				UsernamePasswordAuthenticationToken filter=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
				filter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)) ;
				SecurityContextHolder.getContext().setAuthentication(filter);
			}
			
			
		}else {
			System.out.println("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
		
	}

}
