package com.oracleproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oracleproject.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
