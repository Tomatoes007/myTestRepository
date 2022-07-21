package com.example.springboot_myproject.Service;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.springboot_myproject.Mapper.UserMapper;
import com.example.springboot_myproject.Model.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MailService mailService;
    public Map<String,Object> createdAccount(User user){
        String confirmCode= IdUtil.getSnowflake(1,1).nextIdStr();
        String salt= RandomUtil.randomString(60);
        String md5pwd= SecureUtil.md5(user.getPassword()+salt);
        LocalDateTime ldt=LocalDateTime.now().plusDays(1);
        user.setSalt(salt);
        user.setPassword(md5pwd);
        user.setConfirmCode(confirmCode);
        user.setActivationTime(ldt);
        user.setIsValid((byte)0);
        int result=userMapper.insertUser(user);
        Map<String,Object>resultmap=new HashMap<>();
        if(result>0) {
            String activationUrl = "http://localhost:8089/user/activation?confirmCode=" + confirmCode;
            mailService.sendMailForActivationAccount(activationUrl, user.getEmail());
            resultmap.put("code", 200);
            resultmap.put("message", "注册成功需要激活");
        }else {
            resultmap.put("code",400);
            resultmap.put("message","注册失败");
        }
        return resultmap;
    }
    public Map<String,Object> activationAccount(String confirmCode){
        Map<String,Object> resultmap=new HashMap<>();
        User user= userMapper.selectByConfirmCode(confirmCode);
        boolean after=LocalDateTime.now().isAfter(user.getActivationTime());
        if(after){
            resultmap.put("code",400);
            resultmap.put("message","链接已失效请重新注册");
            return resultmap;
        }
        int result = userMapper.updateUserByConfirmCode(confirmCode);
        if(result>0){
            resultmap.put("code",200);
            resultmap.put("message","激活成功");
        }else{
            resultmap.put("code",400);
            resultmap.put("message","激活失败");
        }
        return resultmap;
    }

    //登录
    public Map<String,Object> loginin(User user){
        Map<String,Object> resultmap=new HashMap<>();
        //根据账号查询用户
        List<User> userList=userMapper.selectUserByEmail(user.getEmail());
        //查询不到，返回账号异常
        if(userList==null||userList.isEmpty()){
            resultmap.put("code",400);
            resultmap.put("message","该用户不存在或未激活");
            return resultmap;
        }
        //查询到多个用户，返回异常
        if (userList.size()>1){
            resultmap.put("code",400);
            resultmap.put("message","账号异常");
            return resultmap;
        }
        //查询到账户
        User u=userList.get(0);
        String md5pwd=SecureUtil.md5(user.getPassword()+u.getSalt());
        if(!u.getPassword().equals(md5pwd)){
            resultmap.put("code",400);
            resultmap.put("message","密码错误");
            return resultmap;
        }
        resultmap.put("code",200);
        resultmap.put("message","登陆成功");
        return resultmap;
    }
}
