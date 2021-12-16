package com.oracleproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  com.oracleproject.dto.ReviewDataDto;

import com.oracleproject.entity.Review;
import java.util.*;
import net.minidev.json.*;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

    
    @Query(
    value = "Select year as reviewYear, month as reviewMonth, round(avg(rating),2) as timeline, "+
              "round(avg(avgSR),2) as avgScoreReview from( "+
                "select company_ID , rating , score,(score+rating)/2 as avgSR, extract(month from post_date)as MONTH "+
              ", extract(Year from post_date)as YEAR from ( "+
              "(select review_id from review "+
                 "MINUS   "+
                "select review_id from review where abs(rating-score)>=.90 "+
             ") r "+
                "join review on review.review_id = r.review_id) "+  
                "where company_Id "+
              "IN (Select company_Id from company where name = 'Cognizant') "+
              "and post_date >= to_date('2012-01-01', 'YYYY-MM-DD') "+
             "AND post_date <= to_date('2021-12-31', 'YYYY-MM-DD')) "+
              "group by Month,Year "+
              "order by year, month ",
    nativeQuery = true)
  List<JSONObject  > findAllReviews();

  @Query(
    value =
              "SELECT "+
                  "YEAR AS REVIEWYEAR, "+
                  "MONTH AS REVIEWMONTH, "+
                  "COUNT(REVIEW_ID) AS FINALCOUNT, "+
                  "ROUND(AVG(RATING), "+
                  "2) AS TIMELINE, "+
                  "ROUND(AVG(AVGSR), "+
                  "2) AS AVGSCOREREVIEW "+
              "FROM "+
                  "( SELECT "+
                      "REVIEW.REVIEW_ID, "+
                      "COMPANY_ID , "+
                      "RATING , "+
                      "SCORE, "+
                      "(SCORE+RATING)/2 AS AVGSR, "+
                      "EXTRACT(MONTH "+
                  "FROM "+
                      "POST_DATE)AS MONTH , "+
                      "EXTRACT(YEAR "+
                  "FROM "+
                      "POST_DATE)AS YEAR "+
                  "FROM "+
                      "( (SELECT "+
                          "REVIEW_ID "+
                      "FROM "+
                          "\"SH.KUMAR\".REVIEW MINUS   SELECT "+
                              "REVIEW_ID "+
                          "FROM "+
                              "\"SH.KUMAR\".REVIEW "+
                          "WHERE "+
                              "ABS(RATING-SCORE)>=.90 ) R "+
                      "JOIN "+
                          "\"SH.KUMAR\".REVIEW "+
                              "ON REVIEW.REVIEW_ID = R.REVIEW_ID) "+
                  "WHERE "+
                      "COMPANY_ID IN ( "+
                          "SELECT "+
                              "COMPANY_ID "+
                          "FROM "+
                              "\"SH.KUMAR\".COMPANY "+
                          "WHERE "+
                              "NAME = ?1 "+
                      ") "+
                      "AND POST_DATE >= TO_DATE(?2, 'YYYY-MM-DD') "+
                      "AND POST_DATE <= TO_DATE(?3, 'YYYY-MM-DD') "+
                  ") "+
              "GROUP BY "+
                  "MONTH, "+
                  "YEAR "+
              "HAVING "+
                  "COUNT(REVIEW_ID) >2 ORDER "+
              "BY "+
                  "YEAR, "+
                  "MONTH",
    nativeQuery = true)
  List<JSONObject  > getReviewByName(String companyId,String startDate,String endDate);

  @Query(
    value ="select sum(num_rows)as countTotal from (SELECT table_name,num_rows FROM all_tables WHERE owner = 'SH.KUMAR')",
                nativeQuery = true )
  List<JSONObject> getTotal();
}
