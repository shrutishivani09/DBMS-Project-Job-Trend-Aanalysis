package com.oracleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oracleproject.entity.Review;
import com.oracleproject.repository.ReviewRepository;
import java.util.*;
import  com.oracleproject.dto.ReviewDataDto;
import net.minidev.json.*;

@Service
public class ReviewService {

	@Autowired 
	ReviewRepository reviewRepo;
	
	
	public List<JSONObject> getMostReviewCompany()
	{
		List<JSONObject> reviewList = reviewRepo.findAllReviews();
        List<JSONObject> reviewTrend = new ArrayList<>();

        return reviewRepo.findAllReviews();
				
	}

	public List<JSONObject> getCompanyReview(String companyName,String yearRange)
	{
		String [] str = yearRange.split(",");
		String startDate = str[0];
		String endDate = str[1];

        return reviewRepo.getReviewByName(companyName,startDate,endDate);				
	}
	public List<JSONObject> getTotal()
	{
		

        return reviewRepo.getTotal();				
	}
}
