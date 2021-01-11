package com.assignments.assignment7.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		
		//Set your configuration on the auth object
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("admin")
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
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		.antMatchers("/AccountHolders/**").hasRole("admin")
		.antMatchers("Me/**").hasRole("accountholder")
		.antMatchers((HttpMethod.POST,"/CDOfferings").hasRole("admin")
				.antMatchers(HttpMethod.GET,"/CDOfferings").hasAnyRole("admin","accountholder")
				.antMatchers("/authenticate/createUser").hasRole("admin")
				.antMatchers("/authenticate").permitAll()
				.anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}		
	}	
