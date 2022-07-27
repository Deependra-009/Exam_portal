package com.exam.modals;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {
	
	@Id
	private Long roleId;
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "role")
	private Set<UserRole> userRoles=new HashSet<>();
	

}
