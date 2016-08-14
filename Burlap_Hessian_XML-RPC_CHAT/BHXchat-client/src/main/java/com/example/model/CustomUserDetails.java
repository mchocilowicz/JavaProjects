package com.example.model;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
	private Date loginDate;
	
	public CustomUserDetails(String username, Collection<GrantedAuthority> authorities) {
		super(username,"",authorities);
		this.loginDate = new Date();
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	
}
