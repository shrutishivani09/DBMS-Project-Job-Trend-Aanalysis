package com.oracleproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oracleproject.entity.SkillSet;
import net.minidev.json.*;
import java.util.*;

@Repository
public interface SkillSetRepository extends JpaRepository<SkillSet, Long>{


    @Query(
        value = "WITH "+
        "groups(POSTED_ON, dateMinusRow) AS ( "+
          "SELECT "+
            "trunc(TO_DATE(POSTED_ON, 'YYYYMMDD'), 'month') AS POSTED_ON, "+
            "trunc(TO_DATE(POSTED_ON, 'YYYYMMDD'), 'month') - INTERVAL '1' MONTH * DENSE_RANK() OVER (ORDER BY trunc(TO_DATE(POSTED_ON, 'YYYYMMDD'), 'month')) dateMinusRow "+
          "FROM "+
              " (SELECT JOB.JOB_ID, COMPANY_ID, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
              "FROM JOB JOIN JOB_SKILL_SET ON JOB.JOB_ID = JOB_SKILL_SET.JOB_ID "+
              "WHERE SKILL_ID IN (SELECT SKILL_ID FROM SKILL_SET WHERE SKILL_SET.SKILL_NAME = 'Java')) "+
          "GROUP BY (trunc((TO_DATE(POSTED_ON, 'YYYYMMDD')), 'month')) HAVING COUNT(*) >= 1 "+
          "), "+
          "groups2(POSTED_ON2, dateMinusRow2) AS ( "+
          "SELECT "+
            "trunc(TO_DATE(POSTED_ON, 'YYYYMMDD'), 'month') AS POSTED_ON2, "+
            "trunc(TO_DATE(POSTED_ON, 'YYYYMMDD'), 'month') - INTERVAL '1' MONTH * DENSE_RANK() OVER (ORDER BY trunc(TO_DATE(POSTED_ON, 'YYYYMMDD'), 'month')) dateMinusRow2 "+
          "FROM "+ 
              "(SELECT JOB.JOB_ID, COMPANY_ID, YEAR||TO_CHAR(MONTH, '00')||TO_CHAR(DAY, '00') AS POSTED_ON "+
              "FROM JOB JOIN JOB_SKILL_SET ON JOB.JOB_ID = JOB_SKILL_SET.JOB_ID "+
              "WHERE SKILL_ID IN (SELECT SKILL_ID FROM SKILL_SET WHERE SKILL_SET.SKILL_NAME = 'Communication')) "+
          "GROUP BY (trunc((TO_DATE(POSTED_ON, 'YYYYMMDD')), 'month')) HAVING COUNT(*) >= 1 "+
          " ) "+
      
      "select * from (select ROWNUM r3 ,startDate,endDate from( "+
      "SELECT "+
          "COUNT(*) AS Streak, "+
          "MIN(POSTED_ON) as startDate, "+
          "MAX(POSTED_ON) as endDate "+
      "FROM groups  "+
      "GROUP BY dateMinusRow "+
      "ORDER BY endDate) ) t1 full outer join ( "+
      "select ROWNUM r4,startDate2,endDate2 from( "+
      "SELECT  "+
          "COUNT(*) AS Streak2, "+
          "MIN(POSTED_ON2) as startDate2, "+
          "MAX(POSTED_ON2) as endDate2 "+
      "FROM groups2 "+
      "GROUP BY dateMinusRow2 "+
      "ORDER BY endDate2) ) t2 "+
      "on t1.r3= t2.r4 ",
        nativeQuery = true)
      List<JSONObject  > getAllSkill();

    @Query(
        value = "WITH GROUPS(POSTED_ON, dateMinusRow) AS "+ 
        "( "+ 
            "SELECT "+
                "TRUNC(TO_DATE(POSTED_ON, "+
                "'YYYYMMDD'),"+
                "'month') AS POSTED_ON,"+
                "TRUNC(TO_DATE(POSTED_ON,"+
                "'YYYYMMDD'),"+
                "'month') - INTERVAL '1' MONTH * DENSE_RANK() OVER ( "+
            "ORDER BY "+
                "TRUNC(TO_DATE(POSTED_ON, "+
                "'YYYYMMDD'), "+
                "'month')) dateMinusRow "+
            "FROM "+
                "(SELECT "+
                    "\"SH.KUMAR\".JOB.JOB_ID, "+
                    "COMPANY_ID, "+
                    "YEAR||TO_CHAR(MONTH, "+
                    "'00')||TO_CHAR(DAY, "+
                    "'00') AS POSTED_ON "+
                "FROM "+
                    "\"SH.KUMAR\".JOB "+
                "JOIN "+
                    "\"SH.KUMAR\".JOB_SKILL_SET "+
                        "ON \"SH.KUMAR\".JOB.JOB_ID = \"SH.KUMAR\".JOB_SKILL_SET.JOB_ID "+
                "WHERE "+
                    "SKILL_ID IN (SELECT "+
                        "SKILL_ID "+
                    "FROM "+
                        "\"SH.KUMAR\".SKILL_SET "+
                    "WHERE "+
                        "\"SH.KUMAR\".SKILL_SET.SKILL_NAME = ?1)) "+
            "GROUP BY "+
                "(TRUNC((TO_DATE(POSTED_ON, "+
                "'YYYYMMDD')), "+
                "'month')) "+
            "HAVING "+
                "COUNT(*) >= 1 "+
        "), "+
                    
        "GROUPS2(POSTED_ON2, dateMinusRow2) AS "+ 
        "( "+ 
                "SELECT "+
                    "TRUNC(TO_DATE(POSTED_ON, "+
                    "'YYYYMMDD'), "+
                    "'month') AS POSTED_ON2,"+
                    "TRUNC(TO_DATE(POSTED_ON,"+
                    "'YYYYMMDD'),"+
                    "'month') - INTERVAL '1' MONTH * DENSE_RANK() OVER ( "+
                "ORDER BY "+
                    "TRUNC(TO_DATE(POSTED_ON, "+
                    "'YYYYMMDD'), "+
                    "'month')) dateMinusRow2 "+
                "FROM "+
                    "(SELECT "+
                        "\"SH.KUMAR\".JOB.JOB_ID, "+
                        "COMPANY_ID, "+
                        "YEAR||TO_CHAR(MONTH, "+
                        "'00')||TO_CHAR(DAY, "+
                        "'00') AS POSTED_ON "+
                    "FROM "+
                        "\"SH.KUMAR\".JOB "+
                    "JOIN "+
                        "\"SH.KUMAR\".JOB_SKILL_SET "+
                            "ON \"SH.KUMAR\".JOB.JOB_ID = \"SH.KUMAR\".JOB_SKILL_SET.JOB_ID "+
                    "WHERE "+
                        "SKILL_ID IN (SELECT "+
                            "SKILL_ID "+
                        "FROM "+
                            "\"SH.KUMAR\".SKILL_SET "+
                        "WHERE "+
                            "\"SH.KUMAR\".SKILL_SET.SKILL_NAME = ?2)) "+
                "GROUP BY "+
                    "(TRUNC((TO_DATE(POSTED_ON, "+
                    "'YYYYMMDD')), "+
                    "'month')) "+
                "HAVING "+
                    "COUNT(*) >= 1 "+  
        ") "+ 
                    "SELECT "+
                        "* "+
                    "FROM "+
                        "(SELECT "+
                            "ROWNUM r3 , "+
                            "startDate, "+
                            "endDate "+
                        "FROM "+
                            "( SELECT "+
                                "COUNT(*) AS Streak, "+
                                "MIN(POSTED_ON) as startDate, "+
                                "MAX(POSTED_ON) as endDate "+
                            "FROM "+
                                "GROUPS "+
                            "WHERE POSTED_ON >= TO_DATE(?3, 'YYYY-MM-DD') AND POSTED_ON <= TO_DATE(?4, 'YYYY-MM-DD') "+
                            "GROUP BY "+
                                "dateMinusRow "+
                            "ORDER BY "+
                                "endDate) "+ 
                        ") t1 "+
                    "FULL OUTER JOIN "+
                        "(SELECT "+
                                    "ROWNUM r4, "+
                                    "startDate2, "+
                                    "endDate2 "+
                            "FROM "+
                                    "( SELECT "+
                                        "COUNT(*) AS Streak2, "+
                                        "MIN(POSTED_ON2) as startDate2, "+
                                        "MAX(POSTED_ON2) as endDate2 "+
                                    "FROM "+
                                        "GROUPS2 "+
                                    "WHERE POSTED_ON2 >= TO_DATE(?3, 'YYYY-MM-DD') AND POSTED_ON2 <= TO_DATE(?4, 'YYYY-MM-DD') "+
                                    "GROUP BY "+
                                        "dateMinusRow2 "+
                                    "ORDER BY "+
                                        "endDate2) "+ 
                        ") t2 "+
                    "ON t1.r3= t2.r4 ",
        nativeQuery = true)
      List<JSONObject  > getSkillByName(String skillName,String SkillName2,String startDate,String endDate);


}
