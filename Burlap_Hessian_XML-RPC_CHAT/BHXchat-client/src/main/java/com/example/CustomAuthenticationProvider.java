package com.example;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.model.CustomUserDetails;
import com.example.service.HessianChat;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	@Autowired
	private HessianChat hessianChat;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		if (inMemoryUserDetailsManager.userExists(username)) {
			throw new AccountStatusException("Dana nazwa użytkownika jest już zajęta.") {
			};
		}
		SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(userAuthority);
		UserDetails user = addUser(username, authorities);
		System.out.println(username + " został dodany..");
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	private CustomUserDetails addUser(String username, Collection<GrantedAuthority> authorities) {
		hessianChat.addUser(username);
		CustomUserDetails newUser = new CustomUserDetails(username, authorities);
		inMemoryUserDetailsManager.createUser(newUser);
		return newUser;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
