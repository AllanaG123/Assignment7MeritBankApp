package com.assignments.assignment7.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//Set your configuration on the auth object
		
		auth.inMemoryAuthentication()
		.withUser("Admin")
		.password("Admin")
		.roles("USER");
		.and()
		.withUser("foo")
		.password("foo")
		.password("foo")
		.roles("Admin");	
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	 return NoOpPasswordEncoder.getInstance();
	
}
}
