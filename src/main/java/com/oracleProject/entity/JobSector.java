package com.oracleproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "JobSector")
public class JobSector {
/** The user id. */
	
	private String name;

	@Id
	private String jobTitle;
	
	public JobSector(String name, String jobTitle) {
	this.name = name;
	this.jobTitle = jobTitle;
}

	

	public JobSector() {
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "JobSector [jobTitle=" + jobTitle + ", name=" + name + "]";
	}



	
}