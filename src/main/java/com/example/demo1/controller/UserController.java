package com.example.demo1.controller;


import com.example.demo1.entity.User;
import com.example.demo1.entity.UserInfo;
import com.example.demo1.repository.UserRepository;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Stadpole on 2020/4/21.
 */
@RestController
@RequestMapping(value = "")
public class UserController extends BaseCommonController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean login(@RequestBody User user){
        return userService.login(user);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody User user) {
        userRepository.save(user);
        return sendSuccessMessage();
    }
}

