package com.example.springboot_myproject.Controller;
import com.example.springboot_myproject.Model.DepartAndStu;
import com.example.springboot_myproject.Service.EchartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;
@Controller
public class Echart {
    @Resource
    private EchartService echartService;
    @RequestMapping("/GradientBarChart")
//    @ResponseBody
    public String Gradient_bar_chart( ){

        return "GradientBarChart";
    }
    @RequestMapping("/dynamic_bar_chart")
//    @ResponseBody
    public String dynamic_bar_chart( ){

        return "dynamic_bar_chart";
    }
    @RequestMapping("/findDnameStuCount")
    @ResponseBody
    public List<DepartAndStu> findDnameStuCount(){

//        Map<String,Object>  resultmap=

        return echartService.findDnameStuCount();
    }
    @RequestMapping("/findDnameStuCount1")
    @ResponseBody
    public List<DepartAndStu> findDnameStuCount1(){

//        Map<String,Object>  resultmap=
        List<DepartAndStu> list1=echartService.findDnameStuCount();
        List<DepartAndStu> list2=echartService.findDnameStuCount1();

        for(int i=0;i<list2.size();i++){
            list2.get(i).setCount1(list1.get(i).getCount1());
        }
        return list2;
    }
}
