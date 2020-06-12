package com.example.demo1.controller;

import com.example.demo1.api.CommonResult;
import com.example.demo1.entity.User;
import com.example.demo1.entity.UserInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseCommonController{

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UserInfo user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456"))
            return CommonResult.success("admin");
        else
            return CommonResult.validateFailed();
    }
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String  login1() {
        Gson gson=new Gson();
      String ss="this is a test fun";
      return gson.toJson(ss);

    }
}