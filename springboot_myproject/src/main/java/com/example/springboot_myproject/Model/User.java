package com.example.springboot_myproject.Model;
import java.time.LocalDateTime;
public class User {
    private Integer id;
    private String email;
    private String password;
    private String salt;
    private String confirmCode;
    private LocalDateTime activationTime; //激活失效时间
    private Byte isValid;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getConfirmCode() {
        return confirmCode;
    }
    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }
    public LocalDateTime getActivationTime() {
        return activationTime;
    }
    public void setActivationTime(LocalDateTime activationTime) {
        this.activationTime = activationTime;
    }
    public Byte getIsValid() {
        return isValid;
    }
    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }
}
