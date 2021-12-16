package com.oracleproject.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.*;

import com.oracleproject.entity.Review;
import com.oracleproject.service.ReviewService;

import  com.oracleproject.dto.ReviewDataDto;


@RestController
public class ReviewController {

	@Autowired
	private  ReviewService reviewService;

	
	@RequestMapping(path = "/api/review")
	@CrossOrigin
	public List<JSONObject> getReview()
	{
		return reviewService.getMostReviewCompany();
	}

	@RequestMapping(path = "/api/review/{id}/{yearRange}")
	@CrossOrigin
	public List<JSONObject> getData(@PathVariable String id, @PathVariable String yearRange)
	{
		return reviewService.getCompanyReview(id,yearRange);
	}

	@RequestMapping(path = "/api/total")
	@CrossOrigin
	public List<JSONObject> getTotal()
	{
		return reviewService.getTotal();
	}
}
