package com.oracleproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oracleproject.entity.JobSector;
import net.minidev.json.*;
import java.util.*;

@Repository
public interface JobSectorRepository extends JpaRepository<JobSector, String>{


    @Query(
        value = "SELECT "+
        "AVG(SALARY_START) as avg_Salary, POSTED_YEAR, QUARTER "+
        "FROM "+
        "(SELECT "+
        "JOB_ID, SALARY_START, to_char(POSTED_ON, 'YYYY') AS POSTED_YEAR, TO_CHAR(POSTED_ON, 'Q') as Quarter "+
        "FROM "+              
        "(SELECT "+
        "JOB_ID, SALARY_START, TO_DATE(POSTED_ON, 'YYYYMMDD') AS POSTED_ON "+
        "FROM "+ 
        "(SELECT "+
        "JOB_ID, SALARY_START, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
        "FROM "+
        "JOB WHERE TITLE IN (SELECT JOB_TITLE FROM JOB_SECTOR WHERE NAME = 'Data Science'))) "+
        " WHERE POSTED_ON >= to_date('2018-01-01', 'YYYY-MM-DD') AND "+
        "POSTED_ON <= to_date('2021-06-30', 'YYYY-MM-DD') "+
        "AND SALARY_START > (SELECT AVG(SALARY_START) - STDDEV(SALARY_START )"+
        "FROM "+              
        "(SELECT JOB_ID, SALARY_START, TO_DATE(POSTED_ON, 'YYYYMMDD') AS POSTED_ON "+
        "FROM "+
        "(SELECT "+
        "JOB_ID, SALARY_START, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
        "FROM "+
        "JOB WHERE TITLE IN (SELECT JOB_TITLE FROM JOB_SECTOR WHERE NAME = 'Data Science'))) "+
        " WHERE POSTED_ON >= to_date('2018-01-01', 'YYYY-MM-DD') AND "+
        "POSTED_ON <= to_date('2021-06-30', 'YYYY-MM-DD') "+
        " )"+
        "AND SALARY_START < (SELECT AVG(SALARY_START) + STDDEV(SALARY_START )"+
        "FROM "+
        "(SELECT JOB_ID, SALARY_START, TO_DATE(POSTED_ON, 'YYYYMMDD') AS POSTED_ON "+
        "FROM "+
        "(SELECT JOB_ID, SALARY_START, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
        "FROM "+
        "JOB WHERE TITLE IN (SELECT JOB_TITLE FROM JOB_SECTOR WHERE NAME = 'Data Science'))) "+
        " WHERE POSTED_ON >= to_date('2018-01-01', 'YYYY-MM-DD') AND "+
        "POSTED_ON <= to_date('2021-06-30', 'YYYY-MM-DD') "+ " ))"+
        "GROUP BY (POSTED_YEAR, QUARTER)"+
        " ORDER BY POSTED_YEAR,QUARTER",
        nativeQuery = true)
      List<JSONObject  > getDataHighestSector();
    
      @Query(
        value = "SELECT "+
        "AVG(SALARY_START) as avg_Salary, POSTED_YEAR, QUARTER "+
        "FROM "+
        "(SELECT "+
        "JOB_ID, SALARY_START, to_char(POSTED_ON, 'YYYY') AS POSTED_YEAR, TO_CHAR(POSTED_ON, 'Q') as Quarter "+
        "FROM "+              
        "(SELECT "+
        "JOB_ID, SALARY_START, TO_DATE(POSTED_ON, 'YYYYMMDD') AS POSTED_ON "+
        "FROM "+ 
        "(SELECT "+
        "JOB_ID, SALARY_START, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
        "FROM "+
        "JOB WHERE TITLE IN (SELECT JOB_TITLE FROM JOB_SECTOR WHERE NAME = ?1)))"+
        " WHERE POSTED_ON >= to_date(?2, 'YYYY-MM-DD') AND "+
        "POSTED_ON <= to_date(?3, 'YYYY-MM-DD') "+
        "AND SALARY_START > (SELECT AVG(SALARY_START) - STDDEV(SALARY_START )"+
        "FROM "+              
        "(SELECT JOB_ID, SALARY_START, TO_DATE(POSTED_ON, 'YYYYMMDD') AS POSTED_ON "+
        "FROM "+
        "(SELECT "+
        "JOB_ID, SALARY_START, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
        "FROM "+
        "JOB WHERE TITLE IN (SELECT JOB_TITLE FROM JOB_SECTOR WHERE NAME = ?1))) " +
        " WHERE POSTED_ON >= to_date(?2, 'YYYY-MM-DD') AND "+
        "POSTED_ON <= to_date(?3, 'YYYY-MM-DD') "+
        " ) "+
        "AND SALARY_START < (SELECT AVG(SALARY_START) + STDDEV(SALARY_START ) "+
        "FROM "+              
        "(SELECT JOB_ID, SALARY_START, TO_DATE(POSTED_ON, 'YYYYMMDD') AS POSTED_ON "+
        "FROM "+ 
        "(SELECT JOB_ID, SALARY_START, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
        "FROM "+
        "JOB WHERE TITLE IN (SELECT JOB_TITLE FROM JOB_SECTOR WHERE NAME = ?1))) " +
        " WHERE POSTED_ON >= to_date(?2, 'YYYY-MM-DD') AND "+
        "POSTED_ON <= to_date(?3, 'YYYY-MM-DD') "+
        " )) "+
        "GROUP BY (POSTED_YEAR, QUARTER ) "+
        " ORDER BY POSTED_YEAR,QUARTER",
        nativeQuery = true)
      List<JSONObject  > getDataBySector(String companyId,String startYear,String endYear);
    
}
