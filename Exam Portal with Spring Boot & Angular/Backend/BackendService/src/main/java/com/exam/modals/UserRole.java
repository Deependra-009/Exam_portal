package com.exam.modals;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="UserRole")
@Getter
@Setter
@NoArgsConstructor
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;
	
	// user
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	// Role
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Role role;
//
//	public long getUserRoleId() {
//		return userRoleId;
//	}
//
//	public void setUserRoleId(long userRoleId) {
//		this.userRoleId = userRoleId;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public UserRole(long userRoleId, User user, Role role) {
//		super();
//		this.userRoleId = userRoleId;
//		this.user = user;
//		this.role = role;
//	}
//
//	public UserRole() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	

}
