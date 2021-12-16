package com.oracleproject.entity;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "AppUser")
public class AppUser {


	/** The user id. */
	
	@Id
	@Column(name = "user_id")
	private Long userId;

	/** The email. */
	
	private String email;

	/** The user name. */
	
	private String name;
	
	/** The user name. */
	
	private String surname;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/** The password. */
	private String password;

	private String address;
	
	private String gender;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String facebookId;
	
	private String graduationYear;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	private String month;
	
	private Integer day;
	
	private Integer year;
	
	private String expectedSalaryRange;
	
	
	private String url;
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	private String phone;
	
	private Boolean emailVerified;
	
	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getExpectedSalaryRange() {
		return expectedSalaryRange;
	}

	public void setExpectedSalaryRange(String expectedSalaryRange) {
		this.expectedSalaryRange = expectedSalaryRange;
	}



	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return name;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.name = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	/**
	 * Instantiates a new app user.
	 */
	public AppUser() {
		this.emailVerified = false;
	}

	/**
	 * Instantiates a new app user.
	 *
	 * @param userId the user id
	 * @param email the email
	 * @param userName the user name
	 * @param password the password
	 */
	
	public AppUser(Long userId, String email, String userName, String password) {
		this.userId = userId;
		this.email = email;
		this.name = userName;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "AppUser [userIdentity=" + userId + ", email=" + email + ", name=" + name + "]";
	}
	
}


