package com.example.springboot_myproject.Service;
import com.example.springboot_myproject.Mapper.Department;
import com.example.springboot_myproject.Model.DepartAndStu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EchartService {
    @Resource
    private Department department;
    public List<DepartAndStu> findDnameStuCount(){
        return department.findDnameStuCount();
    }
    public List<DepartAndStu> findDnameStuCount1(){
        return department.findDnameStuCount1();
    }
}
