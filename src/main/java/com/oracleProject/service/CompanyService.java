package com.oracleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oracleproject.entity.Company;
import com.oracleproject.repository.CompanyRepository;
import java.util.*;
import  com.oracleproject.dto.CompanyDataDto;

@Service
public class CompanyService {

	@Autowired 
	CompanyRepository CompanyRepo;
	
	
	public List<CompanyDataDto> getMostCompany()
	{
        return CompanyRepo.findAllCompanys();
				
	}

	public List<CompanyDataDto> getCompany(String companyName,String start, String end)
	{
       System.out.println("StartYear"+start);	
       System.out.println("EndYear"+end);		
	   	
        return CompanyRepo.getCompanyByName(companyName,start,end);				
	}
}
