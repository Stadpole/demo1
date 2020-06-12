package com.example.demo1.repository;


import com.example.demo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface UserRepository extends JpaRepository<User, String> {
    @Query
    User findByUserName(String userName);
    @Query
    User findById(Integer id);
    @Query
    void deleteById(Integer id);

}