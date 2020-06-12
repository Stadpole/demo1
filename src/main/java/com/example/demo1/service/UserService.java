package com.example.demo1.service;

import com.example.demo1.entity.User;
import com.example.demo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 基础登录逻辑

     * @return
     */
    public boolean login(User user){
        List<User> users = userRepository.findAll();
        for (User u: users) {
            if(u.getUserName().equals(user.getUserName()) && u.getHashedPassword().equals(user.getHashedPassword())){
                return true;
            }
        }
        return false;
    }


}