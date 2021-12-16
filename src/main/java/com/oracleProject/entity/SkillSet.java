package com.oracleproject.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "SkillSet")
public class SkillSet {
/** The user id. */
	
	@Id
	private Long skillId;
	
	private String skillName;
	
	private String skillLevel;
	
	private String skillDesc;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@ManyToMany(mappedBy = "skillSets")
	private Set<Employee> employees;
	
	@ManyToMany(mappedBy = "jobSkillSet")
	private Set<Job> jobs;
	
	public SkillSet(Long skillId, String skillName, String skillLevel, String skillDesc) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillLevel = skillLevel;
		this.skillDesc = skillDesc;
	}

	
	public SkillSet() {
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	@Override
	public String toString() {
		return "SkillSet [skillId=" + skillId + ", skillName=" + skillName + ", skillLevel=" + skillLevel
				+ ", skillDesc=" + skillDesc + "]";
	}
	
	
}