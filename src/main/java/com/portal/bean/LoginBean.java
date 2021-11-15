package com.portal.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * 
 * @author Nitin
 * @created  11/12/2021
 * @modified
 * @version
 *
 */
public class LoginBean {
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	@NotBlank(message = "Enter Correct email id")
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 3, message = "vinaPassword At list 6 character")
	private String vinaPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getVinaPassword() {
		return vinaPassword;
	}

	public void setVinaPassword(String vinaPassword) {
		this.vinaPassword =vinaPassword;
	}
}
