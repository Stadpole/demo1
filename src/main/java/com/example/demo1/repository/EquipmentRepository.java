package com.example.demo1.repository;


import com.example.demo1.entity.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface EquipmentRepository extends JpaRepository<Equipment, String> {
@Query
public Equipment findById(Integer id);
@Query
public void deleteById(Integer id) ;
Page<Equipment> findAll(Pageable pageable);
}