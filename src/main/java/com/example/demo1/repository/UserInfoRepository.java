package com.example.demo1.repository;


import com.example.demo1.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    @Query
    UserInfo findByUsername(String username);
    @Query
    UserInfo findByUid(Integer uid);
    @Query
    void deleteByUid(Integer uid);

}