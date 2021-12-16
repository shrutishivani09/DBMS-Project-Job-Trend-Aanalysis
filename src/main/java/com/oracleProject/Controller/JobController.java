package com.oracleproject.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracleproject.service.JobSectorService;

import net.minidev.json.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/Job")
public class JobController {
	
	@Autowired
	private  JobSectorService jobSectorService;
	
	@GetMapping
	public List<JSONObject> getJobSectorGrowth()
	{
		return jobSectorService.getSector();
	}

	@GetMapping(path = "/{id}/{startDate}/{endDate}")
 	public List<JSONObject> getStateGrowthData(@PathVariable String id, @PathVariable String startDate, @PathVariable String endDate)
	{
		return jobSectorService.getSectorData(id,startDate,endDate);
	}
}
