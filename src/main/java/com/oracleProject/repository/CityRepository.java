package com.oracleproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.minidev.json.*;
import java.util.*;

import com.oracleproject.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{


    @Query(
        value = "SELECT YEAR, SEMESTER, PERCENT_JOBS, PERCENT_POPULATION_GROWTH "+
        "FROM "+
        "(SELECT P1.YEAR, P1.SEMESTER, (P1.POPULATION_COUNT - P2.POPULATION_COUNT)*100/P2.POPULATION_COUNT AS PERCENT_POPULATION_GROWTH "+
        "FROM "+
        "((SELECT ROWNUM ROW1, YEAR, SEMESTER, POPULATION_COUNT, STATE FROM "+ 
        "(SELECT * FROM POPULATION WHERE STATE = 'Uttar Pradesh' ORDER BY YEAR DESC,SEMESTER DESC)) P1 "+
        "LEFT JOIN "+
        "(SELECT ROWNUM ROW2, YEAR, SEMESTER, POPULATION_COUNT, STATE FROM "+
        "(SELECT * FROM POPULATION WHERE STATE = 'Uttar Pradesh' ORDER BY YEAR DESC,SEMESTER DESC)) P2 "+
        "ON "+
        "P1.ROW1 = P2.ROW2 - 1)) "+
        "JOIN "+
        "(SELECT YEAR AS JYEAR, HALF_YEAR, JOBSINSTATE*100/TOTALJOBS AS PERCENT_JOBS FROM "+
        "(SELECT YEAR, HALF_YEAR, COUNT(JOB_ID) AS JOBSINSTATE FROM "+
        "(SELECT (CASE WHEN MONTH <= 6 THEN 1 "+
        "ELSE 2 "+
        "END) AS HALF_YEAR, JOB_ID, YEAR "+
        "FROM JOB JOIN CITY ON JOB.CITY = CITY.CITY_NAME "+
        "WHERE STATE = 'Uttar Pradesh') "+
        "GROUP BY YEAR, HALF_YEAR) "+
        "NATURAL JOIN "+
        "(SELECT YEAR, HALF_YEAR, COUNT(JOB_ID) AS TOTALJOBS FROM "+
        "(SELECT (CASE WHEN MONTH <= 6 THEN 1 "+
        "ELSE 2 "+
        "END) AS HALF_YEAR, JOB_ID, YEAR "+
        "FROM JOB) "+
        "GROUP BY YEAR, HALF_YEAR)) "+
        "ON JYEAR = YEAR AND HALF_YEAR = SEMESTER "+
        "ORDER BY YEAR, SEMESTER ",
        nativeQuery = true)
      List<JSONObject> getTopStateData();
    

    @Query(
        value = "SELECT "+
        "YEAR, "+
        "SEMESTER, "+
        "PERCENT_JOBS, "+
        "PERCENT_POPULATION_GROWTH "+
    "FROM "+
        "(SELECT "+
            "P1.YEAR, "+
            "P1.SEMESTER, "+
            "(P1.POPULATION_COUNT - P2.POPULATION_COUNT)*100/P2.POPULATION_COUNT AS PERCENT_POPULATION_GROWTH "+
        "FROM "+
            "((SELECT "+
                "ROWNUM ROW1, "+
                "YEAR, "+
                "SEMESTER, "+
                "POPULATION_COUNT, "+
                "STATE "+
            "FROM "+
                "(SELECT "+
                    "* "+
                "FROM "+
                    "\"SH.KUMAR\".POPULATION "+
                "WHERE "+
                    "STATE = ?1 "+
                "ORDER BY "+
                    "YEAR DESC, "+
                    "SEMESTER DESC)) P1 "+
            "LEFT JOIN "+
                "( "+
                    "SELECT "+
                        "ROWNUM ROW2, "+
                        "YEAR, "+
                        "SEMESTER, "+
                        "POPULATION_COUNT, "+
                        "STATE "+
                    "FROM "+
                        "(SELECT "+
                            "* "+
                        "FROM "+
                            "\"SH.KUMAR\".POPULATION "+
                        "WHERE "+
                            "STATE = ?1 "+
                        "ORDER BY "+
                            "YEAR DESC, "+
                            "SEMESTER DESC)) P2 "+
                            "ON P1.ROW1 = P2.ROW2 - 1 "+
                    ") "+
                ") "+
        "JOIN "+
            "( "+
                "SELECT "+
                    "YEAR AS JYEAR, "+
                    "HALF_YEAR, "+
                    "JOBSINSTATE*100/TOTALJOBS AS PERCENT_JOBS "+
                "FROM "+
                    "(SELECT "+
                        "YEAR, "+
                        "HALF_YEAR, "+
                        "COUNT(JOB_ID) AS JOBSINSTATE "+
                    "FROM "+
                        "(SELECT "+
                            "(CASE "+
                                "WHEN MONTH <= 6 THEN 1 "+
                                "ELSE 2 "+
                            "END) AS HALF_YEAR, "+
                            "JOB_ID, "+
                            "YEAR "+
                        "FROM "+
                            "\"SH.KUMAR\".JOB "+
                        "JOIN "+
                            "\"SH.KUMAR\".CITY "+
                                "ON \"SH.KUMAR\".JOB.CITY = \"SH.KUMAR\".CITY.CITY_NAME "+
                        "WHERE "+
                            "STATE = ?1) "+
                    "GROUP BY "+
                        "YEAR, "+
                        "HALF_YEAR) NATURAL "+
                    "JOIN "+
                        "( "+
                            "SELECT "+
                                "YEAR, "+
                                "HALF_YEAR, "+
                                "COUNT(JOB_ID) AS TOTALJOBS "+
                            "FROM "+
                                "(SELECT "+
                                    "(CASE "+
                                        "WHEN MONTH <= 6 THEN 1 "+
                                        "ELSE 2 "+
                                    "END) AS HALF_YEAR, "+
                                    "JOB_ID, "+
                                    "YEAR "+
                                "FROM "+
                                    "\"SH.KUMAR\".JOB) "+
                            "GROUP BY "+
                                "YEAR, "+
                                "HALF_YEAR) "+
                        ") "+
                            "ON JYEAR = YEAR "+
                            "AND HALF_YEAR = SEMESTER "+
                    "WHERE "+
                        "( "+
                            "YEAR*10 + SEMESTER "+
                        ")>= ?3*10 + ?2 "+
                        "AND ( "+
                            "YEAR*10 + SEMESTER "+
                        ")>= 20182 "+
                        "AND ( "+
                            "YEAR*10 + SEMESTER "+
                        ")<= ?5 * 10 + ?4 "+
                    "ORDER BY "+
                        "YEAR, "+
                        "SEMESTER",
        nativeQuery = true)
  List<JSONObject> getStateDataByName(String stateName,int startSem,int startYear,int endSem,int endYear);

}
