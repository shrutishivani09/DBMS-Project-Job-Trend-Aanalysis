package com.oracleproject.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracleproject.service.CompanyService;

import  com.oracleproject.dto.CompanyDataDto;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/Company")
public class CompanyController {
	
	@Autowired
	private  CompanyService companyService;
	
	@GetMapping
	public List<CompanyDataDto> getCompany()
	{
		return companyService.getMostCompany();
	}

	@GetMapping(path = "/{id}/{startDate}/{endDate}")
	public List<CompanyDataDto> getCompanyData(@PathVariable String id, @PathVariable String startDate, @PathVariable String endDate)
	{
		return companyService.getCompany(id,startDate,endDate);
	}
}
