package com.fbo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService customuserService;

	/**
	 * Forcing to change the default
	 * 
	 * @param auth
	 * @throws Exception
	 */
	// @formatter:off
	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth, final UserDetailsService userDetailsService)
			throws Exception {
		// auth.inMemoryAuthentication()
		// .withUser("admin")
		// .password("admin")
		// .roles("ADMIN","USER")
		// .and()
		// .withUser("user")
		// .password("")
		// .roles("USER");

		auth.userDetailsService(customuserService).passwordEncoder(new BCryptPasswordEncoder());
	}
	// @formatter:on

	/**
	 * Override this method to configure the {@link HttpSecurity}. Typically
	 * subclasses should not invoke this method by calling super as it may
	 * override their configuration. The default configuration is:
	 *
	 * <pre>
	 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	 * </pre>
	 *
	 * @param http
	 *            the {@link HttpSecurity} to modify
	 * @throws Exception
	 *             if an error occurs
	 */
	// @formatter:off
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/signup").permitAll()
			.anyRequest().authenticated()
				.and().formLogin()
			.loginPage("/login").permitAll().and().logout().permitAll();
	}
	// @formatter:on

}
