package com.example.demo1.repository;


import com.example.demo1.entity.UserInfo;
import com.example.demo1.entity.UserInfo2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface UserInfoRepository2 extends JpaRepository<UserInfo2, String> {
    @Query
    UserInfo2 findByUsername(String username);
    @Query
    UserInfo2 findByUid(Integer uid);
    @Query
    void deleteByUid(Integer uid);

}