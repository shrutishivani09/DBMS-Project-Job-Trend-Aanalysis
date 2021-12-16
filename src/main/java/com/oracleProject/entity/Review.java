package com.oracleproject.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Review")
public class Review {

	@Id
	@Column(name = "review_id")
	private Long reviewId;
	
	
	/** The title. */
	
	private String title;

	/** The review rating. */
	
	private int rating;
	
	/** The review score. */
	
	private double  score;

	private Date postDate;

	public Date getDate() {
		return postDate;
	}

	public void setDate(Date dt) {
		this.postDate = dt;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	private String reviewDetails;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Review()
	{
		
	}
	
	public Review(Long reviewId, String title, int rating, int score, String reviewDetails) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.rating = rating;
		this.score = score;
		this.reviewDetails = reviewDetails;
	}
	
	
	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getReviewDetails() {
		return reviewDetails;
	}

	public void setReviewDetails(String reviewDetails) {
		this.reviewDetails = reviewDetails;
	}

	
	
	
	
	
	
	
	
	
	
	
}
