package com.oracleproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oracleproject.entity.JobCategory;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, Long>{

}
