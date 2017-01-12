package com.fbo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	/**
	 * Forcing to change the default 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception 	{
		auth.inMemoryAuthentication()
			.withUser("admin")
				.password("admin")
				.roles("ADMIN","USER")
			.and()
			.withUser("user")
				.password("")
				.roles("USER");
		
	}
	
	
}
