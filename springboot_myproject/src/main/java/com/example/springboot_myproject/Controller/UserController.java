package com.example.springboot_myproject.Controller;
import com.example.springboot_myproject.Model.User;
import com.example.springboot_myproject.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    //注册账号
    @PostMapping("create")
    public Map<String,Object> createAccount(User user){
        return userService.createdAccount(user);
    }
    @GetMapping("activation")
    public Map<String,Object> activationAccount(String confirmCode){
        return userService.activationAccount(confirmCode);

    }
    //登录
    @PostMapping("login")
    public Map<String,Object> loginAccount(User user){
        return userService.loginin(user);
    }
}
