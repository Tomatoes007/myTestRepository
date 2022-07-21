package com.example.springboot_myproject.Mapper;
import com.example.springboot_myproject.Model.DepartAndStu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface Department {
    @Select("select dname, count(sid) count1 " +
            "from department  inner join student " +
            "on department.did=student.sdid " +
            "group by did")
    List<DepartAndStu> findDnameStuCount();
    @Select("SELECT\n" +
            "\tdid,\n" +
            "\tdname,\n" +
            "\tCOUNT( sjob ) count2 \n" +
            "FROM\n" +
            "\tdepartment\n" +
            "\tinner JOIN student ON department.did = student.sdid \n" +
            "WHERE\n" +
            "\tsjob = '干事' \n" +
            "GROUP BY\n" +
            "\tdid")
    List<DepartAndStu> findDnameStuCount1();
}
