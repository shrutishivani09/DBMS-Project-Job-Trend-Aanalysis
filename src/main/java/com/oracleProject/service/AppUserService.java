package com.oracleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oracleproject.entity.AppUser;
import com.oracleproject.repository.AppUserRepository;
import java.util.*;

@Service
public class AppUserService {

	@Autowired 
	AppUserRepository userRepo;
	
	
	public List<AppUser> getStudents()
	{
		return userRepo.findAll();
				
	}
}
