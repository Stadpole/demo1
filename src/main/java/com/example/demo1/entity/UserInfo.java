package com.example.demo1.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Stadpole on 2017/12/19.
 */
@Entity
public class UserInfo{
    @Id
    @GeneratedValue
    private Integer uid;
    @Column(unique =true)
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    // private String randomText;
    // private Date lastSendRandomTime;
    private String job;//用户职位
    private Integer gender;//用户性别
    private String phone;//用户手机号
    private String email;//用户邮箱
    @Transient
    private List<UserInfo2> userInfo2s;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserInfo2> getUserInfo2s() {
        return userInfo2s;
    }

    public void setUserInfo2s(List<UserInfo2> userInfo2s) {
        this.userInfo2s = userInfo2s;
    }
}