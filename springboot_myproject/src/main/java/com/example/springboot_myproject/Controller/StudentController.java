package com.example.springboot_myproject.Controller;

import com.example.springboot_myproject.Model.Student;
import com.example.springboot_myproject.Model.StudentFuzzyQuery;
import com.example.springboot_myproject.Model.User;
import com.example.springboot_myproject.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class StudentController {
    @Resource
    private StudentService studentService;
    @RequestMapping("index")
    public String index(){

        return ("index");
    }
    @RequestMapping("table")
    public String index_table(){
        return "table";
    }
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryStudentByParams(StudentFuzzyQuery studentFuzzyQuery,String sname,String sno,String sjob){
        System.out.println("Service sname0"+sname);
        return studentService.querystudentbyParams(studentFuzzyQuery,sname,sno,sjob);
    }
    //编辑信息
    @RequestMapping("editform")
    public String index_eiditform(){
        return "editform";
    }
    @RequestMapping("/findSno")
    @ResponseBody
    public List<Map<String,Object>> findBySno(Student student){
        List<Map<String,Object>> stu=studentService.findSno(student);
        return stu;
    }
    @RequestMapping("/findSid")
    @ResponseBody
    public List<Map<String,Object>> findBySid(String ids){
        int sid=Integer.parseInt(ids);
        List<Map<String,Object>> stu=studentService.findSid(sid);
        return stu;
    }
    @RequestMapping("/updateStudent")
    @ResponseBody
    public Map<String,Object> updateStudent(Student student){
        Map<String,Object> resultmap=new HashMap<>();
        List<Map<String,Object>> stu=studentService.findSno(student);
        int a=Integer.parseInt(stu.get(0).get("sid").toString());
        student.setSid(a);
        if(stu.size()>0){
            resultmap=studentService.updateStudent(student);
            resultmap.put("studentDialog",stu);
            return resultmap;
        }else{
            resultmap.put("code",400);
            resultmap.put("message","学号不存在，修改失败");
            return resultmap;
        }
    }
    //添加新用户
    @RequestMapping("addform")
    public String addform(){
        return "addform";
    }
    @PostMapping("/addStudent")
    @ResponseBody
    public Map<String,Object> addForm(Student student){
        Map<String,Object> resultmap=new HashMap<>();
        List<Map<String,Object>> stusno=studentService.findSno(student);
        if(stusno.size()>0){
            resultmap.put("code", 400);
            resultmap.put("message", "学号重复，添加失败");
            return resultmap;
        }else{
            resultmap=studentService.addStudent(student);
            return resultmap;
        }
    }
    //删除单行记录

    @PostMapping("/deleteStudentbyids")
    @ResponseBody
    public Map<String,Object> deleteStudent(String ids){

        return studentService.deleteStudent(ids);
    }
    //删除多条记录
    @PostMapping("/deleteStudentbyids1")
    @ResponseBody
    public Map<String,Object> deleteStudents(String[] ids1){
        Map<String,Object> resultmap=new HashMap<>();
        if(ids1!=null&&ids1.length!=0){
            for(int i=0;i<ids1.length;i++){
                studentService.deleteStudent(ids1[i]);
            }
            resultmap.put("code",200);
            resultmap.put("message","删除成功");
        }else{
            resultmap.put("code",400);
            resultmap.put("message","删除失败");
        }
        return resultmap;
    }
}
