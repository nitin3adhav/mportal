package com.portal.bean;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author Nitin
 * @created 11/12/2021
 * @modified
 * @version
 *
 */
public class SignupBean {
	
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	@NotNull
	@Size(min = 3, message = "firstName At least 3 character")
	private String firstName;

	@NotNull
	@Size(min = 3, message = "lastName At least 3 character")
	private String lastName;

	@NotNull
	@Size(min = 10, max = 10, message = "Mobile Number Should Be 10 Digit")
	private String mobileNumber;

	@NotBlank(message = "Enter Correct email id")
	@Email
	private String email;

	@NotNull(message = "designation At list 4 character")
	@Size(min = 4, message = "designation At list 4 character")
	private String designation;

	@NotNull(message = "city At list 3 character")
	@Size(min = 3, message = "city At list 3 character")
	private String city;

	private Date dob;

	@NotBlank
	@Size(min = 3, message = "vinaPassword At list 6 character")
	private String vinaPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getVinaPassword() {
		return vinaPassword;
	}

	public void setVinaPassword(String vinaPassword) {
		this.vinaPassword =encoder.encode(vinaPassword);
	}
}
