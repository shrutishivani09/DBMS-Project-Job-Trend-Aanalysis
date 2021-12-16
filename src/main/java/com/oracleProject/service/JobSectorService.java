package com.oracleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oracleproject.entity.Company;
import com.oracleproject.repository.JobSectorRepository;
import java.util.*;
import net.minidev.json.*;

@Service
public class JobSectorService {

	@Autowired 
	JobSectorRepository sectorRepo;
	
	
	public List<JSONObject> getSector()
	{
        return sectorRepo.getDataHighestSector();
				
	}

	public List<JSONObject> getSectorData(String companyName,String start, String end)
	{
       System.out.println("StartYear"+start);	
       System.out.println("EndYear"+end);		
	
        return sectorRepo.getDataBySector(companyName,start,end);				
	}
}
