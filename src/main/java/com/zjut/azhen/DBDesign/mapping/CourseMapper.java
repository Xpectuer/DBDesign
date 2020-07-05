package com.zjut.azhen.DBDesign.mapping;

import com.zjut.azhen.DBDesign.bean.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author asus
 */
@Repository
public interface CourseMapper {

    /*
    * TODO:
        4)学生所学课程及；
        7)教师任课查询；
        8)班级课程开设查询。
     * */
    @Results(id="Course" ,value={
            @Result(property = "cno" ,column = "Cno" ,id=true),
            @Result(property = "cname" ,column = "Cname"),
            @Result(property = "cTerm" ,column = "Cterm"),
            @Result(property = "cCredit" ,column = "Ccredit"),
            @Result(property = "cTest",column = "Ctest"),
            @Result(property = "clname" ,column = "Clname")
    })



    //传入空值则查询全部terms

    @Select("{call queryCourseBySno(#{sno ,mode=In},term)}")
    @ResultMap("Course")
    public List<Course> queryCourseBySno(@Param("sno") String sno,@Param("term") String term);

    @Select("{call QueryCourseTeach(#{tno,mode=IN}, #{term ,mode=IN})}")
    @ResultMap("Course")
    public List<Course> queryCourseTeach(@Param("tno") String tno,@Param("term") String term);

    @Select("{call queryCourseByClno(#{clno ,mode=IN},#{term,mode=IN})}")
    public List<Course> queryCourseByClno(@Param("clno") String clno,@Param("term") String term);
}
