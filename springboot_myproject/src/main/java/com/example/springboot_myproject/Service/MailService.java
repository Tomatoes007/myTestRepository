package com.example.springboot_myproject.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.ContentDisposition;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.util.Date;
@Service
public class MailService {
    @Value("$spring.mail.username")
    private String mailUsername;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private TemplateEngine templateEngine;
    public void sendMailForActivationAccount(String activationUrl1,String email){
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper message=new MimeMessageHelper(mimeMessage,true);
            //设置邮件主题
            message.setSubject("儿子接旨");
            //设置邮件发送者
            message.setFrom("3189024806@qq.com");
            //设置邮件接受者
            message.setTo(email);
            //设置邮件抄送人

            //设置邮件发送日期
            message.setSentDate(new Date());
            //创建上下文环境
            Context context=new Context();
            context.setVariable("activationUrl",activationUrl1);
            String text= templateEngine.process("LoginRegister/activation-account.html",context);
            //邮件正文
            message.setText(text,true);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
        //邮件发送
        javaMailSender.send(mimeMessage);
    }
}
