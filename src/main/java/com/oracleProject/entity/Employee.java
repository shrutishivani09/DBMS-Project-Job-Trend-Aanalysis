package com.oracleproject.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {


	/** The user id. */
	
	@Id
	@Column(name = "employeeId")
	private Long employeeId;
	
	public Employee() {
	}

	public Employee(Long employeeId, String firstName, String lastName, Long age, String empType, String status,
			Set<SkillSet> skillSets, Set<Company> companies, String email) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.empType = empType;
		this.status = status;
		this.skillSets = skillSets;
		this.companies = companies;
		this.email = email;
	}

	/** The Employee FirstName. */	
	private String firstName;

	/** The employee lastName. */
	private String lastName;
	
	
	/** The employee age. */
	private Long age;
	
	/** The employee type. */
	private String empType;
	
	/** The employee status. */
	
	private String status;
	
	@ManyToMany
	@JoinTable(
	  name = "Employee_SkillSet", 
	  joinColumns = @JoinColumn(name = "employeeId"), 
	  inverseJoinColumns = @JoinColumn(name = "skillId"))
	private Set<SkillSet> skillSets;
 

	@ManyToMany(mappedBy = "employees")
	private Set<Company> companies;
	
	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public Set<SkillSet> getSkillSets() {
		return skillSets;
	}

	public void setSkillSets(Set<SkillSet> skillSets) {
		this.skillSets = skillSets;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/** The email. */
	
	private String email;

	public Employee(Long employeeId, String email, String status, String firstName, String lastName, Long age,
			String empType) {
		super();
		this.employeeId = employeeId;
		this.email = email;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.empType = empType;
	}

	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", email=" + email + ", status=" + status + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age + ", empType=" + empType + "]";
	}


}


