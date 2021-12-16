package com.oracleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oracleproject.entity.Company;
import com.oracleproject.repository.CityRepository;
import java.util.*;
import  com.oracleproject.dto.CompanyDataDto;
import net.minidev.json.*;


@Service
public class StateService {

	@Autowired 
	CityRepository cityRepo;
	
	
	public List<JSONObject> getData()
	{

        return cityRepo.getTopStateData();
				
	}

	public List<JSONObject> getStateData(String stateName,String start, String end)
	{
        String [] str = start.split(",");
        String [] str1 = end.split(",");

		int startSem = (str[0]=="Jan")?1:2;
        int endSem = (str1[0]=="Jan")?1:2;

		//int endDate = Integer.parseInt(end);
		//List<CompanyDataDto> CompanyList = CompanyRepo.getCompanyByName(companyName,startDate,endDate);
       // List<CompanyDataDto> CompanyTrend = new ArrayList<>();
       System.out.println("StartYear"+startSem);	
       System.out.println("EndYear"+endSem);		
	
        return cityRepo.getStateDataByName(stateName,startSem,Integer.parseInt(str[1]),endSem,Integer.parseInt(str1[1]));				
	}
}
