package com.oracleproject.repository;

import  com.oracleproject.dto.CompanyDataDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

import com.oracleproject.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

    @Query(
        value = "select (numCategories * 10 + JobCount + cityCount * 5 + (empCount/100)) as growthScore, YearN, QuarterN "+
        "from ( select to_char(reqDate, 'YYYY') as YearN, to_char(reqDate, 'Q') as QuarterN, "+
        "count(distinct category_id) as numCategories, count(job_id) as JobCount, count(distinct city) as cityCount, name "+
       "from ( select to_date(dateR, 'YYYYMMDD') as reqDate, category_id, job_id, city, name "+
        "from (select year||to_char(month, '00')||to_char(day, '00') as dateR, category_id, job_id, city, company_id as cid from job) "+
            "JOIN company ON company.company_id = cid "+
        "where name = 'Tata'  ) "+
        "where reqDate >= to_date('2018-01-01', 'YYYY-MM-DD') AND reqDate <= to_date('2021-06-30', 'YYYY-MM-DD') "+
        "GROUP BY to_char(reqDate, 'YYYY'), to_char(reqDate, 'Q'), name "+
        "ORDER BY numCategories Desc) "+
       " NATURAL JOIN "+
        "( select count(employee_id) as empCount, name "+
        "from company_employee NATURAL JOIN company "+
        "where company_id in(select company_id from company where name = 'Tata') "+
        "group by name) "+
        "order by YearN,QuarterN",
        nativeQuery = true)
      List<CompanyDataDto  > findAllCompanys();

    @Query(
    value = "select (numCategories * 10 + JobCount + cityCount * 5 + (empCount/100)) as growthScore, YearN, QuarterN "+
    "from "+
    "( select to_char(reqDate, 'YYYY') as YearN, to_char(reqDate, 'Q') as QuarterN, "+
    "count(distinct category_id) as numCategories, count(job_id) as JobCount, count(distinct city) as cityCount, name "+
   "from "+
    "( select to_date(dateR, 'YYYYMMDD') as reqDate, category_id, job_id, city, name "+
    "from "+    
        "(select year||to_char(month, '00')||to_char(day, '00') as dateR, category_id, job_id, city, company_id as cid from job) "+
        "JOIN company ON company.company_id = cid "+
    "where name = ?1  ) "+
    "where reqDate >= to_date(?2, 'YYYY-MM-DD') AND reqDate <= to_date(?3, 'YYYY-MM-DD') "+
    "GROUP BY to_char(reqDate, 'YYYY'), to_char(reqDate, 'Q'), name "+
    "ORDER BY numCategories Desc) "+
   " NATURAL JOIN "+
    "( select count(employee_id) as empCount, name "+
    "from company_employee NATURAL JOIN company "+
    "where company_id in(select company_id from company where name = ?1) "+
    "group by name) "+
    "order by YearN,QuarterN",
    nativeQuery = true)
  List<CompanyDataDto  > getCompanyByName(String companyName,String startDate,String endDate);

}
