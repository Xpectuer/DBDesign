package com.zjut.azhen.DBDesign.mapping;

import com.zjut.azhen.DBDesign.bean.Report;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScoreMapper {
    /*
    * TODO: 1)学生成绩按每学年进行成绩统计；
            2)学生成绩名次排定；
            * 3)学分统计
            4)学生成绩查询；
            5)输入每个学生成绩时，自动生成该学生已修总学分；(trigger)
    * */

    @Results(id="scoreResult" ,value={
            @Result(property = "sno" ,column = "Sno" ,id=true),
            @Result(property = "sname" ,column = "sname" ),
            @Result(property = "cname" ,column = "cname"),
            @Result(property = "tname" ,column = "tname"),
            @Result(property = "clname" ,column = "clname"),
            @Result(property = "term",column = "cterm"),
            @Result(property = "score" ,column = "score")
    })
    @Select("{call scoreByYears(#{sno,mode=IN})}")
    List<Report> getScoreYearsBySno(String sno);

    /**
     *
     * @param term
     * @param mno
     * @return Report List
     */
    @Select("{call CALWTAVGBYSno(#{term ,mode=IN}, #{mno ,mode=IN}")
    @ResultMap("scoreResult")
    List<Report> getRankedScore(String term ,String mno);

    @Select("{call scoreBySno(#sno,mode=IN)}")
    @ResultMap("scoreResult")
    List<Report> getScoreBySno(String sno);

    @Select("select Sno,Sname,Scredit FROM zhengjy_students WHERE Sno='#{sno}';")
    @ResultMap("scoreResult")
    List<Report> getCreditBySno(String sno);



}
