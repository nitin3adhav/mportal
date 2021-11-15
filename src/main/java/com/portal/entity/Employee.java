package com.portal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author Nitin
 * @created  11/12/2021
 * @modified
 * @version
 *
 */
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private Integer empID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "modified_Date")
	private Date modifiedDate;
	
	@Column(name = "vina_password")
	private String vinaPassword;
	
	@Column(name = "active")
	private Integer active;
	
	@Column(name = "enable")
	private Integer enable;

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getVinaPassword() {
		return vinaPassword;
	}

	public void setVinaPassword(String vinaPassword) {
		this.vinaPassword = vinaPassword;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}
}
