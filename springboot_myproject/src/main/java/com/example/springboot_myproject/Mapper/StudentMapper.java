package com.example.springboot_myproject.Mapper;
import com.example.springboot_myproject.Model.Student;
import com.example.springboot_myproject.Model.StudentFuzzyQuery;
import com.example.springboot_myproject.Model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;
@Mapper
public interface StudentMapper {
    //查询所有信息
    @Select("<script> select * from student " +
            "<where>" +
            "<if test='  sname != null  '> and sname like CONCAT('%',#{sname},'%')</if>" +
            "<if test='  sno != null  '> and sno like CONCAT('%',#{sno},'%')</if>" +
            "<if test='  sjob != null  '> and sjob like CONCAT('%',#{sjob},'%')" +
            "</if></where></script>")
    List<Student> selectFuzzytianming(StudentFuzzyQuery studentFuzzyQuery , @Param("sname") String sname, @Param("sno") String sno, @Param("sjob") String sjob);
    //根据sid编辑学生信息
    @Update("update student set sno = #{sno}, sname = #{sname}, sjob = #{sjob}, stel = #{stel},sdid = #{sdid} where sid = #{sid}")
    public Integer UpdateStudent(Student student);
    //添加新用户
    @Insert("INSERT INTO student(sno,sname,sjob,stel,sdid) VALUES(#{sno},#{sname},#{sjob},#{stel},#{sdid})")
    int insertStudent(Student student);
    //根据学号查询
    @Select("select * from student where sno= #{sno}")
    public List<Map<String,Object>> findSno(Student student);
    //根据sid查询
    @Select("select * from student where sid= #{sid}")
    public List<Map<String,Object>> findSid(int sid);
    //删除用户
    @Delete("DELETE FROM student WHERE sid = #{sid}")
    int deleteStudent(int sid);
}
