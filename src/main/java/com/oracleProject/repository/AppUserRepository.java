package com.oracleproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oracleproject.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	
}

