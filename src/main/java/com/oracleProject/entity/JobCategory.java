package com.oracleproject.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "JobCategory")
public class JobCategory {
/** The user id. */
	
	@Id
	private Long categoryId;
	
	/** The category Name. */	
	private String categoryName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobCategory")
    private List<Job> jobs;
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public JobCategory(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public JobCategory() {
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

	@Override
	public String toString() {
		return "JobCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
}