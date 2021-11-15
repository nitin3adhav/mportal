package com.portal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 * @author Nitin
 * @created 11/12/2021
 * @modified
 * @version
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/login", "/signup", "/get-all-employee")
				.permitAll().anyRequest().authenticated();

		/*
		 * http.authorizeRequests().antMatchers("/signup").permitAll().antMatchers(
		 * "/login").permitAll()
		 * .antMatchers("/get-all-employee").permitAll().antMatchers("delete-employee").
		 * hasAuthority("manager") .anyRequest().authenticated();
		 */

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email,vina_password from employee where email=?")
				.authoritiesByUsernameQuery("select email,designation from employee where email=?").passwordEncoder(encoder);
	}
}
