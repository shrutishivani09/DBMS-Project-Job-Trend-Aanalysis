package com.oracleproject.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracleproject.service.StateService;

import  com.oracleproject.dto.CompanyDataDto;
import net.minidev.json.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/state")
public class StateController {
	
	@Autowired
	private  StateService stateService;
	
	@GetMapping
	public List<JSONObject> getGrowthRate()
	{
		return stateService.getData();
	}

	@GetMapping(path = "/{id}/{startDate}/{endDate}")
	public List<JSONObject> getStateGrowthData(@PathVariable String id, @PathVariable String startDate, @PathVariable String endDate)
	{
		return stateService.getStateData(id,startDate,endDate);
	}
}
