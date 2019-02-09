package com.customer.customer_demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/view/admin/*").hasRole("ADMIN")
			.antMatchers("/view/user/*").hasRole("USER")
			.antMatchers("/api/**").hasRole("ADMIN")
			.and()
			.formLogin();
			
}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("test").password("{noop}test").roles("USER", "ADMIN");
			auth.inMemoryAuthentication().withUser("low").password("{noop}low").roles("USER");
		
		
	}
}
