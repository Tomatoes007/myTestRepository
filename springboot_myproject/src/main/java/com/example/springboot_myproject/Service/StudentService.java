package com.example.springboot_myproject.Service;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.springboot_myproject.Mapper.StudentMapper;
import com.example.springboot_myproject.Model.Student;
import com.example.springboot_myproject.Model.StudentFuzzyQuery;
import com.example.springboot_myproject.Model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentService {
    @Resource
    //查询信息
    private StudentMapper studentMapper;
    public Map<String,Object> querystudentbyParams(StudentFuzzyQuery studentFuzzyQuery, String sname, String sno, String sjob){
        Map<String,Object> map=new HashMap<>();
        System.out.println("Service sname1="+sname);
        PageHelper.startPage(studentFuzzyQuery.getPage(),studentFuzzyQuery.getLimit());
        PageInfo<Student> pageInfo=new PageInfo<>(studentMapper.selectFuzzytianming(studentFuzzyQuery,sname,sno,sjob));
        System.out.println("service sname2"+sname);
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
    //添加用户
    public List<Map<String,Object>> findSno(Student student){
        return  this.studentMapper.findSno(student);
    }
    //查询sid
    public List<Map<String,Object>> findSid(int sid){
        return  this.studentMapper.findSid(sid);
    }
    public Map<String,Object> addStudent(Student student){

        Map<String,Object> resultmap=new HashMap<>();
        int result=studentMapper.insertStudent(student);
        if(result>0) {
            resultmap.put("code", 200);
            resultmap.put("message", "添加成功");
        }else {
            resultmap.put("code",400);
            resultmap.put("message","添加失败");
        }
        return resultmap;
    }
    //删除单个用户
    public Map<String,Object> deleteStudent(String ids){
        int sid = Integer.parseInt(ids);
        int result =studentMapper.deleteStudent(sid);
        Map<String,Object> resultmap=new HashMap<>();
        if(result>0) {
            resultmap.put("code", 200);
            resultmap.put("message", "删除成功");
        }else {
            resultmap.put("code",400);
            resultmap.put("message","删除失败");
        }
        return resultmap;
    }
    //删除多个用户
    public void deleteStudents(String ids){

        int sid = Integer.parseInt(ids);
        int result =studentMapper.deleteStudent(sid);
    }
    //编辑信息
    public Map<String,Object> updateStudent(Student student){
        Map<String,Object> resultmap=new HashMap<>();
        int resultUpdate=studentMapper.UpdateStudent(student);
        if(resultUpdate>0) {
            resultmap.put("code", 200);
            resultmap.put("message", "修改成功");
            return resultmap;
        }else {
            resultmap.put("code",400);
            resultmap.put("message","修改失败");
            return resultmap;
        }
    }
}
