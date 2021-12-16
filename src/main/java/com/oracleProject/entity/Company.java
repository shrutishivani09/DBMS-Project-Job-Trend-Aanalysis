package com.oracleproject.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	private Long companyId;
	
	/** The url. */
	
	private String url;


	/** The company name. */
	
	private String name;
	
	/** The Company ContactNo. */
	
	private String  contactNO;

	/** The type. */
	
	private String type;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Review> reviews;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companies")
    private List<Job> jobs;

	@ManyToMany
	@JoinTable(
	  name = "Company_Employee", 
	  joinColumns = @JoinColumn(name = "companyId"), 
	  inverseJoinColumns = @JoinColumn(name = "employeeId"))
	private List<Employee> employees;

		
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Company()
	{
		
	}
	
	public Company(Long companyId, String url, String name, String contactNO, String type) {
		super();
		this.companyId = companyId;
		this.url = url;
		this.name = name;
		this.contactNO = contactNO;
		this.type = type;
	}


	
	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactNO() {
		return contactNO;
	}


	public void setContactNO(String contactNO) {
		this.contactNO = contactNO;
	}
		
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", url=" + url + ", name=" + name + ", contactNO=" + contactNO
				+ ", type=" + type + "]";
	}

	
}
