package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import com.example.service.BurlapChat;
import com.example.service.HessianChat;
import com.example.service.RpcChat;

@Component
public class LogoutListener implements ApplicationListener<SessionDestroyedEvent> {
	@Autowired
	HessianChat hessianChat;
	@Autowired
	BurlapChat burlapChat;
	@Autowired
	RpcChat rpcChat;
	@Autowired
	InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		List<SecurityContext> lstSecurityContext = event.getSecurityContexts();
		UserDetails ud;
		for (SecurityContext securityContext : lstSecurityContext) {
			ud = (UserDetails) securityContext.getAuthentication().getPrincipal();
			System.out.println(ud.getUsername() + " opuścił czat..");
			hessianChat.terminateUser(ud.getUsername());
			inMemoryUserDetailsManager.deleteUser(ud.getUsername());
			System.out.println("Zalogowani użytkownicy[" + (hessianChat.getUsers().size()) + "]:");
			hessianChat.getUsers().entrySet().forEach(user -> {
				System.out.println(user.getKey());
			});
		}
		if (hessianChat.getUsers().size() < 1) {
			System.out.println("Wiadomosci zostaly usuniete..");
			hessianChat.clearMessages();
			burlapChat.clearMessages();
			rpcChat.clearMessages();
		}
	}

}
