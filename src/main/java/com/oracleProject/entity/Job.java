package com.oracleproject.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Job")
public class Job {
/** The user id. */
	
	@Id
	private String jobId;
	
	/** The JOb title. */	
	private String title;
	
	/** The Job salaryStart. */
	private Long salaryStart;
	
	
	
	/** The JOb Description. */	
	private String Description;
	
	private String url;
    public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Set<SkillSet> getJobSkillSet() {
		return jobSkillSet;
	}
	public void setJobSkillSet(Set<SkillSet> jobSkillSet) {
		this.jobSkillSet = jobSkillSet;
	}

	private String city;	
	private Long day;
	private Long month;
	private Long year;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company companies;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private JobCategory jobCategory;
	
	@ManyToMany
	@JoinTable(
	  name = "Job_SkillSet", 
	  joinColumns = @JoinColumn(name = "jobId"), 
	  inverseJoinColumns = @JoinColumn(name = "skillId"))
	private Set<SkillSet> jobSkillSet;
	
	public String getJobId() {
		return jobId;
	}
	public Company getCompanies() {
		return companies;
	}
	public void setCompanies(Company companies) {
		this.companies = companies;
	}
	public JobCategory getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getSalaryStart() {
		return salaryStart;
	}
	public void setSalaryStart(Long salaryStart) {
		this.salaryStart = salaryStart;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getDay() {
		return day;
	}
	public void setDay(Long day) {
		this.day = day;
	}
	public Long getMonth() {
		return month;
	}
	public void setMonth(Long month) {
		this.month = month;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public Job(String jobId, String title, Long salaryStart, long maxSalary, String description, String url, Long day,
			Long month, Long year) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.salaryStart = salaryStart;
		this.Description = description;
		this.url = url;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Job() {
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", title=" + title + ", salaryStart=" + salaryStart + ", maxSalary="
				+ ", Description=" + Description + ", url=" + url + ", day=" + day + ", month=" + month + ", year="
				+ year + "]";
	}
	
	
	
}
