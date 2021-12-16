package com.oracleproject.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracleproject.service.SkillService;

import  com.oracleproject.dto.CompanyDataDto;
import net.minidev.json.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/skill")
public class SkillController {
	
	@Autowired
	private  SkillService skillService;
	
	@GetMapping
	public List<JSONObject> getSkill()
	{
		return skillService.getSkill();
	}

	@GetMapping(path = "/{id}/{id1}/{startDate}/{endDate}")
	public List<JSONObject> getSkillData(@PathVariable String id,@PathVariable String id1, @PathVariable String startDate, @PathVariable String endDate)
	{
		return skillService.getSkillName(id,id1,startDate,endDate);
	}
}
