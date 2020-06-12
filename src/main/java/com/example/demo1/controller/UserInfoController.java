package com.example.demo1.controller;

import com.example.demo1.common.utils.DateUtil;
import com.example.demo1.entity.UserInfo;
import com.example.demo1.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController extends BaseCommonController {
    @Autowired
    private UserInfoRepository userInfoService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody UserInfo entity) {
        userInfoService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody UserInfo entity) {
        if (entity.getUid() != null) {
            userInfoService.save(entity);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public UserInfo findOne(String username) {
        UserInfo entity = userInfoService.findByUsername(username);
        return entity;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String Update(@RequestBody UserInfo userInfo) {
         UserInfo entity = userInfoService.findByUsername(userInfo.getUsername());
         entity.setJob(userInfo.getJob());
         userInfoService.save(entity);
        return "success";
    }


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() {
       List<UserInfo> entitys=userInfoService.findAll();
       UserInfo userInfo=entitys.get(0);
       return sendMessage("true", "", userInfo, DateUtil.DATE);
    }
}

