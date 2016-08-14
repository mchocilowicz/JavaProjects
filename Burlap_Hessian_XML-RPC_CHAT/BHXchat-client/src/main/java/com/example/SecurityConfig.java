package com.example;

import java.net.MalformedURLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.caucho.hessian.client.HessianProxyFactory;
import com.example.service.HessianChat;

@Configuration
@EnableWebSecurity
@ComponentScan("com.example")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomAuthenticationProvider customProvider;

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() throws MalformedURLException {
		
		String url = "http://localhost:8080/HessianChat";
		HessianProxyFactory factory = new HessianProxyFactory();
		HessianChat basic = (HessianChat) factory.create(HessianChat.class, url);
		final Properties users = basic.getUsers();
		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**", "/login").permitAll()
				.antMatchers("/hessian", "/burlap", "xmlrpc","/hessian2", "/burlap2", "xmlrpc2", "/").authenticated().and().formLogin().loginPage("/login")
				.permitAll().and().logout().permitAll().and().csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inMemoryUserDetailsManager());
		auth.authenticationProvider(customProvider);
	}

}
