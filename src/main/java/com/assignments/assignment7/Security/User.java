package com.assignments.assignment7.Security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import com.assignments.assignment7.models.AccountHolder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class User {
	
	private int id;
	private String userName;
	private String password;
	private boolean active;
	private String roles;
	
	public User () {
		userName = "";
		password = "";
		active  = true;
		roles = "";
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	public AccountHolder getAccountHolder() {
			return accountHolder;
			
	}
	
	public void setAccountHolder(AccountHolder accountHolder) {
		this.userName =userName;
		
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isActive() {
		return active;
		
		
	}
	public void setActive(boolean active) {
		this.active = active;
		
		
	}
	public String getRoles() {
		return roles;
		
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	

}
