package com.example.springboot_myproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {
    @GetMapping("registry")
    public String registry(){
        return "LoginRegister/registry";
    }

    @GetMapping("activationAccount")
    public String activaion_account(){
        return "LoginRegister/activation-account";
    }
    @GetMapping("login")
    public String login(){
        return "LoginRegister/login";
    }
}
