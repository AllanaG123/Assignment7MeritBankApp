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
		.antMatchers("/AccountHolders/**").hasAuthority("admin")
		.antMatchers("Me/**").hasAuthority("accountholder")
		.antMatchers((HttpMethod.POST,"/CDOfferings").hasAuthority("admin")
				.antMatchers(HttpMethod.GET,"/CDOfferings").hasAnyAuthority("admin","accountholder")
				.antMatchers("/authenticate/createUser").hasAuthority("admin")
				.antMatchers("/authenticate").permitAll()
				.anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}		
	}	
