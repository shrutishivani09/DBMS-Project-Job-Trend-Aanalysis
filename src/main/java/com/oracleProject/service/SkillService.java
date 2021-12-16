package com.oracleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oracleproject.entity.Company;
import com.oracleproject.repository.SkillSetRepository;
import java.util.*;
import  com.oracleproject.dto.CompanyDataDto;
import net.minidev.json.*;

@Service
public class SkillService {

	@Autowired 
	SkillSetRepository SkillRepo;
	
	
	public List<JSONObject> getSkill()
	{
        return SkillRepo.getAllSkill();
				
	}

	public List<JSONObject> getSkillName(String skillName,String skillName2,String start, String end)
	{
       System.out.println("StartYear"+start);	
       System.out.println("EndYear"+end);		
	   	
        return SkillRepo.getSkillByName(skillName,skillName2,start,end);				
	}
}
